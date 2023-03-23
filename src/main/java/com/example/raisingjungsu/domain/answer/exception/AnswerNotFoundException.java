package com.example.raisingjungsu.domain.answer.exception;

import com.example.raisingjungsu.global.error.ErrorCode;
import com.example.raisingjungsu.global.error.exception.CustomException;

public class AnswerNotFoundException extends CustomException {
    public AnswerNotFoundException(){
        super(ErrorCode.ANSWER_NOT_FOUND);
    }
}
