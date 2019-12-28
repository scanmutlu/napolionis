package com.payday.accounts.model;

import com.payday.base.model.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
public class Account extends BaseEntity {

    @Column(name = "account_number")
    private BigDecimal accountNumber;

    @Column(name = "is_active")
    private Boolean isActive;

    @Column(name = "account_type")
    private String accountType;

    @Column(name = "customer_id")
    private Long customerId;

}
