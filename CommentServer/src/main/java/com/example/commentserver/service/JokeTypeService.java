package com.example.commentserver.service;

import com.example.commentserver.bean.JokeType;
import com.example.commentserver.bean.RestBean;
import com.example.commentserver.config.CodeConfig;
import com.example.commentserver.dao.JokeRepository;
import com.example.commentserver.dao.JokeTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JokeTypeService {
    @Autowired
    JokeTypeRepository jokeTypeRepository;
    public RestBean findAllJokeType()
    {
        List<JokeType> jokeTypes = jokeTypeRepository.findAll();
        for(int i= 0;i<jokeTypes.size();i++)
        {
            JokeType joke = jokeTypes.get(i);
        }
        return  new RestBean(CodeConfig.SUCCESSCODE,jokeTypes);
    }
}
