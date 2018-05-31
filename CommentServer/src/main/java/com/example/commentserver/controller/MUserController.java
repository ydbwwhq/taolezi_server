package com.example.commentserver.controller;

import com.example.commentserver.bean.RestBean;
import com.example.commentserver.bean.User;
import com.example.commentserver.dao.UserRepository;
import com.example.commentserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@RequestMapping("/user")
@RestController
public class MUserController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    RestBean login(@RequestBody Map params)
    {
        int id= (Integer) params.get("userid");
        String pwd = (String) params.get("pwd");
        return userService.login(id,pwd);
    }
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    RestBean register(@RequestBody User user)
    {
        return userService.registerUser(user);
    }
    @RequestMapping(value = "/modify",method = RequestMethod.POST)
    RestBean modify(@RequestBody User user)
    {
        return userService.updateUser(user);
    }

    @RequestMapping(value = "/modifyPhoto",method = RequestMethod.POST)
    RestBean modifyPhoto(@RequestParam(value = "img")MultipartFile file,@RequestParam(value = "userid")int userid)
    {
        return userService.modifyUserPhoto(file,userid);
    }
}
