package com.bank.banking.controller;

import com.bank.banking.entity.Account;
import com.bank.banking.entity.Customer;
import com.bank.banking.service.AccountService;
import com.bank.banking.service.CustomerService;
import com.bank.banking.dto.AccountResponse;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    private final AccountService accountService;
    private final CustomerService customerService;

    public AccountController(AccountService accountService,
                             CustomerService customerService) {
        this.accountService = accountService;
        this.customerService = customerService;
    }

    // ✅ Create account for an existing customer
    @PostMapping("/{customerId}")
    public AccountResponse createAccount(@PathVariable Long customerId) {

        // 1️⃣ Fetch existing customer
        Customer customer = customerService.getCustomerById(customerId);

        // 2️⃣ Create account
        Account account = accountService.createAccount(customer);

        // 3️⃣ Return DTO
        return new AccountResponse(
                account.getId(),
                account.getBalance(),
                account.getStatus(),
                customer.getId()
        );
    }
}
