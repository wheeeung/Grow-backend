package com.example.raisingjungsu.domain.question.api.dto.response;

import com.example.raisingjungsu.domain.answer.domain.Answer;
import com.example.raisingjungsu.domain.user.domain.User;
import lombok.AllArgsConstructor;
import lombok.Builder;

import java.util.List;

@Builder
@AllArgsConstructor
public class QuestionResponse {
    private int id;
    private String title;
    private String question;
    private String category;
    private User user;
    private List<Answer> answerList;
}
