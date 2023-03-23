package com.example.raisingjungsu.domain.bad.exception;

import com.example.raisingjungsu.global.error.ErrorCode;
import com.example.raisingjungsu.global.error.exception.CustomException;

public class BadNotFoundException extends CustomException {
    public BadNotFoundException(){
        super(ErrorCode.BAD_NOT_FOUND);
    }
}
