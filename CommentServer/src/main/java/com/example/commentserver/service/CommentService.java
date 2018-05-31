package com.example.commentserver.service;

import com.example.commentserver.bean.Comment;
import com.example.commentserver.bean.Joke;
import com.example.commentserver.bean.RestBean;
import com.example.commentserver.bean.User;
import com.example.commentserver.config.CodeConfig;
import com.example.commentserver.dao.CommentRepository;
import com.example.commentserver.dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class CommentService {
    @Autowired
    CommentRepository commentRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    JokeService jokeService;
    @Autowired
    UserInterestService userInterestService;

    public  List<Comment> getCommentByJokeID(int jokeID,int page,int size)
    {
        Pageable pageable = new PageRequest(page, size);
        Page<Comment> jokes = commentRepository.findByJokeidOrderByTimestampDesc(jokeID,pageable);
        return jokes.getContent();
    }
    public RestBean findCommentsByJokeID(int  jokeID,int page,int size,int userid,String deviceid)
    {
        if(page == 0)
        {
            Joke joke = jokeService.findJokeByID(jokeID);
            if(userid != 0) {
                userInterestService.updateUserInterest(userid, joke.getType());
            }else
            {
                userInterestService.updateDeviceInterest(deviceid,joke.getType());
            }
            if(joke != null)
            {
                int num = joke.getBrowsenum();
                int result =   jokeService.updateJokeBrowseNum(++num,jokeID);
            }
        }
        List<Comment> comments = getCommentByJokeID(jokeID,page,size);
        if(comments.size() < size)
        {
            return  new RestBean(CodeConfig.NODATACODE,comments);
        }else
        {
            return  new RestBean(CodeConfig.SUCCESSCODE,comments);
        }
    }
    public RestBean addComment(Comment comment)
    {

        System.out.println("评论内容为:"+comment.getContent());
        comment.setTimestamp(new Timestamp(System.currentTimeMillis()));

        if(comment.getCommentid() != 0)
        {
            Comment comment1 = commentRepository.findOne(comment.getCommentid());
            if(comment1 != null)
            {
                int count = comment1.getReplycount();

                int result = commentRepository.updateReplyCount(comment1.getId(),++count);
                if(result == 1)
                {
                    System.out.println("更新成功");
                }else
                {
                    System.out.println("更新失败");
                    System.out.println("评论id"+comment1.getId());
                    System.out.println("评论数目"+count);
                }


                int jokeid = comment1.getJokeid();
                Joke joke = jokeService.findJokeByID(jokeid);
                if(joke != null)
                {
                    int num = joke.getCommentnum();
                    int res = jokeService.updateJokeCommentNum(++num,jokeid);

                }else
                {

                }



                User user = userRepository.findByUserid(comment.getUserid());
                comment.setUsericon(user.getUsericon());
                comment.setUsername(user.getNickname());
                comment.setJokeid(comment1.getJokeid());

                comment.setReplyuserid(comment1.getUserid());
                comment.setReplycontent(comment1.getContent());
                comment.setReplyusername(comment1.getUsername());
                Comment comment2 = commentRepository.save(comment);





                if(comment2 != null)
                {
                    return  new RestBean(CodeConfig.SUCCESSCODE,comment2);
                }else {
                    return new RestBean(CodeConfig.FAILURECODE, "回复失败");
                }
            }
            return  new RestBean(CodeConfig.FAILURECODE,"");
        }else
        {
            User user = userRepository.findByUserid(comment.getUserid());
            if(user != null)
            {
                comment.setUsericon(user.getUsericon());
                comment.setUsername(user.getNickname());

                int jokeid = comment.getJokeid();
                Joke joke = jokeService.findJokeByID(jokeid);
                if(joke != null)
                {
                    int num = joke.getCommentnum();
                    int result =  jokeService.updateJokeCommentNum(++num,jokeid);
                }

                Comment resultComment = commentRepository.save(comment);
                if(resultComment != null)
                {
                    return  new RestBean(100,resultComment);
                }else
                {
                    return  new RestBean(CodeConfig.FAILURECODE,"评论失败");
                }
            }else
            {
                return  new RestBean(CodeConfig.FAILURECODE,"用户不存在");
            }
        }
    }
    public Long getAccountByJokeID(int jokeid)
    {
        return commentRepository.countByJokeid(jokeid);
    }


    public RestBean getCommentDetail(int userid,int page,int commentid)
    {
        Pageable pageable = new PageRequest(page,10);
        List<Comment> comments =  commentRepository.findByCommentidOrderByTimestampDesc(commentid,pageable).getContent();
        if(comments.size() == 10)
        {
           return new RestBean(CodeConfig.SUCCESSCODE,comments);
        }else
        {
            return new RestBean(CodeConfig.NODATACODE,comments);
        }
    }
    public RestBean getRelatedComment(int userid,int page)
    {
        Pageable pageable = new PageRequest(page,10);
        List<Comment> comments =  commentRepository.findByReplyuseridOrderByTimestampDesc(userid,pageable).getContent();
        if(comments.size() == 10)
        {
            return new RestBean(CodeConfig.SUCCESSCODE,comments);
        }else
        {
            return new RestBean(CodeConfig.NODATACODE,comments);
        }
    }
}
