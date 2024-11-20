package com.fmt.Umd.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fmt.Umd.Dto.ModuleSabModuleActionDTO;
import com.fmt.Umd.Repository.RoleRepository;
import com.fmt.Umd.Repository.UserRepository;
import com.fmt.Umd.model.Module;
import com.fmt.Umd.model.Role;
import com.fmt.Umd.model.SabModuleAction;
import com.fmt.Umd.model.SubModule;
@Service
public class RoleService {
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
     private RoleRepository roleRepository;
	
	 public RoleService() {
			super();
		}
	public List<Role> getAllRoles() {
		List<Role> role=new ArrayList<>();
		try {
			 role=roleRepository.findAll();
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		return role;
	}
	public Set<Module> getRolesByUserName(String username) {
		
		Set<Module> moduleSet=new HashSet<Module>();
		try {
	Role	roles=userRepository.getUSerRoleByUseName(username);
	//roles.stream().forEach(role->endpoints.add(role.getEndPoint()));
	 moduleSet= roles.getModule();
	return moduleSet;
	}
	catch(Exception ex) {
		
		ex.printStackTrace();
		return moduleSet;
	}
	}
	public Set<Role> getGrantedAuthority(String username){
		Set<Role>	rolesBasedOnParentRole=null;
		try {
			Role	role=userRepository.getUSerRoleByUseName(username);
		List<SabModuleAction>	moduleActions=role.getSabmoduleAction();
				String authority=role.getAuthority();
				rolesBasedOnParentRole=roleRepository.findAllByParentRole(authority);
				
				return rolesBasedOnParentRole;

		}catch(Exception ex) {
			ex.printStackTrace();
			return rolesBasedOnParentRole;
		}
		
	}
	public List<ModuleSabModuleActionDTO> getModuleSubmodule(String userName){
		List<ModuleSabModuleActionDTO> moduleDetails=new ArrayList<>();
		Role role=null;
		try {
				role=userRepository.getUSerRoleByUseName(userName);
			Set<Module>	modules=role.getModule();
		List<SabModuleAction>	sabmoduleAction=role.getSabmoduleAction();
			modules.stream().forEach((Module module)->{
				;
				module.getSubModule().stream().forEach((SubModule submodule)->{
					sabmoduleAction.forEach((SabModuleAction sabModuleAction)->{
						if(submodule.getSubmoduleId()==sabModuleAction.getSabmodule().getSubmoduleId()) {
							moduleDetails.add(new ModuleSabModuleActionDTO(module.getModuleName(),submodule.getSubmoduleName(),sabModuleAction));
						}
					});
				});

			});
			return moduleDetails;

		}catch(Exception ex) {
			ex.printStackTrace();
			return moduleDetails;
		}
	}
	
	
	
	}
	
	

