package com.example.raisingjungsu.domain.answer.domain;

import com.example.raisingjungsu.domain.question.domain.Question;
import com.example.raisingjungsu.domain.user.domain.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String answer;

    private int goodCount;

    private int badCount;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;

    public void setGoodCount(int goodCount){
        this.goodCount = goodCount;
    }

    public void setBadCount(int badCount){
        this.badCount = badCount;
    }
}
