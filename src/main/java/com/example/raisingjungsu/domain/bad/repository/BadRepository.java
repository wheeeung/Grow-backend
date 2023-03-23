package com.example.raisingjungsu.domain.bad.repository;

import com.example.raisingjungsu.domain.answer.domain.Answer;
import com.example.raisingjungsu.domain.bad.domain.Bad;
import com.example.raisingjungsu.domain.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BadRepository extends JpaRepository<Bad, Integer> {
    Optional<Bad> findByUserAndAnswer(User user, Answer answer);
}
