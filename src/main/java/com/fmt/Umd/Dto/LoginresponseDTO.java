package com.fmt.Umd.Dto;

import java.util.List;
import java.util.Set;

import com.fmt.Umd.model.Module;
import com.fmt.Umd.user.model.Role;
import com.fmt.Umd.user.model.User;

public class LoginresponseDTO {

	private User user;
	private String token;
	private Set<Module> module;
	private RoleDTO role;
	private List<String> hierarchyList;
	
	


	public LoginresponseDTO(User user, String token, RoleDTO role, List<String> hierarchyList) {
		super();
		this.user = user;
		this.token = token;
		this.role = role;
		this.hierarchyList = hierarchyList;
	}


	public LoginresponseDTO() {
		super();
	}
	
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public Set<Module> getModule() {
		return module;
	}
	public void setModule(Set<Module> module) {
		this.module = module;
	}
	
	public RoleDTO getRole() {
		return role;
	}


	public void setRole(RoleDTO role) {
		this.role = role;
	}


	public List<String> getHierarchyList() {
		return hierarchyList;
	}


	public void setHierarchyList(List<String> hierarchyList) {
		this.hierarchyList = hierarchyList;
	}

	
	
	
}
