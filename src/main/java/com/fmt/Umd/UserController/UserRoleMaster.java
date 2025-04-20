package com.fmt.Umd.UserController;

import java.security.Principal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fmt.Umd.Dto.ModuleSabModuleActionDTO;
import com.fmt.Umd.Dto.RoleDTO;
import com.fmt.Umd.UserDto.ModuleSabmoduleActionDTO;
import com.fmt.Umd.model.Role;
import com.fmt.Umd.model.SabModuleAction;
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
		 roledto.setRoleDes(role.getRoleDes());
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
	public ResponseEntity<Map<String, String>>  roleCreation(@RequestBody RoleDTO role) {
		RoleDTO roles=null;
		try {
			 roles=roleService.createUserRole(role);
            return ResponseEntity.status(HttpStatus.CREATED).body(Map.of("message","ROle "+roles.getAuthority()+" Created Successfully"));
		}catch(Exception ex) {
			ex.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Map.of("message","ROle "+roles.getAuthority()+" Can not be created successfully"));

		}
		
	}
	@GetMapping("hierarchyList")
	public List<String>  getHierarchyList() {
		List<String> hierarchyList=null;
		try {
			hierarchyList=roleService.getHierarchyDetails();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return hierarchyList;
	}
	@GetMapping("getallparentrole")
	public Set<String> getAllParentRole(Principal principal) {
		Set<String> parentRole=new HashSet<>();
		Set<Role> roles=null;

		try {
		roles=roleService.getGrantedAuthority(principal.getName());
		 roles.forEach((Role role)->{
			 parentRole.add(role.getAuthority()); 
		 });
		 
		}catch(Exception ex) {
			ex.printStackTrace();
			
		}
		return parentRole;
		
	}
	
	
	@GetMapping("roleModuleSubmoduleActiondetails/{autherityName}")
	public RoleDTO getRoleDetails(@PathVariable("autherityName")String autherityName) {
		Role role=null;
		RoleDTO roleDTO=null;
		try {
			roleDTO=new RoleDTO();
			role=roleService.getRoleDetailsModuleSubmodule(autherityName);
			Set<com.fmt.Umd.model.Module>	moduleset=role.getModule();
		List<SabModuleAction>	sabmoduleActionList=role.getSabmoduleAction();
			List<ModuleSabmoduleActionDTO> moduleSabModuleActionDTOList=new ArrayList<>();
			moduleset.forEach((com.fmt.Umd.model.Module module)->{
				ModuleSabmoduleActionDTO moduleSabModuleActionDTO=new ModuleSabmoduleActionDTO();
				sabmoduleActionList.forEach((SabModuleAction sabModuleAction)->{
					if(module.getModuleId()==Integer.parseInt(sabModuleAction.getModuleID())) {
						moduleSabModuleActionDTO.setModuleName(module.getModuleName());
						moduleSabModuleActionDTO.setSabmoduleName(sabModuleAction.getSabmodule().getSubmoduleName());
						SabModuleAction SabModuleActiontobeset=new SabModuleAction();
						SabModuleActiontobeset.setAdd(sabModuleAction.getAdd());
						SabModuleActiontobeset.setEdit(sabModuleAction.getEdit());
						SabModuleActiontobeset.setDelete(sabModuleAction.getDelete());
						SabModuleActiontobeset.setView(sabModuleAction.getView());
						moduleSabModuleActionDTO.setSabModuleAction(SabModuleActiontobeset);
					}
				});
				
				moduleSabModuleActionDTOList.add(moduleSabModuleActionDTO);
				
			});
			roleDTO.setRoleName(role.getAuthority());
			roleDTO.setRoleDes(role.getRoleDes());
			roleDTO.setModuleSabmoduleActionDTO(moduleSabModuleActionDTOList);
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return roleDTO;
	}
	@PutMapping("updateUserRole")
	public ResponseEntity<Map<String, String>>  updareRole(@RequestBody RoleDTO roleDTO) {
		Role role=null;
		try {
			role=roleService.updateRoleSubmoduleAction(roleDTO);
            return ResponseEntity.status(HttpStatus.OK).body(Map.of("message","ROle "+role.getAuthority()+" Updated Successfully"));
		}catch(Exception ex) {
			ex.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Map.of("message","ROle "+role.getAuthority()+" Can not be update"));

		}
	}
	
	
	
	
}
