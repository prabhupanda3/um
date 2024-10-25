package com.fmt.Umd.Dto;

import java.util.Set;

import com.fmt.Umd.model.Module;
import com.fmt.Umd.model.Role;
import com.fmt.Umd.model.User;

public class LoginresponseDTO {

	private User user;
	private String token;
	private Set<Module> module;
	private Role role;
	
	
	
	
	public LoginresponseDTO(User user, String token, Set<Module> module, Role role) {
		super();
		this.user = user;
		this.token = token;
		this.module = module;
		this.role = role;
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
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}

	
	
	
}
