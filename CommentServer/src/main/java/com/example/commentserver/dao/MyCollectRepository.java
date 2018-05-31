package com.example.commentserver.dao;

import com.example.commentserver.bean.Joke;
import com.example.commentserver.bean.MyCollect;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MyCollectRepository extends JpaRepository<MyCollect,Integer>{
    Page<MyCollect> findByUserid(int userid, Pageable pageable);
    MyCollect findByJokeidAndAndUserid(int jokeid,int userid);
}
