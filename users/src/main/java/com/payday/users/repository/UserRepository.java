package com.payday.users.repository;

import com.payday.users.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, UserRepository> {
    User findById(Long id);
}
