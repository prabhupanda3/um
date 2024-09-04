package com.fmt.Umd.Dto;

public class HierarchyDto {
	private String username;
	private int hierarchyId;
	
	private String hierarchyName;
	
	private int hierarchyPid;
	
	private int clientId;
	
	private int hierarchyTypeId;

	private String code;
	
	private double capacity;

	private double minLevel;
	
	private double maxLevel;
	
	private int activeFlag;

	private String hierarchyDesc;
	
	private String totalLevel;
	private String date;
	private String hirarchyLevel;
	

	
	public HierarchyDto() {
		super();
	}


	public HierarchyDto(String username, int hierarchyId, String hierarchyName, int hierarchyPid, int clientId,
			int hierarchyTypeId, String code, double capacity, double minLevel, double maxLevel, int activeFlag,
			String hierarchyDesc, String totalLevel, String date, String hirarchyLevel) {
		super();
		this.username = username;
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
		this.date = date;
		this.hirarchyLevel = hirarchyLevel;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
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


	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}


	public String getHirarchyLevel() {
		return hirarchyLevel;
	}


	public void setHirarchyLevel(String hirarchyLevel) {
		this.hirarchyLevel = hirarchyLevel;
	}
	
	
	
	
	
	
}
