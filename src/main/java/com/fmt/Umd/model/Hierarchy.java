package com.fmt.Umd.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Hierarchy {
	@Id
    @Column(name="h_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(name="hierarchy_id")
	private int hierarchyId;
	@Column(name="hierarchy_name")
	private String hierarchyName;
	@Column(name="hierarchyPid")
	private int hierarchyPid;
	@Column(name="client_id")
	private int clientId;
	@Column(name="hierarchy_type_id")
	private int hierarchyTypeId;
	@Column(name="code")
	private String code;
	@Column(name="capacity")
	private double capacity;
	@Column(name="min_level")
	private double minLevel;
	@Column(name="max_level")
	private double maxLevel;
	@Column(name="active_flag")
	private int activeFlag;
	@Column(name="hierarchy_desc")
	private String hierarchyDesc;
	@Column(name="total_level")
	private String totalLevel;
	
	
	
	
	
	public Hierarchy() {
		super();
	}
	
	
	public Hierarchy(Long id, int hierarchyId, String hierarchyName, int hierarchyPid, int clientId,
			int hierarchyTypeId, String code, double capacity, double minLevel, double maxLevel, int activeFlag,
			String hierarchyDesc, String totalLevel) {
		super();
		this.id = id;
		this.hierarchyId = hierarchyId;
		this.hierarchyName = hierarchyName;
		this.hierarchyPid = hierarchyPid;
		this.clientId = clientId;
		this.hierarchyTypeId = hierarchyTypeId;
		this.code = code;
		this.capacity = capacity;
		this.minLevel = minLevel;
		this.maxLevel = maxLevel;
		this.activeFlag = activeFlag;
		this.hierarchyDesc = hierarchyDesc;
		this.totalLevel = totalLevel;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public int getHierarchyId() {
		return hierarchyId;
	}
	public void setHierarchyId(int hierarchyId) {
		this.hierarchyId = hierarchyId;
	}
	public String getHierarchyName() {
		return hierarchyName;
	}
	public void setHierarchyName(String hierarchyName) {
		this.hierarchyName = hierarchyName;
	}
	public int getHierarchyPid() {
		return hierarchyPid;
	}
	public void setHierarchyPid(int hierarchyPid) {
		this.hierarchyPid = hierarchyPid;
	}
	public int getClientId() {
		return clientId;
	}
	public void setClientId(int clientId) {
		this.clientId = clientId;
	}
	public int getHierarchyTypeId() {
		return hierarchyTypeId;
	}
	public void setHierarchyTypeId(int hierarchyTypeId) {
		this.hierarchyTypeId = hierarchyTypeId;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public double getCapacity() {
		return capacity;
	}
	public void setCapacity(double capacity) {
		this.capacity = capacity;
	}
	public double getMinLevel() {
		return minLevel;
	}
	public void setMinLevel(double minLevel) {
		this.minLevel = minLevel;
	}
	public double getMaxLevel() {
		return maxLevel;
	}
	public void setMaxLevel(double maxLevel) {
		this.maxLevel = maxLevel;
	}
	public int getActiveFlag() {
		return activeFlag;
	}
	public void setActiveFlag(int activeFlag) {
		this.activeFlag = activeFlag;
	}
	public String getHierarchyDesc() {
		return hierarchyDesc;
	}
	public void setHierarchyDesc(String hierarchyDesc) {
		this.hierarchyDesc = hierarchyDesc;
	}
	public String getTotalLevel() {
		return totalLevel;
	}
	public void setTotalLevel(String totalLevel) {
		this.totalLevel = totalLevel;
	}
	

	
	
	
	
	
	
}
