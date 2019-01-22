package com.demo.bankapp.service;

import com.demo.bankapp.exception.BusinessException;

public interface BankOperationService {
    void putMoney(long accountId, long amount) throws BusinessException;
    void withdrawMoney(long accountId, long amount) throws BusinessException;
    void transferMoney(long senderId, long receiverId, long amount) throws BusinessException;
}
