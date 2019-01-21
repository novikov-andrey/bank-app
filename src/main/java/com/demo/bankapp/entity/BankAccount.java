package com.demo.bankapp.entity;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "bank_account")
public class BankAccount {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String owner;

    @Column(nullable = false)
    private Long balance;
}
