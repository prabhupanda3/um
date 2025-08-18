package com.fmt.Umd.service;

import java.util.PriorityQueue;
import java.util.Queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.fmt.Umd.Dto.RoleDTO;
import com.fmt.Umd.Repository.UserRepository;
import com.fmt.Umd.user.model.Role;
import com.fmt.Umd.user.model.User;

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
	public RoleDTO getUserRoleByUserName(String username) {
	RoleDTO roleDTO=new RoleDTO();
	Role role=	userRepository.getUSerRoleByUseName(username);
	Queue<com.fmt.Umd.model.Module> pq=new PriorityQueue<>(( m1, m2)->m1.getDisplayOrder().compareTo( m2.getDisplayOrder()));
	  role.getModule().
	               stream().
	                   forEach((com.fmt.Umd.model.Module module)->pq.add(module));   
	                  
	  roleDTO.setSubmoduleAction(role.getSabmoduleAction());
	  roleDTO.setModule(pq);
		return roleDTO;
	}
	
	public void saveUserNamePassword(String username,String password,String email) {
		User user=new User();
		user.setEmail(email);
		user.setUsername(username);
		user.setPassword(passwordEncoder.encode(password));
		userRepository.save(user);
		
	}
	
	
	
	
}
