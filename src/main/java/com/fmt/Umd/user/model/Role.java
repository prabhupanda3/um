package com.fmt.Umd.user.model;


import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import com.fmt.Umd.model.*;
import com.fmt.Umd.model.Module;

import org.springframework.security.core.GrantedAuthority;

@Entity 
public class Role implements GrantedAuthority {
    @Id
    @Column(name="role_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer roleId;
    @Column
    private String roleName;
    @Column(unique = true)
    private String authority;
    @Column
    private String roleDes;
    @ManyToMany(fetch=FetchType.EAGER,cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REMOVE})
    @JoinTable(joinColumns = {@JoinColumn(name="role_id")},
    inverseJoinColumns = {@JoinColumn(name="action_id")}
    )  
    @Column
    private List<SabModuleAction> sabmoduleAction;
    @Column
    private String parentRole;
    @ManyToMany(fetch = FetchType.EAGER,cascade = {CascadeType.DETACH})
    @JoinTable(joinColumns = {@JoinColumn(name="role_id")},
    inverseJoinColumns = {@JoinColumn(name="module_id")}
    )
    @Column
    private Set<Module> module;

	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
	public String getRoleDes() {
		return roleDes;
	}
	public void setRoleDes(String roleDes) {
		this.roleDes = roleDes;
	}

	
	
	public List<SabModuleAction> getSabmoduleAction() {
		return sabmoduleAction;
	}
	public void setSabmoduleAction(List<SabModuleAction> sabmoduleAction) {
		this.sabmoduleAction = sabmoduleAction;
	}
	public String getParentRole() {
		return parentRole;
	}
	public void setParentRole(String parentRole) {
		this.parentRole = parentRole;
	}
	@Override
	public String getAuthority() {
		return authority;
	}
	public void setAuthority(String authority) {
		this.authority = authority;
	}
	public Set<Module> getModule() {
		return module;
	}
	public void setModule(Set<Module> module) {
		this.module = module;
	}
	
	
	
	
	
	

}
