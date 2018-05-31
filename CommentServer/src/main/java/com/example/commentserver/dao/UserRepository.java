package com.example.commentserver.dao;

import com.example.commentserver.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Integer>{

    User findByDeviceid(String deviceid);

    User findByUserid(int userid);
    @Modifying
    @Transactional
    @Query("update User u set u.usericon = ?1  where u.userid = ?2")
    int updateUserIcon(String usericon,int userid);

    @Modifying
    @Transactional
    @Query("update User u set u.nickname = ?1 where  u.userid = ?2")
    int updateUserName(String userName,int userid);

    @Modifying
    @Transactional
    @Query("update User u set u.sex = ?1 where  u.userid = ?2")
    int updateUserSex(int sex,int userid);


}
