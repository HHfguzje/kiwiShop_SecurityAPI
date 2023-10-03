package com.kiwishop.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.kiwishop.Entities.User;
import com.kiwishop.repository.UserRepository;

public class CustomUserDetailsService implements UserDetailsService{
	@Autowired
	UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByEmail(username);
		System.out.println(user);
		if (user == null) {
			throw new UsernameNotFoundException("user not found");
		} else {
			return new CustomUser(user);
		}

	}
	
	
}
