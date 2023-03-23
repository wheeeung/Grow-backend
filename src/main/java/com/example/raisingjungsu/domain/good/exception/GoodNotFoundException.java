package com.example.raisingjungsu.domain.good.exception;

import com.example.raisingjungsu.global.error.ErrorCode;
import com.example.raisingjungsu.global.error.exception.CustomException;

public class GoodNotFoundException extends CustomException {
    public GoodNotFoundException(){
        super(ErrorCode.GOOD_NOT_FOUND);
    }
}
