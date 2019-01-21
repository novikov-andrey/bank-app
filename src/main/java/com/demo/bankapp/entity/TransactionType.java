package com.demo.bankapp.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TransactionType {
    DEPOSIT("deposit"),
    WITHDRAWAL("withdrawal"),
    MONEY_TRANSFER("money-transfer");

    private String code;
}
