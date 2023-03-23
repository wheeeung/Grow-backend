package com.example.raisingjungsu.domain.question.api.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class QuestionRequest {
    private String title;
    private String question;
    private String category;
}
