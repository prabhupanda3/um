package com.fmt.Umd.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="SubModule")
public class SubModule {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="submodule_id")
    private int submoduleId;
	@Column(name="SubmoduleName")
	private String submoduleName;
	@Column(name="url")
	private String url;
	@Column(name="description")
	private String description;
	@Column(name="displayOrder")
	private String  displayOrder;
	@Column(name="activeFlag")
	private boolean activeFlag;
	@Column(name="endpoint")
	private String endpoint;
	
	
	public SubModule() {
		super();
	}
	

	public SubModule(int submoduleId, String submoduleName, String url, String description, String displayOrder,
			boolean activeFlag, String endpoint) {
		super();
		this.submoduleId = submoduleId;
		this.submoduleName = submoduleName;
		this.url = url;
		this.description = description;
		this.displayOrder = displayOrder;
		this.activeFlag = activeFlag;
		this.endpoint = endpoint;
	}





	public int getSubmoduleId() {
		return submoduleId;
	}
	public void setSubmoduleId(int submoduleId) {
		this.submoduleId = submoduleId;
	}
	public String getSubmoduleName() {
		return submoduleName;
	}
	public void setSubmoduleName(String submoduleName) {
		this.submoduleName = submoduleName;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDisplayOrder() {
		return displayOrder;
	}
	public void setDisplayOrder(String displayOrder) {
		this.displayOrder = displayOrder;
	}
	
	public String getEndpoint() {
		return endpoint;
	}
	public void setEndpoint(String endpoint) {
		this.endpoint = endpoint;
	}


	public boolean isActiveFlag() {
		return activeFlag;
	}


	public void setActiveFlag(boolean activeFlag) {
		this.activeFlag = activeFlag;
	}
	
	
	
}
