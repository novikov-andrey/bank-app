package com.demo.bankapp.controller;

import com.demo.bankapp.dto.TransferOperationRequest;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class TransferOperationController {

    @PostMapping(value = "transfer-money")
    public void transferMoney(@RequestBody @Valid TransferOperationRequest request) {

    }
}
