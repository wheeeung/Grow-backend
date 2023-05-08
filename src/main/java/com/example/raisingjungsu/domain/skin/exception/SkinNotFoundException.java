package com.example.raisingjungsu.domain.skin.exception;

import com.example.raisingjungsu.global.error.ErrorCode;
import com.example.raisingjungsu.global.error.exception.CustomException;

public class SkinNotFoundException extends CustomException {
    public SkinNotFoundException(){
        super(ErrorCode.SKIN_NOT_FOUND);
    }
}
