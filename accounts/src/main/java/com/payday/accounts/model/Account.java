package com.payday.accounts.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Getter
@Setter
public class Account extends BaseEntity {

    @Column(name = "balance")
    private BigDecimal balance = BigDecimal.ZERO;

    @Column(name = "is_active")
    private Boolean isActive = true;

    @Column(name = "account_type")
    private String accountType;

    @Column(name = "user_id")
    @NotNull
    private Long userId;

}
