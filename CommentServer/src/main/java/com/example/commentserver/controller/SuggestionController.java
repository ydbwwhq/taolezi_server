package com.example.commentserver.controller;

import com.example.commentserver.bean.RestBean;
import com.example.commentserver.bean.Suggestion;
import com.example.commentserver.dao.SuggestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class SuggestionController {
    @Autowired
    SuggestionRepository suggestionRepository;

    @RequestMapping(method = RequestMethod.POST,value = "/suggest")
    public RestBean suggest(@RequestBody Suggestion suggestion)
    {
        suggestionRepository.save(suggestion);
        return  new RestBean(100,"提交成功");
    }
}
