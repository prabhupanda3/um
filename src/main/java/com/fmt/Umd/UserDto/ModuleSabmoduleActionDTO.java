package com.fmt.Umd.UserDto;

import com.fmt.Umd.model.SabModuleAction;

public class ModuleSabmoduleActionDTO {
	private String moduleName;
	private String sabmoduleName;
	private SabModuleAction sabModuleAction;
	public ModuleSabmoduleActionDTO(String moduleName, String sabmoduleName, SabModuleAction sabModuleAction) {
		super();
		this.moduleName = moduleName;
		this.sabmoduleName = sabmoduleName;
		this.sabModuleAction = sabModuleAction;
	}
	public String getModuleName() {
		return moduleName;
	}
	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}
	public String getSabmoduleName() {
		return sabmoduleName;
	}
	public void setSabmoduleName(String sabmoduleName) {
		this.sabmoduleName = sabmoduleName;
	}
	public SabModuleAction getSabModuleAction() {
		return sabModuleAction;
	}
	public void setSabModuleAction(SabModuleAction sabModuleAction) {
		this.sabModuleAction = sabModuleAction;
	}
	

}
