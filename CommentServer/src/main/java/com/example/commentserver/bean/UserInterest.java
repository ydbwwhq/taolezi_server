package com.example.commentserver.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Map;

@Entity
@Table(name = "userinterest")
public class UserInterest {
    @Id
    int id;
    @Column(name = "userid")
    int userID;
    @Column(name = "interest")
    int interest;
    @Column(name = "preference")
    int preference;
    @Column(name = "deviceid")
    String deviceid;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserID() {
        return userID;
    }

    public String getDeviceid() {
        return deviceid;
    }

    public void setDeviceid(String deviceid) {
        this.deviceid = deviceid;
    }

    public void setUserID(int userID) {
        this.userID = userID;

    }

    public int getInterest() {
        return interest;
    }

    public void setInterest(int interest) {
        this.interest = interest;
    }

    public int getPreference() {
        return preference;
    }

    public void setPreference(int preference) {
        this.preference = preference;
    }
    public static  UserInterest MapToModel(Map maps)
    {
        UserInterest interest = new UserInterest();
        interest.id = (int)maps.get("id");
        interest.interest = (int)maps.get("interest");
        return  interest;
    }
}
