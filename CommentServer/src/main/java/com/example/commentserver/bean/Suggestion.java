package com.example.commentserver.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "suggestion")
public class Suggestion {
    @Id
    private int id;
    @Column(name = "userid")
    private String userid;
    @Column(name = "content")
    private String content;
    @Column(name = "contact_num")
    private String contact_num;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContact_num() {
        return contact_num;
    }

    public void setContact_num(String contact_num) {
        this.contact_num = contact_num;
    }
}
