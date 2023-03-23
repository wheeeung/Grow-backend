package com.example.raisingjungsu.domain.user.exception;

import com.example.raisingjungsu.global.error.ErrorCode;
import com.example.raisingjungsu.global.error.exception.CustomException;

public class AlreadyExistException extends CustomException {
    public AlreadyExistException(){
        super(ErrorCode.ALREADY_EXIST);
    }
}
