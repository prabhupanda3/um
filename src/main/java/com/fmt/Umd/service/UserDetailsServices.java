package com.fmt.Umd.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.fmt.Umd.Repository.RoleRepository;
import com.fmt.Umd.Repository.UserRepository;
import com.fmt.Umd.model.Role;
import com.fmt.Umd.model.User;

@Service

public class UserDetailsServices implements  UserDetailsService{
@Autowired
private UserRepository userRepository;
@Autowired
private RoleRepository roleRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws
	  UsernameNotFoundException {
		
		 
		UserDetails userDetails=userRepository.findByUsername(username).orElseThrow(()->new UsernameNotFoundException("No user Found"));
        System.out.println("Role :"+userDetails.getAuthorities());

		
	
		return userDetails;
			
		
	}
	public void getHierarchyByUserName(String userName) {
		try {
			User user=userRepository.findAllByUsername(userName);
			user.getHierarchy();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
	}
	public List<String> getAllListOfChildRoles(String userName){
		List<String> roleList=null;
		try {
			User user=userRepository.findAllByUsername(userName);
		Set<Role>	role=user.getRole();
		for(Role r:role) {
			r.getRoleName();
			roleList=roleRepository.findParentRoleByRoleName(userName);
		}
		return roleList;

		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return roleList;
		
	}
}
