package com.example.commentserver.bean;

import com.example.commentserver.config.CommonConfig;
import com.example.commentserver.util.Util;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "joke")
public class Joke {
    @Id
    int id;
    @Column
    String content;
    @Column(name = "user_id")
    String userId;
    @Column(name = "user_icon")
    String userIcon;
    @Column(name = "user_name")
    String userName;
    @Column(name = "is_public")
    int is_public;
    @Column(name = "browse_num")
    int browsenum;
    @Column(name = "img")
    String img;
    @Column(name = "imgw")
    int imgW;
    @Column(name = "imgh")
    int imgH;
    @Column(name = "praise_num")
    int praisenum;
    @Column(name = "comment_num")
    int commentnum;
    @Column(name = "type")
    int type;
    @Column(name = "timestamp")
    Timestamp timestamp;
    @Column(name = "joke_order")
    int order;
    @Column(name = "is_ad")
    boolean isad;


    @Transient
    private List<Comment> comments;

    @Transient
    private String time;
    @Transient
    private boolean isCollected;




    @Column
    private int viewtype;

    @Override
    public String toString() {
        return "ID：" + id + "  viewtype:" + viewtype + "  user_name:" + userName + "  userid:" + userId + "  usericon:" + userIcon + "  type:" + type
                + "  timestamp" + timestamp.getTime() + " praisenum:" + praisenum + " order:" + "order" +  "  imgw:" + imgW +
                "  imgH:" + imgH + " content:" + content + " comment_num" + commentnum + "  browsenum:" + browsenum + " img:" + img;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public String getTime() {
        if(is_public == 1)
        {
            return  "";
        }
        return Util.getTimeDes(timestamp.getTime() / 1000);
    }

    public void setTime(String time) {
        this.time = time;
    }


    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public int getIs_public() {
        return is_public;
    }

    public void setIs_public(int is_public) {
        this.is_public = is_public;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserIcon() {
        if(userIcon == null)
        {
            return  userIcon;
        }
        if (userIcon.startsWith("http") || userIcon.startsWith("https"))
        {
            return userIcon;
        }
        return CommonConfig.SERVER + "/imgs/usericon?imgName=" + userIcon;

    }

    public void setUserIcon(String userIcon) {
        System.out.println("setUserIcon");
        this.userIcon = userIcon;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }



    public String getImg() {
        if (img.startsWith("http") || img.startsWith("https"))
        {
            return img;
        }
        if(img == null || img.length() == 0)
        {
            return  "";
        }
        return CommonConfig.SERVER + "/imgs/content?imgName=" + img;
    }



    public void setImg(String img) {
        this.img = img;
    }

    public int getImgW() {
        return imgW;
    }

    public void setImgW(int imgW) {
        this.imgW = imgW;
    }

    public int getImgH() {
        return imgH;
    }

    public void setImgH(int imgH) {
        this.imgH = imgH;
    }





    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public boolean isCollected() {
        return isCollected;
    }

    public void setCollected(boolean collected) {
        isCollected = collected;
    }

    public int getViewtype() {
        return viewtype;
    }

    public void setViewtype(int viewtype) {
        this.viewtype = viewtype;
    }

    public int getOrder() {
        return order;
    }
    public void setOrder(int order) {
        this.order = order;
    }

    public int getBrowsenum() {
        return browsenum;
    }

    public void setBrowsenum(int browsenum) {
        this.browsenum = browsenum;
    }

    public int getPraisenum() {
        return praisenum;
    }

    public void setPraisenum(int praisenum) {
        this.praisenum = praisenum;
    }

    public int getCommentnum() {
        return commentnum;
    }

    public void setCommentnum(int commentnum) {
        this.commentnum = commentnum;
    }

    public boolean isIsad() {
        return isad;
    }

    public void setIsad(boolean isad) {
        this.isad = isad;
    }
}
