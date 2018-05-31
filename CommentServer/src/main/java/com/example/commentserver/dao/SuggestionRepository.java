package com.example.commentserver.dao;

import com.example.commentserver.bean.Suggestion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SuggestionRepository extends JpaRepository<Suggestion,Integer> {
}
