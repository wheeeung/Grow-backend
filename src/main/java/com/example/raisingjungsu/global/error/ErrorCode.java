package com.example.raisingjungsu.global.error;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    //400
    ALREADY_EXIST(400, "user already exist"),
    PASSWORD_NOT_MATCHES(400, "incorrect password"),
    GOOD_ALREADY_EXIST(400, "good already exist"),
    BAD_ALREADY_EXIST(400, "bad already exist"),

    //404
    USER_NOT_FOUND(404, "user not found"),
    QUESTION_NOT_FOUND(404, "question not found"),
    ANSWER_NOT_FOUND(404, "answer not found"),
    GOOD_NOT_FOUND(404, "good not found"),
    BAD_NOT_FOUND(404, "bad not found");


    private final int httpStatus;
    private final String message;
}
