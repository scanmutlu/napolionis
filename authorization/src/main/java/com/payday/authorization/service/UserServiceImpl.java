package com.payday.authorization.service;

import com.payday.authorization.model.User;
import com.payday.authorization.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    protected UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;

    }

    @Override
    public Long addUser(User user) {
        User newUser = new User(user);
        User added = userRepository.save(newUser);
        return added.getId();
    }
}
