package com.example.commentserver.service;

import com.example.commentserver.bean.Joke;
import com.example.commentserver.bean.RestBean;
import com.example.commentserver.bean.User;
import com.example.commentserver.config.CodeConfig;
import com.example.commentserver.config.CommonConfig;
import com.example.commentserver.dao.CommentRepository;
import com.example.commentserver.dao.JokeRepository;
import com.example.commentserver.dao.UserRepository;
import com.example.commentserver.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    JokeRepository jokeRepository;
    @Autowired
    CommentRepository commentRepository;

    public RestBean login(int userid,String pwd)
    {
        User user = userRepository.findByUserid(userid);
        if(user == null)
        {
            return new RestBean(101,"","账号不存在");
        }else
        {
            if(user.getPassword().equals(pwd))
            {
                return new RestBean(100,user);
            }
            return new RestBean(102,"","密码错误");

        }
    }
    public RestBean findUserByID(int id)
    {
        User user = userRepository.findByUserid(id);
        System.out.println(user.getNickname());
        if(user == null)
        {
            return new RestBean(101);
        }else
        {
            return new RestBean(100,user);
        }
    }
    public RestBean updateUser(User param)
    {
        User updateUser = param;
        int result = 0;
        if(updateUser.getNickname() != null)
        {
           result = userRepository.updateUserName(updateUser.getNickname(),updateUser.getUserid());
           if(result == 1)
           {
               jokeRepository.updateJokeUserName(updateUser.getNickname(),updateUser.getUserid() + "");
               commentRepository.updateUserName(updateUser.getUserid(),updateUser.getNickname());
               commentRepository.updateReplyUserName(updateUser.getUserid(),updateUser.getNickname());
           }
        }
        if(updateUser.getUsericon() != null)
        {
          //  System.out.println(updateUser.getUsericon());
           result = userRepository.updateUserIcon(updateUser.getUsericon(),updateUser.getUserid());
        }
        if(updateUser.getSex() == 0 || updateUser.getSex() == 1)
        {
            result = userRepository.updateUserSex(updateUser.getSex(),updateUser.getUserid());
        }
        if(result == 1)
        {
            return  new RestBean(userRepository.findByUserid(updateUser.getUserid()));
        }
        return new RestBean(101,"");
    }
    public RestBean modifyUserPhoto(MultipartFile file,int userid)
    {
        String fileName =   userid + "_"+ Util.getTimeStamp() + "" +".jpg";
        File f = new File(Util.getUserIconPath() + "/" + fileName);
        try {
            OutputStream out = new FileOutputStream(f);
            FileCopyUtils.copy(file.getInputStream(),out);
        }catch (Exception e)
        {
        }
        int result = userRepository.updateUserIcon(fileName,userid);
        if(result == 1)
        {
            User user = userRepository.findByUserid(userid);
            if(result == 1)
            {
              jokeRepository.updateJokeUserIcon(user.getUsericon(),userid + "");
              commentRepository.updateUserIcon(userid,user.getUsericon());
            }
            return  new RestBean(user);
        }
        return new RestBean(101,"更新头像失败");
    }
    public RestBean registerUser(User param)
    {
        User saveUser = param;
        String deviceid = saveUser.getDeviceid();
        if(deviceid != null)
        {
            System.out.println("deviceID" + deviceid);
            User user = userRepository.findByDeviceid(deviceid);
            if(user != null)
            {
                return new RestBean(CodeConfig.DEVICEREGISTERED,saveUser);
            }
        }
//
//        if(saveUser.getNickname() == null)
//        {
//            saveUser.setNickname("");
//        }
//        if(saveUser.getUsericon() == null)
//        {
//            saveUser.setUsericon("");
//        }


        int userID = Util.generateRandomNum();
        while (userRepository.findByUserid(userID) != null)
        {
            userID = Util.generateRandomNum();
        }

        param.setUserid(userID);
        int index = Util.generateRandomNum(0,30);
        Map map = CommonConfig.USERCONFIG.get(index);
        int sex = (int)map.get("sex");
        String name = (String)map.get("name");
        String icon = (String) map.get("icon");
        saveUser.setUsericon(icon);
        saveUser.setNickname(name);
        saveUser.setSex(sex);

        if(saveUser != null)
        {
           saveUser = userRepository.save(saveUser);
        }
        System.out.println(saveUser.getDeviceid());
        if(saveUser == null)
        {
            return new RestBean(101);
        }else
        {
            return new RestBean(100,saveUser);
        }
    }
}
