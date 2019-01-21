package com.demo.bankapp.service;

public interface TransferMoneyService {
    void transferMoney(long senderId, long receiverId, long amount);
}
