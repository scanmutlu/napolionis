package com.payday.accounts.controller;

import com.payday.accounts.model.Account;
import com.payday.accounts.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.security.auth.login.AccountNotFoundException;
import java.math.BigDecimal;
import java.util.logging.Logger;

@RestController
public class AccountController {

    protected Logger logger = Logger.getLogger(AccountController.class
            .getName());
    protected AccountRepository accountRepository;

    @Autowired
    public AccountController(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @RequestMapping("/accounts/{accountNumber}")
    public ResponseEntity<Account> getAccountByNumber(@PathVariable("accountNumber") String accountNumber) throws AccountNotFoundException {

        logger.info("accounts-service byNumber() invoked: " + accountNumber);
        Account account = accountRepository.findByAccountNumber(new BigDecimal(accountNumber));
        logger.info("accounts-service byNumber() found: " + account);

        if (account == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        else {
            return ResponseEntity.status(account,HttpStatus.FOUND).build();
        }
    }

    @RequestMapping(value = "/accounts/addAccount", method = RequestMethod.POST)
    public ResponseEntity< String > persistPerson(@RequestBody Account account) {
            accountRepository.save(account);
            return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
