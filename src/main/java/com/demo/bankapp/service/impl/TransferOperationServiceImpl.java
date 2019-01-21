package com.demo.bankapp.service.impl;

import com.demo.bankapp.repository.AccountRepository;
import com.demo.bankapp.repository.TransactionRepository;
import com.demo.bankapp.service.TransferMoneyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransferOperationServiceImpl implements TransferMoneyService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    @Override
    public void transferMoney(long senderId, long receiverId, long amount) {

    }
}
