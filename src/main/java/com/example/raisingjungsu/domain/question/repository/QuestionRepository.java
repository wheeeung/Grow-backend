package com.example.raisingjungsu.domain.question.repository;

import com.example.raisingjungsu.domain.question.domain.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Integer> {
    List<Question> findByTitleContaining(String keyword);
}
