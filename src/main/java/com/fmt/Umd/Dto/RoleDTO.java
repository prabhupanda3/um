package com.fmt.Umd.Dto;

import java.util.List;

import com.fmt.Umd.UserDto.ModuleSabmoduleActionDTO;

public class RoleDTO {

	public RoleDTO() {
		// TODO Auto-generated constructor stub
	}
	private String authority;
	private String roleName;
	private String parentRole;
	private String roleDesc;
	private List<ModuleSabmoduleActionDTO> moduleSabmoduleActionDTO;
	
	
	
	
	public String getAuthority() {
		return authority;
	}
	public void setAuthority(String authority) {
		this.authority = authority;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getParentRole() {
		return parentRole;
	}
	public void setParentRole(String parentRole) {
		this.parentRole = parentRole;
	}
	public String getRoleDesc() {
		return roleDesc;
	}
	public void setRoleDesc(String roleDesc) {
		this.roleDesc = roleDesc;
	}
	public List<ModuleSabmoduleActionDTO> getModuleSabmoduleActionDTO() {
		return moduleSabmoduleActionDTO;
	}
	public void setModuleSabmoduleActionDTO(List<ModuleSabmoduleActionDTO> moduleSabmoduleActionDTO) {
		this.moduleSabmoduleActionDTO = moduleSabmoduleActionDTO;
	}
	
	
	

}
