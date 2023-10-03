package com.kiwishop.service;

import org.springframework.stereotype.Service;

import com.kiwishop.Entities.LoginMesage;
import com.kiwishop.Entities.User;
import com.kiwishop.dto.LoginDTO;
import com.kiwishop.dto.UserDTO;

@Service
public interface UserService {
	public User saveUser(User user);

	public void removeSessionMessage();
	
	String addUser(UserDTO userDTO);
	 LoginMesage loginEmployee(LoginDTO loginDTO);
}
