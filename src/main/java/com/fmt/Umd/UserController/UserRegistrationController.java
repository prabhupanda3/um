package com.fmt.Umd.UserController;

import java.security.Principal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fmt.Umd.Exception.UserRegistrationException;
import com.fmt.Umd.UserDto.UserDTO;
import com.fmt.Umd.model.Role;
import com.fmt.Umd.model.User;
import com.fmt.Umd.service.RoleService;
import com.fmt.Umd.service.UserDetailsServices;
@CrossOrigin(value="http://localhost:4200")
@RestController
@RequestMapping("/usermanagement")
public class UserRegistrationController {

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private RoleService roleService;
	@Autowired
	private UserDetailsServices userDetailsServices;
	@PostMapping("/createNewUser")
	public void userRegistration(@RequestBody UserDTO userdto) {
		try {
			System.out.println("Password :"+userdto.getPassword());
			if(userdto.getPassword().equals(userdto.getConfirmPassword())) {
				if(userdto.getUsername()!=null && userdto.getPassword()!="") {
					User user=new User();
					user.setUserIdName(userdto.getUserIdName());
					user.setUsername(userdto.getUsername());
					user.setAddress(userdto.getAddress());
					user.setEmail(userdto.getEmail());
					user.setMobileNumber(userdto.getMobileNumber());
					user.setPassword(passwordEncoder.encode(userdto.getPassword()));
					Set<Role> roles=new HashSet<>();
				    Role role=roleService.getRoleDetailsModuleSubmodule(userdto.getAutherity());
					roles.add(role);
					user.setRole(roles);
					//user.setImage(userdto.getImage().getName());
					userDetailsServices.saveUserDetails(user);
				}
				
			}
			else {
				UserRegistrationException exception=new UserRegistrationException("Password Mismatch Exception");
				throw exception;
			}
			
		}catch(UserRegistrationException exception) {
			exception.printStackTrace();
		}
	}
	@GetMapping("/getallautherity")
	public List<String> getAllChildAutherity(Principal principal) {
		List<String> autherity=null;
		try {
		String userName=principal.getName();
		autherity=roleService.getAllChildAutherityByUserName(userName);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return autherity;
	}
	
}
