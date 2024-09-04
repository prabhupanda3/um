package com.fmt.Umd.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.fmt.Umd.Repository.RoleRepository;
import com.fmt.Umd.Repository.UserRepository;
import com.fmt.Umd.model.Role;
@Service
public class RoleService {
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
     public RoleRepository roleRepository;
	
	 public RoleService() {
			super();
		}
	public List<Role> getAllRoles() {
		List<Role> role=new ArrayList<>();
		try {
			 role=roleRepository.findAll();
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		return role;
	}
	public Set<String> getRolesByUserName(String username) {
		
		Set<String> endpoints=new HashSet<String>();
		try {
	List<Role>	roles=userRepository.getUSerRoleByUseName(username);
	roles.stream().forEach(role->endpoints.add(role.getEndPoint()));
	return endpoints;
	}
	catch(Exception ex) {
		endpoints.add("No end Points Found ");
		ex.printStackTrace();
		return endpoints;
	}
	}
	}
	
	

