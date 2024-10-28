package com.fmt.Umd.UserController;

import java.security.Principal;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fmt.Umd.model.Role;
import com.fmt.Umd.service.RoleService;

@RestController
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
}
