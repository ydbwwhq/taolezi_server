package com.example.commentserver.dao;

import com.example.commentserver.bean.Joke;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;


public interface JokeRepository  extends JpaRepository<Joke,Integer>{


    Page<Joke> findByTypeOrderByTimestampDescOrderDesc(int type,Pageable pageable);
    Page<Joke> findByUserId(String userId,Pageable pageable);
    Page<Joke> findByTypeInOrderByTimestampDescOrderDesc(Collection<Integer> types,Pageable pageable);

    @Modifying
    @Transactional
    @Query("update Joke u set u.commentnum = ?1 where  u.id = ?2")
    int updateJokeCommentNum(int commentNum,int id);

    @Modifying
    @Transactional
    @Query("update Joke u set u.browsenum = ?1 where  u.id = ?2")
    int updateJokeBrowserNum(int browseNumber,int id);


    @Modifying
    @Transactional
    @Query("update Joke u set u.userName = ?1 where  u.userId = ?2")
    int updateJokeUserName(String username,String userid);

    @Modifying
    @Transactional
    @Query("update Joke u set u.userIcon = ?1 where  u.userId = ?2")
    int updateJokeUserIcon(String userIcon,String userid);



}
