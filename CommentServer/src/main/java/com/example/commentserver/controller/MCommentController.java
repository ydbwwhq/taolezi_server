package com.example.commentserver.controller;

import com.example.commentserver.bean.Comment;
import com.example.commentserver.bean.RestBean;
import com.example.commentserver.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping(value = "/comment",method = RequestMethod.POST)
public class MCommentController {

    @Autowired
    CommentService commentService;

    @RequestMapping(value = "/add")
    RestBean addNewComment(@RequestBody Comment comment)
    {
        return commentService.addComment(comment);
    }

    @RequestMapping(value = "/detail")
    RestBean getCommentDetail(@RequestBody Map map)
    {
        int userid = (int)map.get("userid");
        int page = (int)map.get("page");
        int commetid = (int)map.get("commentid");

      //  int userid = (int)map.getOrDefault("userid",0);
       // int page =(int)map.getOrDefault("page",0);
        //int commetid = (int)map.getOrDefault("commentid",0);
        return commentService.getCommentDetail(userid,page,commetid);
    }

    @RequestMapping(value = "/relate")
    RestBean getRelatedComment(@RequestBody Map map)
    {
//        int userid = (int)map.getOrDefault("userid",0);
//        int page =(int)map.getOrDefault("page",0);


        int userid = (int)map.get("userid");
        int page = (int)map.get("page");
        return commentService.getRelatedComment(userid,page);
    }
}
