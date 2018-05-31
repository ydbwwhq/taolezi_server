package com.example.commentserver.controller;

import com.example.commentserver.util.Util;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;

@RestController

public class FileController {
    @RequestMapping(value = "/imgs/{folder}")
    public void readImg(HttpServletResponse response,  @RequestParam String imgName,@PathVariable String folder) throws Exception
    {
        FileInputStream fis = null;
      //  System.out.println(imgName);
        String path = Util.getImagePath() + "/" + folder +"/"+ imgName;
        System.out.println("Path="+path);
        File file = new File(path);
        fis = new FileInputStream(file);
        response.setContentType("image/jpg"); //设置返回的文件类型
        response.setHeader("Access-Control-Allow-Origin", "*");//设置该图片允许跨域访问
        IOUtils.copy(fis, response.getOutputStream());
    }
}
