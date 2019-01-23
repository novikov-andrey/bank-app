package com.demo.bankapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AccountOperationRequest {
    @NotNull
    private Long accountId;
    @NotNull
    @Min(value = 0L, message = "Amount must be positive")
    private Long amount;
}
