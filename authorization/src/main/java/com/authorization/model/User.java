package com.authorization.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table
@Getter
@Setter
public class User extends BaseEntity {

    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    @NotNull
    private String password;
    @Column(name = "gender")
    private String gender;
    @Column(name = "date_of_birth")
    private Date dateOfBirthy;

    public User() {
    }

    public User(User user) {
        this.firstName = user.firstName;
        this.lastName = user.lastName;
        this.phoneNumber = user.phoneNumber;
        this.email = user.email;
        this.password = user.password;
        this.gender = user.gender;
        this.dateOfBirthy = user.dateOfBirthy;
    }
}
