package com.demo.bankapp.service.impl;

import com.demo.bankapp.exception.ErrorCode;
import com.demo.bankapp.entity.BankAccount;
import com.demo.bankapp.exception.BusinessException;
import com.demo.bankapp.repository.AccountRepository;
import com.demo.bankapp.service.AccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

    private static final Logger log = LoggerFactory.getLogger(AccountServiceImpl.class);

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public BankAccount findById(long id) throws BusinessException {
        BankAccount bankAccount = accountRepository.findById(id);
        if (bankAccount == null) {
            log.error("Error! Account with id = {} nor found", id);
            throw new BusinessException(ErrorCode.ACCOUNT_NOT_FOUND_ERROR, String.format("Account with id = %d not found", id));
        }
        return bankAccount;
    }

    @Override
    public void updateBalance(BankAccount account, long amount) {
        account.setBalance(account.getBalance() + amount);
        accountRepository.save(account);
    }

    @Override
    public void checkBalance(BankAccount account, long amount) throws BusinessException {
        if (account.getBalance() - amount < 0) {
            log.error("Error! Balance must be positive");
            throw new BusinessException(ErrorCode.ILLEGAL_OPERATION_ERROR, "Not enough money on account for this operation");
        }
    }
}
