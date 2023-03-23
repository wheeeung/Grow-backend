package com.example.raisingjungsu.domain.good.exception;

import com.example.raisingjungsu.global.error.ErrorCode;
import com.example.raisingjungsu.global.error.exception.CustomException;

public class GoodAlreadyExistException extends CustomException {
    public GoodAlreadyExistException(){
        super(ErrorCode.GOOD_ALREADY_EXIST);
    }
}
