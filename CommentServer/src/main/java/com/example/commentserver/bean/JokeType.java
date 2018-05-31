package com.example.commentserver.bean;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "joketype")
public class JokeType {
    @Id
    int id;
    @Column(name = "order")
    int order;
    @Column(name = "name")
    String name;
    @Column(name = "type")
    int type;




    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }


}


