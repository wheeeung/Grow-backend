package com.example.raisingjungsu.domain.bad.exception;

import com.example.raisingjungsu.global.error.ErrorCode;
import com.example.raisingjungsu.global.error.exception.CustomException;

public class BadAlreadyExistException extends CustomException {
    public BadAlreadyExistException(){
        super(ErrorCode.BAD_ALREADY_EXIST);
    }
}
