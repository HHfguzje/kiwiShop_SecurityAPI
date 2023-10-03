package com.kiwishop.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.kiwishop.Entities.LoginMesage;
import com.kiwishop.Entities.User;
import com.kiwishop.dto.LoginDTO;
import com.kiwishop.dto.UserDTO;
import com.kiwishop.repository.UserRepository;
import com.kiwishop.service.UserService;

import jakarta.servlet.http.HttpSession;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public User saveUser(User user) {
		String password=passwordEncoder.encode(user.getPassword());
		user.setPassword(password);
		user.setRole("role");
		User newuser = userRepository.save(user);

		return newuser;
	}
	@Override
	public void removeSessionMessage() {
		HttpSession session = ((ServletRequestAttributes) (RequestContextHolder.getRequestAttributes())).getRequest()
				.getSession();

		session.removeAttribute("msg");		
	}
	@Override
	public String addUser(UserDTO userDTO) {
		// TODO Auto-generated method stub
		User user = new User(
				userDTO.getId(),
				userDTO.getEmail(),
				this.passwordEncoder.encode(userDTO.getPassword()),
				userDTO.getHoTen(),
				userDTO.getSoDienThoai(),
				userDTO.getDiaChi(),
				userDTO.getRole()
				);
		userRepository.save(user);
		return user.getHoTen();
	}
	UserDTO userDTO;
    @Override
    public LoginMesage loginEmployee(LoginDTO loginDTO) {
        String msg = "";
        User u = userRepository.findByEmail(loginDTO.getEmail());
        if (u != null) {
            String password = loginDTO.getPassword();
            String encodedPassword = u.getPassword();
            Boolean isPwdRight = passwordEncoder.matches(password, encodedPassword);
            if (isPwdRight) {
                Optional<User> user = userRepository.findByEmailAndPassword(loginDTO.getEmail(), encodedPassword);
                if (user.isPresent()) {
                    return new LoginMesage("Login Success", true);
                } else {
                    return new LoginMesage("Login Failed", false);
                }
            } else {
                return new LoginMesage("password Not Match", false);
            }
        }else {
            return new LoginMesage("Email not exits", false);
        }
    }
		
}
