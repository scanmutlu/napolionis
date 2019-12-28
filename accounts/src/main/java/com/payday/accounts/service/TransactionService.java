package com.payday.accounts.service;

import com.payday.accounts.model.Transaction;

import java.util.List;

public interface TransactionService {
    List<Transaction> addTransaction(Transaction transaction);
}
