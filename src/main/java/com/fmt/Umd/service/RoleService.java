package com.fmt.Umd.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fmt.Umd.DeviceManagement.Repository.HierarchyMasterRepository;
import com.fmt.Umd.Dto.RoleDTO;
import com.fmt.Umd.Repository.ModuleRepository;
import com.fmt.Umd.Repository.RoleRepository;
import com.fmt.Umd.Repository.SabModuleActionRepository;
import com.fmt.Umd.Repository.SabModuleRepository;
import com.fmt.Umd.Repository.UserRepository;
import com.fmt.Umd.UserDto.ModuleSabmoduleActionDTO;
import com.fmt.Umd.model.Module;
import com.fmt.Umd.model.SabModuleAction;
import com.fmt.Umd.model.SubModule;
import com.fmt.Umd.user.model.Role;
@Service
public class RoleService {
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
     private RoleRepository roleRepository;
	@Autowired
	private ModuleRepository moduleRepository;
	@Autowired
	private SabModuleRepository sabModuleRepository;
	@Autowired
	private SabModuleActionRepository sabModuleActionRepository;
	@Autowired
	private HierarchyMasterRepository hierarchyMasterRepository;
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
	public Set<com.fmt.Umd.model.Module> getRolesByUserName(String username) {
		
		Set<com.fmt.Umd.model.Module> moduleSet=new HashSet<com.fmt.Umd.model.Module>();
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
		  	Role role=userRepository.getUSerRoleByUseName(username);
	     	List<SabModuleAction>	moduleActions=role.getSabmoduleAction();
			String authority=role.getAuthority();
				
			List<String> autheriryList=roleRepository.findAuthorityByParentRole(authority);
			            autheriryList.add(authority);
			 System.out.println("Array list"+autheriryList.toString());    
						rolesBasedOnParentRole=roleRepository.findAllByParentRoleIn(autheriryList);
				return rolesBasedOnParentRole;

		}catch(Exception ex) {
			ex.printStackTrace();
			return rolesBasedOnParentRole;
		}
		
	}
	public List<ModuleSabmoduleActionDTO> getModuleSubmodule(String userName){
		List<ModuleSabmoduleActionDTO> moduleDetails=new ArrayList<>();
		Role role=null;
		try {
				role=userRepository.getUSerRoleByUseName(userName);
			Set<Module>	modules=role.getModule();
		List<SabModuleAction>	sabmoduleAction=role.getSabmoduleAction();
			modules.stream().forEach((Module module)->{
				
				module.getSubModule().stream().forEach((SubModule submodule)->{
					sabmoduleAction.forEach((SabModuleAction sabModuleAction)->{
						if(submodule.getSubmoduleId()==sabModuleAction.getSabmodule().getSubmoduleId()) {
							moduleDetails.add(new ModuleSabmoduleActionDTO(module.getModuleName(),submodule.getSubmoduleName(),sabModuleAction));
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
	// ModuleSubmoduleaction by autherity
	public List<ModuleSabmoduleActionDTO> getModulActionByAutherity(String autherityName) {
		List<ModuleSabmoduleActionDTO> moduleDetails=new ArrayList<>();
		Role role=null;
		try {
			 role=roleRepository.findAllByAuthority(autherityName);
			Set<Module>	modules=role.getModule();
			List<SabModuleAction>	sabmoduleAction=role.getSabmoduleAction();
				modules.stream().forEach((Module module)->{
					
					module.getSubModule().stream().forEach((SubModule submodule)->{
						sabmoduleAction.forEach((SabModuleAction sabModuleAction)->{
							if(submodule.getSubmoduleId()==sabModuleAction.getSabmodule().getSubmoduleId()) {
								moduleDetails.add(new ModuleSabmoduleActionDTO(module.getModuleName(),submodule.getSubmoduleName(),sabModuleAction));
							}
						});
					});

				});
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return moduleDetails;
	}
        public RoleDTO createUserRole(RoleDTO roledto ){
        	RoleDTO roledtosuccess=new RoleDTO();
		      try {
		    	  Role role=new Role();
		    	  role.setAuthority(roledto.getAuthority());
		    	  role.setParentRole(roledto.getParentRole());
		    	  role.setRoleDes(roledto.getRoleDes());
		    	  role.setRoleName(roledto.getRoleName());	
		    List<ModuleSabmoduleActionDTO>	 listofaction= roledto.getModuleSabmoduleActionDTO();
		    Set<Module> moduleToBeAdded=new HashSet<>();
		    List<SabModuleAction> sabModuleActionList=new ArrayList<>();
		    List<SabModuleAction> sabModuleActions=new ArrayList<>();
		    listofaction.forEach((ModuleSabmoduleActionDTO msad)->{
			        SabModuleAction SabModuleAction=new SabModuleAction();
		            
		    	    Set<Module> modules=moduleRepository.findModuleByModuleName(msad.getModuleName());
		    	    modules.forEach((Module module)->{
		    	    	                   moduleToBeAdded.add(module);
		    	    	                   SabModuleAction.setModuleID(Integer.toString(module.getModuleId()));	                   
		    	    });
		    	    List<SubModule>    sabModules=sabModuleRepository.findSubmoduleBysubmoduleName(msad.getSabmoduleName());
		    	    sabModules.forEach((SubModule sabmodule)->
		    	    {
		    	    SabModuleAction.setSabmodule(sabmodule);
		    	    
		    	    });
		    	    SabModuleAction sabModuleAction1=  msad.getSabModuleAction();
		    	    SabModuleAction.setAdd( sabModuleAction1.getAdd());
		    	    SabModuleAction.setDelete( sabModuleAction1.getDelete());
		    	    SabModuleAction.setEdit(sabModuleAction1.getEdit());
		    	    SabModuleAction.setView( sabModuleAction1.getView());
		    	    sabModuleActionList.add(SabModuleAction);
		    	    sabModuleActions.add(sabModuleAction1);
		    	    
		    });
		    role.setSabmoduleAction(sabModuleActionList);
		    role.setModule(moduleToBeAdded);
		   
			   Role rolesuccess= roleRepository.save(role);
			   roledtosuccess.setAuthority(rolesuccess.getRoleName());

		   
		      }catch(Exception ex) {
			     ex.printStackTrace();
		       }
		      return roledtosuccess;
	}
	
        
        public List<String> getHierarchyDetails(){
        	List<String> hierarchyList=hierarchyMasterRepository.findHierarchyTitle();
        	return hierarchyList;
        	
        }
        
        public Role getRoleDetailsModuleSubmodule(String autherityName) {
        	Role role=null;
        	try {
        		role=roleRepository.findAllByAuthority(autherityName);
        	}catch(Exception ex) {
        		ex.printStackTrace();
        	}
        	return role;
        }
        
        public Role updateRoleSubmoduleAction(RoleDTO roledto) {
        Role rl=null;	
        	try {
        		String authority=roledto.getAuthority();
        		Role role=roleRepository.findAllByAuthority(authority);
        		
        		role.setAuthority(authority);
        		role.setParentRole(roledto.getParentRole());
        		role.setRoleDes(roledto.getRoleDes());
        		role.setRoleName(roledto.getRoleName());
                List<ModuleSabmoduleActionDTO> msad=roledto.getModuleSabmoduleActionDTO();
                List<SabModuleAction> submoduleactions=role.getSabmoduleAction();
                msad.forEach((ModuleSabmoduleActionDTO moduleSabmoduleActionDTO)->{	
                	Set<Module> modules=role.getModule();
                	modules.forEach((Module module)->{
                		if(moduleSabmoduleActionDTO.getModuleName().equals(module.getModuleName())) {
                		List<SubModule> submodules=	module.getSubModule();
                		submodules.forEach((SubModule submodule)->{
                			List<SabModuleAction> sabModuleActions=new ArrayList<>();
                			submoduleactions.forEach((SabModuleAction sabModuleAction)->{
                				if(submodule==sabModuleAction.getSabmodule()) {
                					SabModuleAction sabModuleAction1=new SabModuleAction();
                					sabModuleAction1.setActionID(sabModuleAction.getActionID());
                					sabModuleAction1.setModuleID(Integer.toString(module.getModuleId()));
                					sabModuleAction1.setSabmodule(submodule);
                					sabModuleAction1.setAdd(moduleSabmoduleActionDTO.getSabModuleAction().getAdd());
                					sabModuleAction1.setDelete(moduleSabmoduleActionDTO.getSabModuleAction().getDelete());
                					sabModuleAction1.setEdit(moduleSabmoduleActionDTO.getSabModuleAction().getEdit());
                					sabModuleAction1.setView(moduleSabmoduleActionDTO.getSabModuleAction().getView());
                					sabModuleActions.add(sabModuleAction1);
                					
                				}
                			});
                			role.setSabmoduleAction(sabModuleActions);
                			
                		});
                		}
                	});
                });
                
                rl=roleRepository.save(role); 
        	
        	}catch(Exception ex) {
        		ex.printStackTrace();
        	}
        	return rl;
        	
        }
        @Transactional
		public void deleteRoleSubmoduleAction(String autherityName) {
			// TODO Auto-generated method stub
			try {
				Set<Role> roles=roleRepository.findByAuthority(autherityName);
				roles.forEach((Role role)->{
					roleRepository.deleteById(role.getRoleId());
				});
			}catch(Exception ex) {
				ex.printStackTrace();
			}
			
		}
		public List<String> getAllChildAutherityByUserName(String userName) {
			// TODO Auto-generated method stub
			 List<String> listOfAutherity=null;
			try {
				Role role=userRepository.getUSerRoleByUseName(userName);
	            List<String> autherites=roleRepository.findAuthorityByParentRole(role.getAuthority());
	            autherites.add(role.getAuthority());
	            listOfAutherity=roleRepository.findAuthorityByParentRoleIn(autherites);
			}catch(Exception ex) {
				ex.printStackTrace();
			}
			return listOfAutherity;
			
		}
        
        
        
        
        
	}
	
	

