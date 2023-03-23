package com.example.raisingjungsu.domain.question.exception;

import com.example.raisingjungsu.global.error.ErrorCode;
import com.example.raisingjungsu.global.error.exception.CustomException;

public class QuestionNotFoundException extends CustomException {
    public QuestionNotFoundException(){
        super(ErrorCode.QUESTION_NOT_FOUND);
    }
}
