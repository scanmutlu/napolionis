package com.payday.accounts.controller;

import com.payday.accounts.model.Account;
import com.payday.accounts.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.security.auth.login.AccountNotFoundException;
import java.math.BigDecimal;
import java.util.List;
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
        Account account = accountRepository.findByAccountNumber(new Long(accountNumber));
        logger.info("accounts-service byNumber() found: " + account);

        if (account == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        else {
            return new ResponseEntity<>(account,HttpStatus.OK);
        }
    }

    @RequestMapping(value = "/accounts/addAccount", method = RequestMethod.POST)
    public ResponseEntity< String > addAccount(@RequestBody Account account) {
            accountRepository.save(account);
            return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @RequestMapping(value = "/accounts/user/{userId}", method = RequestMethod.GET)
    public ResponseEntity<List<Account>> getUserAccounts (@PathVariable("userId") String userId){
        List<Account> accList = accountRepository.findByUserIdAndIsActiveTrue(new Long(userId));
        if(accList == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        else
            return new ResponseEntity<>(accList,HttpStatus.OK);
    }
}
