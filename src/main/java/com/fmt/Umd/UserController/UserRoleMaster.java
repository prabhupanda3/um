package com.fmt.Umd.UserController;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fmt.Umd.Dto.ModuleSabModuleActionDTO;
import com.fmt.Umd.Dto.RoleDTO;
import com.fmt.Umd.model.Role;
import com.fmt.Umd.service.RoleService;
import com.fmt.Umd.service.UserDetailsServices;

@RestController
@CrossOrigin(value = "http://localhost:4200")

@RequestMapping("/userRole/")

public class UserRoleMaster {
@Autowired
private RoleService roleService;
@Autowired
private UserDetailsServices userDetailsServices;
	
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
	public List<ModuleSabModuleActionDTO> getModulesByUserName(Principal principal){
		Role role=null;
		List<ModuleSabModuleActionDTO> msmad=null;
		try {
			
			msmad=roleService.getModuleSubmodule(principal.getName());
			
			return msmad;
	
		}catch(Exception ex) {
			ex.printStackTrace();
			return msmad;

		}
	}
	@GetMapping("childRoleforUser")
    public List<RoleDTO>	getRoleByParentRole(Principal principal){
	Set<Role> roles=null;
	List<RoleDTO> roledtos=new ArrayList<>();
	try {
	 roles=roleService.getGrantedAuthority(principal.getName());
	 roles.forEach((Role role)->{
		 RoleDTO roledto=new RoleDTO();
		 roledto.setAuthority(role.getAuthority());
		 roledto.setParentRole(role.getParentRole());
		 roledto.setRoleDesc(role.getRoleDes());
		 roledto.setRoleName(role.getRoleName());
		 roledtos.add(roledto);
	 });
	 
		return roledtos;
	}catch(Exception ex) {
		return roledtos;
	}
	
}

	@GetMapping("listOfChildRole")
	public List<String> getHierarchyByUserName(Principal principal) {
		List<String> hirarchyList=null;
		try {
		String userName=	principal.getName();
		hirarchyList=userDetailsServices.getAllListOfChildRoles(userName);
		return hirarchyList;
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return hirarchyList;
	}
	@PostMapping("roleCreation")
	public void roleCreation(@RequestBody RoleDTO role) {
		try {
			roleService.createUserRole(role);
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
	}
	
	
}
