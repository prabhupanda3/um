package com.fmt.Umd.DeviceManagement.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class HierarchyMaster {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="hm_id")
	private int id;
	@Column(name="hierarchy_type_id")
	private int HierarchyTypeId;
	@Column(name="hierarchy_title")
	private String hierarchyTitle;
	@Column(name="clientId")
	private int clientId;
	@Column(name="title_desc")
	private String titleString;
	@Column(name="parent_title_id")
	private int parentTitleId;
	@Column(name="active_flag")
	private int activeFlag;
	@Column(name="device_location")
	private String deviceLocation;
	
	
	
	public HierarchyMaster() {
		super();
	}
	public HierarchyMaster(int id, int hierarchyTypeId, String hierarchyTitle, int clientId, String titleString,
			int parentTitleId, int activeFlag, String deviceLocation) {
		super();
		this.id = id;
		HierarchyTypeId = hierarchyTypeId;
		this.hierarchyTitle = hierarchyTitle;
		this.clientId = clientId;
		this.titleString = titleString;
		this.parentTitleId = parentTitleId;
		this.activeFlag = activeFlag;
		this.deviceLocation = deviceLocation;
	}
	public void setHierarchyTitle(String hierarchyTitle) {
		this.hierarchyTitle = hierarchyTitle;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getHierarchyTypeId() {
		return HierarchyTypeId;
	}
	public void setHierarchyTypeId(int hierarchyTypeId) {
		HierarchyTypeId = hierarchyTypeId;
	}
	
	public int getClientId() {
		return clientId;
	}
	public void setClientId(int clientId) {
		this.clientId = clientId;
	}
	public String getTitleString() {
		return titleString;
	}
	public void setTitleString(String titleString) {
		this.titleString = titleString;
	}
	public int getParentTitleId() {
		return parentTitleId;
	}
	public void setParentTitleId(int parentTitleId) {
		this.parentTitleId = parentTitleId;
	}
	public int getActiveFlag() {
		return activeFlag;
	}
	public void setActiveFlag(int activeFlag) {
		this.activeFlag = activeFlag;
	}
	public String getDeviceLocation() {
		return deviceLocation;
	}
	public void setDeviceLocation(String deviceLocation) {
		this.deviceLocation = deviceLocation;
	}
	public String getHierarchyTitle() {
		return hierarchyTitle;
	}
	
	
	
	

}
