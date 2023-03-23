package com.example.raisingjungsu.domain.user.exception;

import com.example.raisingjungsu.global.error.ErrorCode;
import com.example.raisingjungsu.global.error.exception.CustomException;

public class PasswordNotMatchesException extends CustomException {
    public PasswordNotMatchesException(){
        super(ErrorCode.PASSWORD_NOT_MATCHES);
    }
}
