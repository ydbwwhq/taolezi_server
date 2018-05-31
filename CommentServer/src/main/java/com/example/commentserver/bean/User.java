package com.example.commentserver.bean;

import com.example.commentserver.config.CommonConfig;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {
    @Column(name = "userid")
    int userid;
    @Column(name = "nickname")
    String nickname;
    @Column(name = "usericon")
    String usericon;
    @Id
    int id;
    @Column(name = "deviceid")
    String deviceid;
    @Column(name = "password")
    String password;
    @Column(name = "sex")
    int sex;

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getUsericon() {
        if(usericon == null)
        {
            return  usericon;
        }
        if (usericon.startsWith("http") || usericon.startsWith("https"))
        {
            return usericon;
        }
        return CommonConfig.SERVER + "/imgs/usericon?imgName=" + usericon;
    }

    public void setUsericon(String usericon) {
        this.usericon = usericon;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDeviceid() {
        return deviceid;
    }

    public void setDeviceid(String deviceid) {
        this.deviceid = deviceid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
