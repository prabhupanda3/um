package com.fmt.Umd.UserController;

import java.security.Principal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fmt.Umd.Dto.RoleDTO;
import com.fmt.Umd.UserDto.ModuleSabmoduleActionDTO;
import com.fmt.Umd.model.SabModuleAction;
import com.fmt.Umd.service.RoleService;
import com.fmt.Umd.service.UserDetailsServices;
import com.fmt.Umd.user.model.Role;

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
	public List<ModuleSabmoduleActionDTO> getModulesByUserName(Principal principal){
		Role role=null;
		List<ModuleSabmoduleActionDTO> msmad=null;
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
		String userName=principal.getName();
		hirarchyList=userDetailsServices.getAllListOfChildRoles(userName);
		return hirarchyList;
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return hirarchyList;
	}
	@PostMapping("roleCreation")
	public ResponseEntity<Map<String, String>> roleCreation(@RequestBody RoleDTO role) {
	    RoleDTO roles = null;
	    Map<String, String> hs = new HashMap<>();
	    try {
	        roles = roleService.createUserRole(role);
	        hs.put("message", "Role " + roles.getAuthority() + " created successfully");
	        return ResponseEntity.status(HttpStatus.CREATED).body(hs);
	    } catch (Exception ex) {
	        ex.printStackTrace();
	        hs.put("message", "Role " + (roles != null ? roles.getAuthority() : role.getAuthority()) + " could not be created successfully");
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(hs);
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
	public RoleDTO getRoleDetails(@PathVariable("autherityName")String autherityName,Principal principal) {
		Role role=null;
		RoleDTO roleDTO=null;
		try {
			//Parent ModuleSabmoduleActionDTO
			List<ModuleSabmoduleActionDTO>	parentModuleSubmodule=roleService.getModuleSubmodule(principal.getName());
			//Child ModuleSabmoduleActionDTO
			List<ModuleSabmoduleActionDTO> childModuleSubmodule= roleService.getModulActionByAutherity(autherityName);
			Role roleDetails=roleService.getRoleDetailsModuleSubmodule(autherityName);
			roleDTO=new RoleDTO();
			roleDTO.setAuthority(roleDetails.getAuthority());
			roleDTO.setParentRole(roleDetails.getParentRole());
			roleDTO.setRoleDes(roleDetails.getRoleDes());
			roleDTO.setRoleName(roleDetails.getRoleName());
			//List of ModuleSabmoduleActionDTOFinal
			List<ModuleSabmoduleActionDTO> moduleActionListFinal=new ArrayList<>();
			moduleActionListFinal.addAll(childModuleSubmodule);
			List<String> removableSubmodule=new ArrayList<>();
			moduleActionListFinal.forEach((ModuleSabmoduleActionDTO moduleSabmoduleActionDTO)->{
				removableSubmodule.add(moduleSabmoduleActionDTO.getSabmoduleName());
			});
			
			parentModuleSubmodule.forEach((ModuleSabmoduleActionDTO ModuleSabmoduleActionDTO)->{
				if(!removableSubmodule.contains(ModuleSabmoduleActionDTO.getSabmoduleName())) {
					ModuleSabmoduleActionDTO moduleSabmoduleActionDTO=new ModuleSabmoduleActionDTO();
					moduleSabmoduleActionDTO.setModuleName(ModuleSabmoduleActionDTO.getModuleName());
					moduleSabmoduleActionDTO.setSabmoduleName(ModuleSabmoduleActionDTO.getSabmoduleName());
					moduleSabmoduleActionDTO.setSabModuleAction(new SabModuleAction("0","0","0","0"));
					moduleActionListFinal.add(ModuleSabmoduleActionDTO);
				}
			});
			
			
			roleDTO.setModuleSabmoduleActionDTO(moduleActionListFinal);
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
			
		return roleDTO;
	}
	@PutMapping("updateUserRole")
	public ResponseEntity<Map<String, String>> updateRole(@RequestBody RoleDTO roleDTO) {
	    Role role = null;
	    Map<String, String> hs = new HashMap<>();
	    try {
	        role = roleService.updateRoleSubmoduleAction(roleDTO);
	        hs.put("message", "Role " + role.getAuthority() + " updated successfully");
	        return ResponseEntity.status(HttpStatus.OK).body(hs);
	    } catch (Exception ex) {
	        ex.printStackTrace();
	        String authority = (role != null) ? role.getAuthority() : roleDTO.getAuthority();
	        hs.put("message", "Role " + authority + " could not be updated");
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(hs);
	    }
	}

	@DeleteMapping("roleDelete/{autherityName}")
	public void deleteRole(@PathVariable("autherityName")String autherityName) {
		try {
			roleService.deleteRoleSubmoduleAction(autherityName);
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	
	
	
}
