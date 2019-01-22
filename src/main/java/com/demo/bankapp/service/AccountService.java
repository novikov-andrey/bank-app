package com.demo.bankapp.service;

import com.demo.bankapp.entity.BankAccount;
import com.demo.bankapp.exception.BusinessException;

public interface AccountService {
    BankAccount findById(long id) throws BusinessException;
    void updateBalance(BankAccount account, long amount);
    void checkBalance(BankAccount account, long amount) throws BusinessException;
}
