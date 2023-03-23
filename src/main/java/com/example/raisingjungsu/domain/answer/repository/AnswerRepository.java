package com.example.raisingjungsu.domain.answer.repository;

import com.example.raisingjungsu.domain.answer.domain.Answer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswerRepository extends JpaRepository<Answer, Integer> {
}
