package com.demo.bankapp.service.impl;

import com.demo.bankapp.repository.AccountRepository;
import com.demo.bankapp.repository.TransactionRepository;
import com.demo.bankapp.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    @Override
    public void putMoney(long accountId, long amount) {

    }

    @Override
    public void withdrawMoney(long accountId, long amount) {

    }
}
