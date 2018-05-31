package com.example.commentserver.controller;

import com.example.commentserver.bean.MyCollect;
import com.example.commentserver.bean.RestBean;
import com.example.commentserver.service.CommentService;
import com.example.commentserver.service.JokeService;
import com.example.commentserver.service.JokeTypeService;
import com.example.commentserver.service.MyCollectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/joke")
public class MController {




    @Autowired
    JokeService jokeService;

    @Autowired
    CommentService commentService;

    @Autowired
    JokeTypeService jokeTypeService;

    @Autowired
    MyCollectService myCollectService;




    @RequestMapping(value = "/ad",method = RequestMethod.GET)
    RestBean getJokeAD()

    {
        Map status = new HashMap();
        status.put("status",false);
        return new RestBean(status);
    }
    @RequestMapping(value = "/content",method = RequestMethod.POST)
    RestBean getJokeContents(@RequestBody Map param)
    {
        return jokeService.getJokeContent(param);
    }
    @RequestMapping(value = "/type")
    RestBean getJokeType()
    {
        return jokeTypeService.findAllJokeType();
    }
    @RequestMapping(value = "/comment",method = RequestMethod.POST)
    RestBean getJokeComments(@RequestBody Map param)
    {
        int userid = (int)param.get("userid");
        int page = (int)param.get("page");
        Object sizeObject = param.get("size");
        int size = 10;
        if(sizeObject != null)
        {
            size = (int)sizeObject;
        }
        int jokeID = (Integer) param.get("id");
        String deviceID = (String) param.get("deviceid");
        return commentService.findCommentsByJokeID(jokeID,page,size,userid,deviceID);
    }
    @RequestMapping(value = "/release",method = RequestMethod.POST)
    RestBean releaseQuestion(@RequestParam(value = "img")MultipartFile file,
                             @RequestParam(value = "question")String question,
                             @RequestParam(value = "userid")String userid,
                             int width,
                             int height,
                             boolean is_public,int timestamp)
    {

        return jokeService.addQuestion(userid,question,file,width,height,is_public,timestamp);
    }
    @RequestMapping(value = "/my",method = RequestMethod.POST)
    RestBean findMyJoke(@RequestBody Map param)
    {
//        int userid = (int)param.getOrDefault("userid",new Integer(0));
//        int page = (int)param.getOrDefault("page",new Integer(0));

        int userid = (int)param.get("userid");
        int page = (int)param.get("page");
        return jokeService.findJokeByUserID(page,userid);
    }
    @RequestMapping(value = "/collect",method = RequestMethod.POST)
    RestBean collectJoke(@RequestBody MyCollect myCollect)
    {

        return myCollectService.collect(myCollect);
    }
    @RequestMapping(value = "/mycollect",method = RequestMethod.POST)
    RestBean mycollectJoke(@RequestBody Map param)
    {
//        int userid = (int)param.getOrDefault("userid",new Integer(0));
//        int page = (int)param.getOrDefault("page",new Integer(0));
        int userid = (int)param.get("userid");
        int page = (int)param.get("page");
        return myCollectService.findMyCollect(userid,page);
    }
}
