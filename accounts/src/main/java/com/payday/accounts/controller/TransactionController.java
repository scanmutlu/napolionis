package com.payday.accounts.controller;

import com.payday.accounts.model.Account;
import com.payday.accounts.model.Transaction;
import com.payday.accounts.repository.AccountRepository;
import com.payday.accounts.repository.TransactionRepository;
import com.payday.accounts.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("api/v1/transactions")
public class TransactionController {
    protected Logger logger = Logger.getLogger(TransactionController.class
            .getName());
    protected TransactionRepository transactionRepository;
    protected TransactionService transactionService;

    @Autowired
    public TransactionController(TransactionRepository transactionRepository, TransactionService transactionService) {
        this.transactionRepository = transactionRepository;
        this.transactionService = transactionService;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity< String > addTransaction(@RequestBody Transaction transaction) {
        List<Transaction> trxList = transactionService.addTransaction(transaction);
        if(trxList == null)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity< String > updateTransaction(@RequestBody Transaction transaction) {
        transactionRepository.save(transaction);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity< String > deleteTransaction(@PathVariable("id")Long id) {
        transactionRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    public ResponseEntity<List<Transaction>> getTransactionByCustomerId(@PathVariable("userId") Long userId) {
        List<Transaction> trxList = transactionRepository.findTransactionsByUserIdOrderByCreateDateDesc(userId);
        return new ResponseEntity<>(trxList, HttpStatus.OK);
    }

}
