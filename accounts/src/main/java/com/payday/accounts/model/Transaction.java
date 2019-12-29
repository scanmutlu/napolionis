package com.payday.accounts.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
public class Transaction extends BaseEntity {

    @Column(name = "account_id")
    Long accountId;

    @Column(name = "user_id")
    Long userId;

    @Column(name = "transaction_balance")
    BigDecimal transactionBalance;

    @Column(name = "transaction_description")
    String transactionDescription;

}
