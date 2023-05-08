package com.example.raisingjungsu.domain.skin.exception;

import com.example.raisingjungsu.global.error.ErrorCode;
import com.example.raisingjungsu.global.error.exception.CustomException;

public class SkinNotBuyException extends CustomException {
    public SkinNotBuyException(){
        super(ErrorCode.SKIN_CANNOT_BUY);
    }
}
