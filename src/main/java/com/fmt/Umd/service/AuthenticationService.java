package com.fmt.Umd.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.fmt.Umd.Repository.UserRepository;
import com.fmt.Umd.model.User;

@Service
public class AuthenticationService {
	@Autowired
    public	UserRepository userRepository;
	@Autowired
	public PasswordEncoder passwordEncoder;
     
	public User getUserByUserName(String username) {
	
		User user= userRepository.findByUsername(username).orElseThrow(()->new UsernameNotFoundException("No user found"));
		
	 return user;
	}
	
	
	public void saveUserNamePassword(String username,String password,String email) {
		User user=new User();
		user.setEmail(email);
		user.setUsername(username);
		user.setPassword(passwordEncoder.encode(password));
		userRepository.save(user);
		
	}
	
	
	
	
}
