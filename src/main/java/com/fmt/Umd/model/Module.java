package com.fmt.Umd.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="module")
public class Module {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="module_id")
    private int moduleId;
	@Column(name="moduleName")
	private String moduleName;
	@Column(name="moduleDescription")
	private String moduleDescription;
	@Column(name="displayOrder")
	private String displayOrder;
	@Column(name="activeFlag")
	private boolean activeFlag;
	 @ManyToMany(fetch = FetchType.EAGER)
	 @JoinTable(joinColumns = {@JoinColumn(name="module_id")},
		        inverseJoinColumns = {@JoinColumn(name="submodule_id")}
			    )
	private List<SubModule> subModule;
private String icon;
	
	public Module() {
		super();
	}
	
	public Module(int moduleId, String moduleName, String moduleDescription, String displayOrder, boolean activeFlag,
			List<SubModule> subModule, String icon) {
		super();
		this.moduleId = moduleId;
		this.moduleName = moduleName;
		this.moduleDescription = moduleDescription;
		this.displayOrder = displayOrder;
		this.activeFlag = activeFlag;
		this.subModule = subModule;
		this.icon = icon;
	}
	
	public int getModuleId() {
		return moduleId;
	}
	public void setModuleId(int moduleId) {
		this.moduleId = moduleId;
	}
	public String getModuleName() {
		return moduleName;
	}
	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}
	public String getModuleDescription() {
		return moduleDescription;
	}
	public void setModuleDescription(String moduleDescription) {
		this.moduleDescription = moduleDescription;
	}
	public String getDisplayOrder() {
		return displayOrder;
	}
	public void setDisplayOrder(String displayOrder) {
		this.displayOrder = displayOrder;
	}
	
	public List<SubModule> getSubModule() {
		return subModule;
	}
	public void setSubModule(List<SubModule> subModule) {
		this.subModule = subModule;
	}
	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public boolean isActiveFlag() {
		return activeFlag;
	}

	public void setActiveFlag(boolean activeFlag) {
		this.activeFlag = activeFlag;
	}
	
	
	
	

}
