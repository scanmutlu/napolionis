package com.payday.accounts.repository;

import com.payday.accounts.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction,TransactionRepository > {
    List<Transaction> findTransactionsByUserId(Long userId);
    List<Transaction> findTransactionsByUserIdOrderByCreateDateDesc(Long userId);
    List<Transaction> findTransactionsByAccountId(Long accountId);
    void deleteById(Long id);
}
