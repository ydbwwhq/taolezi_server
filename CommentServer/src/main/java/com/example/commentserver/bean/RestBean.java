package com.example.commentserver.bean;

import com.example.commentserver.config.CodeConfig;
import com.example.commentserver.util.Util;
import org.springframework.web.bind.annotation.ResponseBody;

@ResponseBody
public class RestBean {

    private  int code;
    private  long timestamp;
    private Object data;
    private String msg = "Success";
    private Object otherData;

    public Object getOtherData() {
        return otherData;
    }

    public void setOtherData(Object otherData) {
        this.otherData = otherData;
    }

    public RestBean()
    {
        code = CodeConfig.SUCCESSCODE;
        timestamp = Util.getTimeStamp();
        data = null;
    }
    public RestBean(int code,Object data)
    {
        this.code = code;
        this.data = data;
    }
    public RestBean(int code,Object data,String msg)
    {
        this.code = code;
        this.data = data;
        this.msg  = msg;
    }
    public RestBean(Object data)
    {
        this.data = data;
        this.code = CodeConfig.SUCCESSCODE;
        this.data = data;
    }
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
