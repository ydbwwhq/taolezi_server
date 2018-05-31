package com.example.commentserver.service;

import com.example.commentserver.bean.UserInterest;
import com.example.commentserver.dao.UserInterestRepository;
import com.example.commentserver.dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserInterestService {
    @Autowired
    UserInterestRepository userInterestRepository;

    public void updateUserInterest(int userid,int interest)
    {
       UserInterest userInterest =  userInterestRepository.findByUserIDAndInterest(userid,interest);
       if(userInterest == null)
       {
           userInterest = new UserInterest();
           userInterest.setInterest(interest);
           userInterest.setUserID(userid);
           UserInterest interest1 = userInterestRepository.save(userInterest);
           if(interest1 == null)
           {
               System.out.println("保存失败");
           }else
           {
               System.out.println("保存成功");
           }
       }else
       {

           int preference = userInterest.getPreference();
           userInterestRepository.updateUserInterest(++ preference,userid,interest);
       }
    }

    public void updateDeviceInterest(String deviceid,int interest)
    {
        UserInterest userInterest =  userInterestRepository.findByDeviceidAndInterest(deviceid,interest);
        if(userInterest == null)
        {
            userInterest = new UserInterest();
            userInterest.setInterest(interest);
            userInterest.setDeviceid(deviceid);
            UserInterest interest1 = userInterestRepository.save(userInterest);
            if(interest1 == null)
            {
                System.out.println("保存失败");
            }else
            {
                System.out.println("保存成功");
            }
        }else
        {

            int preference = userInterest.getPreference();
            userInterestRepository.updateUserInterest(++ preference,deviceid,interest);
        }
    }
    public List<UserInterest> findInterestByUserId(int userID)
    {
       return userInterestRepository.findByUserIDOrderByPreference(userID);
    }
    public List<UserInterest> findInterestByDeviceId(String deviceid)
    {
        return userInterestRepository.findByDeviceidOrderByPreference(deviceid);
    }
    public List<UserInterest> findInterestByDeviceidOrUserId(String deviceid,int userid)
    {
        return userInterestRepository.findByUserIDOrDeviceidOrderByPreference(userid,deviceid);
    }
}
