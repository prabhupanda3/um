package com.fmt.Umd.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.fmt.Umd.Repository.RoleRepository;
import com.fmt.Umd.Repository.UserRepository;
import com.fmt.Umd.model.Role;
import com.fmt.Umd.model.User;

@Service
public class RegistrationService {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private UserDetailsServices userDetailsServices;
	public void register(String username,String password,String email,Integer otp) {
		
			
			User user=new User();
			user.setUsername(username);
			user.setPassword(passwordEncoder.encode(password));
			user.setEmail(email);
			user.setOTP(otp.toString());
			//Set<Role> roles = new HashSet<>();//(user.getAuthorities().stream()
	             //.map(authority -> (Role) authority)
	            //.collect(Collectors.toList()));
			Set<Role> role=roleRepository.findByAuthority("USER");
			//user.setRole(role);
			
	       
	        try {
		    userRepository.save(user);

		}
		catch(Exception ex) {
			System.out.println("User not found exception");
			ex.printStackTrace();
		}
	}
	
	

}
