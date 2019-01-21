package com.demo.bankapp.service;

public interface AccountService {
    void putMoney(long accountId, long amount);
    void withdrawMoney(long accountId, long amount);
}
