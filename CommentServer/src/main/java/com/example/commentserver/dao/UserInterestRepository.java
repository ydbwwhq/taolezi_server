package com.example.commentserver.dao;

import com.example.commentserver.bean.UserInterest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserInterestRepository extends JpaRepository<UserInterest,Integer>{


    @Modifying
    @Transactional
    @Query("update UserInterest u set u.preference = ?1 where  u.userID = ?2 and u.interest = ?3")
    int updateUserInterest(int preference,int userid,int interest);

    @Modifying
    @Transactional
    @Query("update UserInterest u set u.preference = ?1 where  u.deviceid = ?2 and u.interest = ?3")
    int updateUserInterest(int preference,String deviceid,int interest);


    UserInterest findByUserIDAndInterest(int userid,int iterest);

    UserInterest findByDeviceidAndInterest(String deviceid,int interest);

    List<UserInterest> findByUserIDOrderByPreference(int userID);
    List<UserInterest> findByDeviceidOrderByPreference(String deviceid);
    List<UserInterest> findByUserIDOrDeviceidOrderByPreference(int userID,String deviceid);
}
