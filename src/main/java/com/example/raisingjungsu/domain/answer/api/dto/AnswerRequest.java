package com.example.raisingjungsu.domain.answer.api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AnswerRequest {
    private int question_id;
    private String answer;
}
