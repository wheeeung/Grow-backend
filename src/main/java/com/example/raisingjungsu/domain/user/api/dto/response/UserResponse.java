package com.example.raisingjungsu.domain.user.api.dto.response;

import com.example.raisingjungsu.domain.answer.domain.Answer;
import com.example.raisingjungsu.domain.question.domain.Question;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class UserResponse {
    private String email;
    private String nickname;
    private int coin;
    private String image;
    private List<Question> questionList;
    private List<Answer> answerList;
}
