package com.example.commentserver.dao;

import com.example.commentserver.bean.JokeType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JokeTypeRepository extends JpaRepository<JokeType,Integer>{
}
