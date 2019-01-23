package com.demo.bankapp.controller;

import com.demo.bankapp.dto.AccountOperationRequest;
import com.demo.bankapp.dto.BankOperationResponse;
import com.demo.bankapp.dto.TransferMoneyRequest;
import com.demo.bankapp.exception.BusinessException;
import com.demo.bankapp.service.BankOperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("api/money")
public class BankOperationController {

    @Autowired
    private BankOperationService bankOperationService;

    @PostMapping(value = "/put")
    public BankOperationResponse putMoney(@RequestBody @Valid AccountOperationRequest request) {
        try {
            bankOperationService.putMoney(request.getAccountId(), request.getAmount());
            return ResponseBuilder.buildSuccessResponse();
        } catch (BusinessException e) {
            return ResponseBuilder.buildBusinessFailedResponse(e.getErrorCode().getCode(), e.getMessage());
        } catch (Exception e) {
            return ResponseBuilder.buildInternalErrorResponse();
        }
    }

    @PostMapping(value = "/withdraw")
    public BankOperationResponse withdrawMoney(@RequestBody @Valid AccountOperationRequest request) {
        try {
            bankOperationService.withdrawMoney(request.getAccountId(), request.getAmount());
            return ResponseBuilder.buildSuccessResponse();
        } catch (BusinessException e) {
            return ResponseBuilder.buildBusinessFailedResponse(e.getErrorCode().getCode(), e.getMessage());
        } catch (Exception e) {
            return ResponseBuilder.buildInternalErrorResponse();
        }
    }


    @PostMapping(value = "/transfer")
    public BankOperationResponse transferMoney(@RequestBody @Valid TransferMoneyRequest request) {
        try {
            bankOperationService.transferMoney(request.getSenderId(), request.getReceiverId(), request.getAmount());
            return ResponseBuilder.buildSuccessResponse();
        } catch (BusinessException e) {
            return ResponseBuilder.buildBusinessFailedResponse(e.getErrorCode().getCode(), e.getMessage());
        } catch (Exception e) {
            return ResponseBuilder.buildInternalErrorResponse();
        }
    }


    private static class ResponseBuilder {
        private static final int SUCCESS_RESPONSE_CODE = 0;
        private static final String SUCCESS_RESPONSE_MESSAGE = "Success";

        private static final int SERVER_ERROR_RESPONSE_CODE = 0;
        private static final String SERVER_ERROR_RESPONSE_MESSAGE = "Internal server error";

        private static BankOperationResponse buildSuccessResponse() {
            return buildResponse(SUCCESS_RESPONSE_CODE, SUCCESS_RESPONSE_MESSAGE);
        }

        private static BankOperationResponse buildInternalErrorResponse() {
            return buildResponse(SERVER_ERROR_RESPONSE_CODE, SERVER_ERROR_RESPONSE_MESSAGE);
        }

        private static BankOperationResponse buildBusinessFailedResponse(int errorCode, String message) {
            return buildResponse(errorCode, message);
        }

        private static BankOperationResponse buildResponse(int status, String message) {
            return new BankOperationResponse(status, message);
        }
    }

}

