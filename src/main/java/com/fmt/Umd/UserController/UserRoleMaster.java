package com.fmt.Umd.UserController;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fmt.Umd.UserDto.ModuleSabmoduleActionDTO;
import com.fmt.Umd.model.Role;
import com.fmt.Umd.model.SabModuleAction;
import com.fmt.Umd.model.SubModule;
import com.fmt.Umd.service.RoleService;

@RestController
@CrossOrigin(value = "http://localhost:4200")

@RequestMapping("/userRole/")

public class UserRoleMaster {
@Autowired
private RoleService roleService;
	
	@GetMapping("childRole")
	public Set<Role> userChildRoleMaster(Principal principal) {

		Set<Role> childrole=null;
		try {
			String userName=principal.getName();
			childrole=roleService.getGrantedAuthority(userName);
			
			
			return childrole;	
		}catch(Exception ex) {
			ex.printStackTrace();
			return childrole;
		}
	}
	@GetMapping("moduleSabmodule")
	public Role getModulesByUserName(Principal principal){
		Role role=null;
		try {
			return role;
		
	
		}catch(Exception ex) {
			ex.printStackTrace();
			return role;

		}
	}
	
	
	
	
	
}
