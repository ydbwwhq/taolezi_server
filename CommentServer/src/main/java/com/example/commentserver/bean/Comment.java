package com.example.commentserver.bean;


import com.example.commentserver.config.CommonConfig;
import com.example.commentserver.util.Util;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "comment")
public class Comment {
    @Id
    int id;
    @Column
    String content;
    @Column(name = "userid")
    int userid;
    @Column(name = "jokeid")
    int jokeid;
    @Column(name = "commentid")
    int commentid;
    @Column(name = "username")
    String username;
    @Column(name = "usericon")
    String usericon;
    @Column(name = "timestamp")
    Timestamp timestamp;
    @Column(name = "replycount")
    int replycount;
    @Column(name="replyuserid")
    int replyuserid;
    @Column(name = "replyusername")
    String replyusername;
    @Column(name = "replycontent")
    String replycontent;




    public Timestamp getTimestamp() {

        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    @Transient
    private String time;

    public String getTime() {

        return  Util.getTimeDes(timestamp.getTime()/1000);
    }

    public void setTime(String time) {
        this.time = time;
    }



    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        //return Util.decodeBase64(content);
        return  content;
    }

    public void setContent(String content) {
        //this.content = Util.encodeBase64(content);
        this.content = content;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getJokeid() {
        return jokeid;
    }

    public void setJokeid(int jokeid) {
        this.jokeid = jokeid;
    }

    public int getCommentid() {
        return commentid;
    }

    public void setCommentid(int commentid) {
        this.commentid = commentid;
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

    public int getReplycount() {
        return replycount;
    }

    public void setReplycount(int replycount) {
        this.replycount = replycount;
    }

    public int getReplyuserid() {
        return replyuserid;
    }

    public void setReplyuserid(int replyuserid) {
        this.replyuserid = replyuserid;
    }

    public String getReplyusername() {
        return replyusername;
    }

    public void setReplyusername(String replyusername) {
        this.replyusername = replyusername;
    }

    public String getReplycontent() {
        return replycontent;
    }

    public void setReplycontent(String replycontent) {
        this.replycontent = replycontent;
    }
}
