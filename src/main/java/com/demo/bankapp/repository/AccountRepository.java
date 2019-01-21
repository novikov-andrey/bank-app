package com.demo.bankapp.repository;


import com.demo.bankapp.entity.BankAccount;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends CrudRepository<BankAccount, Long> {
}
