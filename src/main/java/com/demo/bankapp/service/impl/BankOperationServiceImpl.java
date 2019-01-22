package com.demo.bankapp.service.impl;

import com.demo.bankapp.entity.BankAccount;
import com.demo.bankapp.entity.TransactionType;
import com.demo.bankapp.exception.BusinessException;
import com.demo.bankapp.service.AccountService;
import com.demo.bankapp.service.BankOperationService;
import com.demo.bankapp.service.TransactionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BankOperationServiceImpl implements BankOperationService {

    private static final Logger log = LoggerFactory.getLogger(BankOperationServiceImpl.class);

    @Autowired
    private AccountService accountService;

    @Autowired
    private TransactionService transactionService;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void putMoney(long accountId, long amount) throws BusinessException {
        try {
            BankAccount account = accountService.findById(accountId);
            accountService.updateBalance(account, amount);
            transactionService.registerTransaction(TransactionType.DEPOSIT, accountId, accountId, amount);
        } catch (BusinessException e) {
            log.error("Business exception occurred during withdraw money from account = {}, Reason: {}.", accountId, e.getMessage(), e);
            throw e;
        } catch (Exception e) {
            log.error("Error! Unexpected exception occurred during putMoney money from account = {}.", accountId, e);
            throw e;
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void withdrawMoney(long accountId, long amount) throws BusinessException {
        try {
            BankAccount account = accountService.findById(accountId);
            accountService.checkBalance(account, amount);
            accountService.updateBalance(account, -amount);
            transactionService.registerTransaction(TransactionType.WITHDRAWAL, accountId, accountId, amount);
        } catch (BusinessException e) {
            log.error("Business exception occurred during withdraw money from account = {}, Reason: {}.", accountId, e.getMessage(), e);
            throw e;
        } catch (Exception e) {
            log.error("Error! Unexpected exception occurred during withdraw money from account = {}.", accountId, e);
            throw e;
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void transferMoney(long senderId, long receiverId, long amount) throws BusinessException {
        try {
            BankAccount senderAccount;
            BankAccount receiverAccount;
            if (senderId < receiverId) {
                senderAccount = accountService.findById(senderId);
                receiverAccount = accountService.findById(receiverId);
            } else {
                receiverAccount = accountService.findById(receiverId);
                senderAccount = accountService.findById(senderId);
            }

            accountService.checkBalance(senderAccount, amount);
            accountService.updateBalance(senderAccount, -amount);
            accountService.updateBalance(receiverAccount, amount);

            transactionService.registerTransaction(TransactionType.MONEY_TRANSFER, senderId, receiverId, amount);
        } catch (BusinessException e) {
            log.error("Business exception occurred during transfer money from senderAccount = {} to receiverAccount = {}. Reason: {}", senderId, receiverId,  e.getMessage(), e);
            throw e;
        } catch (Exception e) {
            log.error("Error! Unexpected exception occurred during transfer money from senderAccount = {} to receiverAccount = {}.", senderId, receiverId, e);
            throw e;
        }
    }
}
