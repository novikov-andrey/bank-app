package com.demo.bankapp.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    ACCOUNT_NOT_FOUND_ERROR(101),
    ILLEGAL_OPERATION_ERROR(102);

    private int code;
}
