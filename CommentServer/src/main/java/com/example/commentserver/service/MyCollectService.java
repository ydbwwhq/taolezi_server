package com.example.commentserver.service;

import com.example.commentserver.bean.Joke;
import com.example.commentserver.bean.MyCollect;
import com.example.commentserver.bean.RestBean;
import com.example.commentserver.config.CodeConfig;
import com.example.commentserver.dao.MyCollectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class MyCollectService {
    @Autowired
    MyCollectRepository myCollectRepository;
    @Autowired
    JokeService jokeService;
    public  RestBean collect(MyCollect collect)
    {
        MyCollect myCollect1 = myCollectRepository.findByJokeidAndAndUserid(collect.getJokeid(),collect.getUserid());
        if(myCollect1 != null)
        {
            myCollectRepository.delete(myCollect1.getId());
        }else
        {
            myCollect1 = myCollectRepository.save(collect);
        }
        if(myCollect1 != null)
        {
            return  new RestBean(CodeConfig.SUCCESSCODE,myCollect1);
        }else
        {
            return  new RestBean(CodeConfig.FAILURECODE,"操作失败");
        }
    }

    public RestBean findMyCollect(int userid,int page)
    {
        Pageable pageable = new PageRequest(page, 10);
        List<MyCollect> myCollects = myCollectRepository.findByUserid(userid,pageable).getContent();
        if(myCollects!=null && myCollects.size() > 0)
        {
            System.out.println("查询成功");
            List<Joke> jokes= new ArrayList<>();
            for(int i=0;i<myCollects.size();i++)
            {
                MyCollect myCollect = myCollects.get(i);
                Joke joke = jokeService.findJokeByID(myCollect.getJokeid(),userid);
                jokes.add(joke);
            }
            if(myCollects.size() < 10)
            {
                return new RestBean(CodeConfig.NODATACODE,jokes);
            }else
            {
                return new RestBean(CodeConfig.SUCCESSCODE,jokes);
            }
        }else
        {
            System.out.println("查询失败");
            return new RestBean(CodeConfig.NODATACODE,new ArrayList<>());
        }
    }
    public MyCollect findByJokeIdAndUserID(int jokeid, int userId)
    {
       return  myCollectRepository.findByJokeidAndAndUserid(jokeid,userId);
    }
}
