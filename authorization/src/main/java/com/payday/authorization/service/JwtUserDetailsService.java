package com.payday.authorization.service;

import java.io.IOException;
import java.util.ArrayList;


import com.payday.authorization.model.User;
import com.payday.authorization.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailsService implements UserDetailsService {
	@Autowired
	UserRepository userRepository;
	@Autowired
	PasswordEncoder bcryptEncoder;


	@Override
	public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {
		User user = userRepository.findById(new Long(id));
		if (user == null) {
			throw new UsernameNotFoundException("User not found with username: " + id);
		}
		return new org.springframework.security.core.userdetails.User(String.valueOf(user.getId()), user.getPassword(),
				new ArrayList<>());
	}
	
	public User save(User user) throws IOException {
		if (user.getPassword().length() < 6)
			throw new IOException("Password lenght must be 6 or more!");
		user.setPassword(bcryptEncoder.encode(user.getPassword()));
		return userRepository.save(user);
	}
}