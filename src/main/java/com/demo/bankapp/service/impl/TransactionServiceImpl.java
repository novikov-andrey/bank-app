package com.demo.bankapp.service.impl;

import com.demo.bankapp.entity.Transaction;
import com.demo.bankapp.entity.TransactionType;
import com.demo.bankapp.repository.TransactionRepository;
import com.demo.bankapp.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Override
    public void registerTransaction(TransactionType transactionType, long senderId, long receiverId, long amount) {
        Transaction transaction = new Transaction();
        transaction.setType(transactionType);
        transaction.setSenderId(senderId);
        transaction.setReceiverId(receiverId);
        transaction.setAmount(amount);
        transaction.setDate(new Date());
        transactionRepository.save(transaction);
    }
}
