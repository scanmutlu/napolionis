package com.payday.accounts.controller;

import com.payday.accounts.model.Account;
import com.payday.accounts.model.Transaction;
import com.payday.accounts.repository.AccountRepository;
import com.payday.accounts.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
public class TransactionController {
    protected Logger logger = Logger.getLogger(TransactionController.class
            .getName());
    protected TransactionRepository transactionRepository;

    @Autowired
    public TransactionController(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @RequestMapping(value = "/transactions", method = RequestMethod.POST)
    public ResponseEntity< String > addTransaction(@RequestBody Transaction transaction) {
        transactionRepository.save(transaction);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @RequestMapping(value = "/transactions", method = RequestMethod.PUT)
    public ResponseEntity< String > updateTransaction(@RequestBody Transaction transaction) {
        transactionRepository.save(transaction);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @RequestMapping(value = "/transactions/{id}", method = RequestMethod.DELETE)
    public ResponseEntity< String > deleteTransaction(@PathVariable("id")Long id) {
        transactionRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @RequestMapping(value = "/transactions/{userId}", method = RequestMethod.GET)
    public ResponseEntity<List<Transaction>> getTransactionByCustomerId(@PathVariable("customerId")Long customerId) {
        List<Transaction> trxList = transactionRepository.findTransactionsByUserId(customerId);
        return new ResponseEntity<>(trxList, HttpStatus.OK);
    }

    @RequestMapping(value = "/transactions/{accountId}", method = RequestMethod.GET)
    public ResponseEntity<List<Transaction>> getTransactionByAccountId(@PathVariable("accountId")Long accountId) {
        List<Transaction> trxList = transactionRepository.findTransactionsByAccountId(accountId);
        return new ResponseEntity<>(trxList, HttpStatus.OK);
    }
}
