package com.example.commentserver.service;

import com.example.commentserver.bean.*;
import com.example.commentserver.config.CodeConfig;
import com.example.commentserver.dao.CommentRepository;
import com.example.commentserver.dao.JokeRepository;
import com.example.commentserver.dao.UserRepository;
import com.example.commentserver.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.lang.reflect.Array;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@Service
public class JokeService {

    @Autowired
    private JokeRepository jokeRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    private CommentService commentService;

    @Autowired
    private MyCollectService myCollectService;

    @Autowired
    UserInterestService userInterestService;

    public RestBean getRecommedJoke(int page, int userid,String deviceid,List<Integer> interestsParam) {
        List<Joke> jokes;
        List<Integer> userInterests;
        List<UserInterest> interests = new ArrayList();

        if(page !=0 &&interestsParam != null && interestsParam.size() > 0)
        {
            userInterests = interestsParam;
        }else
        {
            userInterests = getJokeInterests(interests);
        }
        jokes = getJokes(userInterests,page);
        RestBean restBean = findJokeComment(jokes,userid);
        if(page == 0)
        {
            restBean.setOtherData(userInterests);
        }
        return restBean;
    }


//    public RestBean getRecommedJoke(int page, int userid,String deviceid,List<Integer> interestsParam) {
//        List<Joke> jokes;
//        List<Integer> userInterests;
//        List<UserInterest> interests = new ArrayList();
//
//        if(page !=0 &&interestsParam != null && interestsParam.size() > 0)
//        {
//            userInterests = interestsParam;
//        }else if(userid == 0)
//        {
//            interests = userInterestService.findInterestByDeviceId(deviceid);
//            userInterests = getJokeInterests(interests);
//        }else
//        {
//            interests = userInterestService.findInterestByDeviceidOrUserId(deviceid,userid);
//            userInterests = getJokeInterests(interests);
//        }
//        jokes = getJokes(userInterests,page);
//        RestBean restBean = findJokeComment(jokes,userid);
//        if(page == 0)
//        {
//            restBean.setOtherData(userInterests);
//        }
//        return restBean;
//    }
    public List<Integer> getJokeInterests(List<UserInterest> userInterests)
    {
        List<Integer> tys = new ArrayList<Integer>();
        for(int i=0;i<userInterests.size();i++)
        {
            UserInterest interest = userInterests.get(i);
            if(interest.getPreference() > 10) {
                tys.add(interest.getInterest());
            }
        }
        if(!tys.contains(17))
        {
            tys.add(17);
        }
        while(tys.size() < 10)
        {
            int type = Util.generateRandomNum(1,26);
            if(!tys.contains(type)) {
                tys.add(type);
            }
        }
        return  tys;
    }
    public List<Joke> getJokes(List<Integer>  userInterests,int page)
    {
        Pageable pageable = new PageRequest(page,10);
        return  jokeRepository.findByTypeInOrderByTimestampDescOrderDesc(userInterests,pageable).getContent();
    }

    public RestBean getJokeContent(Map param)
    {
        int userid = (int)param.get("userid");
        int page = (int)param.get("page");
        int type = (int)param.get("type");
        String deviceid = (String) param.get("deviceid");
        List<Integer> interests = (ArrayList<Integer>) param.get("interests") ;
        switch (type)
        {
            case 1000:
                return  getRecommedJoke(page,userid,deviceid,interests);
            case 1001:
                return getHotJoke(page,userid);
            default:
                return getJokeByType(type,userid,page);
        }
    }
    public RestBean getJokeByType(int type,int userid,int page)
        {
        int realType;

        Pageable pageable = new PageRequest(page,10);
        List<Joke> jokes ;
        switch (type)
        {
            case 1002:
            {
               jokes = jokeRepository.findByTypeOrderByTimestampDescOrderDesc(23,pageable).getContent();
            }
            break;
            case 1003:
            {
                jokes = jokeRepository.findByTypeOrderByTimestampDescOrderDesc(24,pageable).getContent();
            }
            break;
            case 1004:
            {
                jokes = jokeRepository.findByTypeOrderByTimestampDescOrderDesc(9,pageable).getContent();
            }
            break;
            case 1005:
            {
                jokes = jokeRepository.findByTypeOrderByTimestampDescOrderDesc(16,pageable).getContent();
            }
            break;
            case 1006:
            {
                jokes = jokeRepository.findByTypeOrderByTimestampDescOrderDesc(25,pageable).getContent();
            }
            break;
            case 1007:
            {
                List<Integer> types = new ArrayList<Integer>(){{
                    add(1);
                    add(2);
                    add(3);
                    add(4);
                    add(5);
                    add(6);
                    add(7);
                    add(8);
                    add(10);
                    add(11);
                    add(12);
                    add(13);
                    add(14);
                    add(15);
                    add(18);
                    add(19);
                    add(20);
                    add(21);
                    add(22);
                }};
                jokes = jokeRepository.findByTypeInOrderByTimestampDescOrderDesc(types,pageable).getContent();
            }break;
            case 1008:
            {
                jokes = jokeRepository.findByTypeOrderByTimestampDescOrderDesc(17,pageable).getContent();
            }
            break;
            default:
                jokes = new ArrayList<>();
        }
        return  findJokeComment(jokes,userid);
    }
    public RestBean getHotJoke(int page,int userid)
    {
        Sort sort = new Sort(Sort.Direction.DESC,"order","commentnum","browsenum","timestamp");
        Pageable pageable = new PageRequest(page,10,sort);
        List<Joke> jokes =jokeRepository.findAll(pageable).getContent();
        return  findJokeComment(jokes,userid);
    }

    public RestBean findJokeByUserID(int page, int userid) {
        Pageable pageable = new PageRequest(page, 10);
        List<Joke> jokes = jokeRepository.findByUserId(userid + "", pageable).getContent();
        return findJokeComment(jokes,userid);
    }
    public Joke findJokeByID(int jokeID) {
        return jokeRepository.findOne(jokeID);
    }
    public int updateJokeBrowseNum(int num,int id)
    {
        return jokeRepository.updateJokeBrowserNum(num,id);
    }
    public int updateJokeCommentNum(int num,int id)
    {
       return jokeRepository.updateJokeCommentNum(num,id);
    }
    public Joke findJokeByID(int jokeID,int userid) {
        Joke joke = jokeRepository.findOne(jokeID);
        if (joke != null) {

           setJokeComment(joke,userid);
           return  joke;
        }else
        {
            System.out.println("段子为空");
        }
        return null;
    }

    public void  setJokeComment(Joke joke,int userid)
    {
       joke.setCollected(myCollectService.findByJokeIdAndUserID(joke.getId(),userid)==null?false:true);
        int id = joke.getId();
        List<Comment> comments = commentService.getCommentByJokeID(id, 0, 3);
        if(comments == null)
            comments = new ArrayList<>();
        joke.setComments(comments);
//        if(!joke.getPublic()) {
//            int id = joke.getId();
//            List<Comment> comments = commentService.getCommentByJokeID(id, 0, 3);
//            if(comments == null)
//                comments = new ArrayList<>();
//            joke.setComments(comments);
//        }else
//        {
//            joke.setComments(new ArrayList<>());
//        }
    }
    public RestBean  findJokeComment(List<Joke> jokes,int userid)
    {
        for (int i = 0; i < jokes.size(); i++) {
            Joke joke = jokes.get(i);
            setJokeComment(joke,userid);
        }

        RestBean restBean;
        if (jokes.size() == 10)
        {
            restBean = new RestBean(100,jokes);
        }else
        {
            restBean = new RestBean(CodeConfig.NODATACODE,jokes);
        }
        return  restBean;
    }
    public RestBean addQuestion(String  userid, String question, MultipartFile file, int width, int height,boolean is_public,int timestamp)
    {
        Joke joke = new Joke();
        String fileName =   userid+"_"+ Util.getTimeStamp() + "" +".jpg";
        File f = new File(Util.getJokeImagePath() + "/" + fileName);
        try {
            OutputStream out = new FileOutputStream(f);
            FileCopyUtils.copy(file.getInputStream(),out);
        }catch (Exception e)
        {
        }
        User user = userRepository.findByUserid(Integer.parseInt(userid));

        joke.setUserName(user.getNickname());
        joke.setImg(fileName);
        joke.setUserId(userid);
        joke.setUserIcon(user.getUsericon());
        joke.setContent(question);
        joke.setImgH(height);
        joke.setImgW(width);
       // joke.setIs_public(0);

        joke.setType(25);
        joke.setViewtype(0);

        //joke.setOrder(5);
        joke.setPraisenum(0);
        joke.setTimestamp(new Timestamp(System.currentTimeMillis()));
        joke.setCommentnum(0);
        joke.setBrowsenum(0);

        System.out.println(joke.toString());
        jokeRepository.save(joke);
        return new RestBean(100,joke);
    }
}
