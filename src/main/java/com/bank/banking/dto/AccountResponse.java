package com.bank.banking.dto;

import java.math.BigDecimal;

public class AccountResponse {

    private Long accountId;
    private BigDecimal balance;
    private String status;
    private Long customerId;

    public AccountResponse(Long accountId,
                           BigDecimal balance,
                           String status,
                           Long customerId) {
        this.accountId = accountId;
        this.balance = balance;
        this.status = status;
        this.customerId = customerId;
    }

    public Long getAccountId() {
        return accountId;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public String getStatus() {
        return status;
    }

    public Long getCustomerId() {
        return customerId;
    }
}
