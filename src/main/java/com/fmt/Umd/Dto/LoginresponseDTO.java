package com.fmt.Umd.Dto;

import java.util.Set;

import com.fmt.Umd.model.Module;
import com.fmt.Umd.model.User;

public class LoginresponseDTO {

	private User user;
	private String token;
	private Set<Module> module;
	
	
	public LoginresponseDTO() {
		super();
	}
	public LoginresponseDTO(User user, String token) {
		super();
		this.user = user;
		this.token = token;
	}
	
	public LoginresponseDTO(User user, String token, Set<Module> module) {
		super();
		this.user = user;
		this.token = token;
		this.module = module;
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

	
	
	
}
