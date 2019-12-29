package com.payday.authorization.repository;

import com.payday.authorization.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, UserRepository> {
    User findById(Long id);
}
