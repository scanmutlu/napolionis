package com.payday.accounts.model;

import com.payday.base.model.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
public class Account extends BaseEntity {

    @Column(name = "account_number")
    @Generated(GenerationTime.INSERT)
    @NotNull
    private Long accountNumber;

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
