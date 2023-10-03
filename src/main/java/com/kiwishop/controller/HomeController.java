package com.kiwishop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kiwishop.Entities.User;
import com.kiwishop.dto.UserDTO;
import com.kiwishop.service.UserService;

import ch.qos.logback.core.model.Model;
import jakarta.servlet.http.HttpSession;

@RestController
@CrossOrigin
@RequestMapping("/home")
public class HomeController {
	@Autowired 
	private UserService userService;
	
	@GetMapping("/login")
	public String login() {
		return "home/login";
	}
	
	@GetMapping("/register")
	public String register() {
		return "home/register";
	}
	
	@PostMapping("register/save")
	public String saveUser(@RequestBody UserDTO userDTO) {
		String id = userService.addUser(userDTO);
		return "redirect:/register";
	}
	
	
}
