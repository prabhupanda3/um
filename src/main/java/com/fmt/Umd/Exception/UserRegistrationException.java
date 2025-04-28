package com.fmt.Umd.Exception;

public class UserRegistrationException extends Exception{

	public String usereg;

	public UserRegistrationException(String usereg) {
		super();
		this.usereg = usereg;
	}
	
}
