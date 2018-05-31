package com.example.commentserver.dao;

import com.example.commentserver.bean.Comment;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment,Integer>{
    Page<Comment> findByJokeidOrderByTimestampDesc(int jokeid, Pageable pageable);
    Page<Comment> findByCommentidOrderByTimestampDesc(int commentid,Pageable pageable);
    Page<Comment> findByReplyuseridOrderByTimestampDesc(int userid,Pageable pageable);

    Long countByJokeid(int jokeid);

    @Modifying
    @Transactional
    @Query("update Comment u set u.replycount = ?2 where  u.id = ?1")
    int updateReplyCount(int id,int replycount);



    @Modifying
    @Transactional
    @Query("update Comment u set u.username = ?2 where  u.userid = ?1")
    int updateUserName(int userid,String username);


    @Modifying
    @Transactional
    @Query("update Comment u set u.replyusername = ?2 where  u.replyuserid = ?1")
    int updateReplyUserName(int replyuserid,String replyusername);


    @Modifying
    @Transactional
    @Query("update Comment u set u.usericon = ?2 where  u.userid = ?1")
    int updateUserIcon(int userid,String usericon);
}
