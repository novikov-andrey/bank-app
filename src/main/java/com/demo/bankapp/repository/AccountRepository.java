package com.demo.bankapp.repository;

import com.demo.bankapp.entity.BankAccount;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.LockModeType;

@Repository
public interface AccountRepository extends CrudRepository<BankAccount, Long> {

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    BankAccount findById(long id);
}
