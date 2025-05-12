package com.fmt.Umd.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.fmt.Umd.Repository.RoleRepository;
import com.fmt.Umd.Repository.UserRepository;
import com.fmt.Umd.UserDto.UserDTO;
import com.fmt.Umd.user.model.Role;
import com.fmt.Umd.user.model.User;

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
			roleList=roleRepository.findParentRoleByRoleName(r.getRoleName());
			roleList.add(r.getRoleName());
		}
		return roleList;

		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return roleList;
		
	}
	
	public void saveUserDetails(User user) {
		try {
			userRepository.save(user);
			
		   
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	public List<UserDTO> getAllChildUser(String name) {
		// TODO Auto-generated method stub
		List<UserDTO> list=new ArrayList<>();
		try {
		List<User>	user=userRepository.findAllByParentUser(name);
		for(User u:user) {
			UserDTO userDTO=new UserDTO();
			userDTO.setUsername(u.getUsername());
			userDTO.setUserIdName(u.getUserIdName());
		Set<Role>	roleSet=u.getRole();
		roleSet.forEach((Role r)->userDTO.setAutherity(r.getAuthority()));
		userDTO.setAddress(u.getAddress());
		userDTO.setEmail(u.getEmail());
		userDTO.setMobileNumber(u.getMobileNumber());
		list.add(userDTO);
		}
		}catch(Exception ex) {
			ex.printStackTrace();
			}
		return list;
	}
	
	
}
