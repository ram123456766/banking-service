package com.bank.banking.service;

import com.bank.banking.entity.Account;
import com.bank.banking.entity.Customer;
import com.bank.banking.repository.AccountRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.UUID;

@Service
public class AccountService {

    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Account createAccount(Customer customer) {

        if (customer == null || customer.getId() == null) {
            throw new RuntimeException("Customer must exist");
        }

        Account account = new Account();

        // 🔴 THIS FIXES YOUR 500 ERROR
        account.setAccountNumber("ACC-" + UUID.randomUUID());

        account.setCustomer(customer);
        account.setBalance(BigDecimal.ZERO);
        account.setStatus("ACTIVE");

        return accountRepository.save(account);
    }
}
