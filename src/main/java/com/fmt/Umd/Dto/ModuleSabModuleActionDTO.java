package com.fmt.Umd.Dto;

import com.fmt.Umd.model.SabModuleAction;

public class ModuleSabModuleActionDTO {
private String moduleName;
private String subModuleName;
private SabModuleAction SabModuleAction;


public ModuleSabModuleActionDTO() {
	super();
}
public ModuleSabModuleActionDTO(String moduleName, String subModuleName,
		com.fmt.Umd.model.SabModuleAction sabModuleAction) {
	super();
	this.moduleName = moduleName;
	this.subModuleName = subModuleName;
	SabModuleAction = sabModuleAction;
}
public String getModuleName() {
	return moduleName;
}
public void setModuleName(String moduleName) {
	this.moduleName = moduleName;
}
public String getSubModuleName() {
	return subModuleName;
}
public void setSubModuleName(String subModuleName) {
	this.subModuleName = subModuleName;
}
public SabModuleAction getSabModuleAction() {
	return SabModuleAction;
}
public void setSabModuleAction(SabModuleAction sabModuleAction) {
	SabModuleAction = sabModuleAction;
}




}
