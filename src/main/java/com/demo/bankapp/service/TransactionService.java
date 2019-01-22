package com.demo.bankapp.service;

import com.demo.bankapp.entity.TransactionType;

public interface TransactionService {
    void registerTransaction(TransactionType transactionType, long senderId, long receiverId, long amount);
}
