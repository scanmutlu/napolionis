package com.payday.accounts.service;

import com.payday.accounts.model.Account;
import com.payday.accounts.model.Transaction;
import com.payday.accounts.repository.AccountRepository;
import com.payday.accounts.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService{
    protected TransactionRepository transactionRepository;
    protected AccountRepository accountRepository;

    @Autowired
    public TransactionServiceImpl(TransactionRepository transactionRepository, AccountRepository accountRepository) {
        this.transactionRepository = transactionRepository;
        this.accountRepository = accountRepository;
    }

    @Override
    public List<Transaction> addTransaction(Transaction transaction) {
        Account acc = accountRepository.getOne(transaction.getAccountId());
        if(acc == null){
            return null;
        }
        if(transaction.getUserId() == acc.getUserId()){
            acc.setBalance(acc.getBalance().add(transaction.getTransactionBalance()));
            accountRepository.save(acc);
            transactionRepository.save(transaction);
            return transactionRepository.findTransactionsByAccountId(acc.getId());
        }else
            return null;
    }

}
