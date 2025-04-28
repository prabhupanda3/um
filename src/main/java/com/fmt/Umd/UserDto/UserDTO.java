package com.fmt.Umd.UserDto;

import org.springframework.web.multipart.MultipartFile;

public class UserDTO {
	private String userIdName;
	private String password;
	private String username; 
	private String email;
	private String mobileNumber;
	private String address;
	private MultipartFile image;
	private String autherity;
	private String confirmPassword;
	public UserDTO() {
		super();
	}
	public UserDTO(String userIdName, String password, String username, String email, String mobileNumber,
			String address, MultipartFile image, String autherity, String confirmPassword) {
		super();
		this.userIdName = userIdName;
		this.password = password;
		this.username = username;
		this.email = email;
		this.mobileNumber = mobileNumber;
		this.address = address;
		this.image = image;
		this.autherity = autherity;
		this.confirmPassword = confirmPassword;
	}
	public String getUserIdName() {
		return userIdName;
	}
	public void setUserIdName(String userIdName) {
		this.userIdName = userIdName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public MultipartFile getImage() {
		return image;
	}
	public void setImage(MultipartFile image) {
		this.image = image;
	}
	public String getAutherity() {
		return autherity;
	}
	public void setAutherity(String autherity) {
		this.autherity = autherity;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	
	
}
