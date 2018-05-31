package com.example.commentserver.bean;

import javax.persistence.*;

@Entity
@Table(name = "mycollect")
public class MyCollect {
    @Id
    int id;
    @Column(name = "userid")
    int userid;
    @Column(name = "jokeid")
    int jokeid;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
}
