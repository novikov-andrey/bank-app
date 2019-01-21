package com.demo.bankapp.controller;

import com.demo.bankapp.dto.AccountOperationRequest;
import com.demo.bankapp.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping(value = "/put-money")
    public void putMoney(@RequestBody @Valid AccountOperationRequest request) {

    }

    @PostMapping(value = "/withdraw-money")
    public void withdrawMoney(@RequestBody @Valid AccountOperationRequest request) {

    }
}
