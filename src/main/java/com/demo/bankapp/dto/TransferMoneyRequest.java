package com.demo.bankapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TransferMoneyRequest {
    @NotNull
    private Long senderId;
    @NotNull
    private Long receiverId;
    @NotNull
    private Long amount;
}
