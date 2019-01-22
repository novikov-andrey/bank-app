package com.demo.bankapp.exception;

import lombok.Getter;

@Getter
public class BusinessException extends Exception {

    private ErrorCode errorCode;

    public BusinessException(ErrorCode errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }
}
