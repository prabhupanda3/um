package com.fmt.Umd.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Table(name="total_masterdata")
@Entity
public class TotalMasterData {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="slno")
	private Integer slno;
	@Column(name="region")
	private String region;
	@Column(name="region_id")
	private double regionid;
	@Column(name="region_pid")
	private double region_pid;
	@Column(name="region_code")
	private String region_code;
	@Column(name="circle")
	private String circle;
	@Column(name="circle_id")
	private double circleid;
	@Column(name="circle_pid")
	private double circle_pid;
	@Column(name="circle_code")
	private String circle_code;
	@Column(name="division")
	private String division;
	@Column(name="division_id")
	private double divisionid;
	@Column(name="division_pid")
	private double division_pid;
	@Column(name="division_code")
	private String division_code;
	@Column(name="sd")
	private String sd;
	@Column(name="sd_id")
	private double sdid;
	@Column(name="sd_pid")
	private double sd_pid;
	@Column(name="ss")
	private String ss;
	@Column(name="ss_id")
	private double ssid;
	@Column(name="ss_pid")
	private double ss_pid;
	@Column(name="ss_code")
	private String ss_code;
	@Column(name="ptr")
	private String ptr;
	@Column(name="ptr_id")
	private double ptr_id;
	@Column(name="ptr_pid")
	private double ptr_pid;
	@Column(name="meter_sl_no")
	private String meter_sl_no;
	@Column(name="meter_make")
	private String meter_make;
	@Column(name="meter_type")
	private String meter_type;
	@Column(name="meter_location")
	private String meter_location;
	@Column(name="mf")
	private float mf;
	@Column(name="location_id")
	private double location_id;
	@Column(name="modem_sl_no")
	private String modem_sl_no;
	@Column(name="modem_mobile_no")
	private String modem_mobile_no;
	@Column(name="location_name")
	private String location_name;
	@Column(name="location_code")
	private String location_code;
	@Column(name="location_category")
	private String location_category;
	@Column(name="location_group")
	private String location_group;
	@Column(name="location_type")
	private String location_type;
	@Column(name="sanction_load")
	private String sanction_load;
	@Column(name="contract_demand")
	private String contract_demand;
	@Column(name="supply_voltage")
	private String supply_voltage;
	@Column(name="category")
	private String category;
	@Column(name="lattitude")
    private String lattitude;
	@Column(name="longitude")
	private String longitude;
	@Column(name="log_timestamp")
	private String log_timestamp;
	@Column(name="ss_contact_number")
	private String ss_contact_number;
	@Column(name="ss_contact_person")
	private String ss_contact_person;
	@Column(name="ehv_ss")
	private String ehv_ss;
	@Column(name="is_active")
	private String is_active;
	public TotalMasterData(Integer slno, String region, double regionid, double region_pid, String region_code,
			String circle, double circleid, double circle_pid, String circle_code, String division, double divisionid,
			double division_pid, String division_code, String sd, double sdid, double sd_pid, String ss, double ssid,
			double ss_pid, String ss_code, String ptr, double ptr_id, double ptr_pid, String meter_sl_no,
			String meter_make, String meter_type, String meter_location, float mf, double location_id,
			String modem_sl_no, String modem_mobile_no, String location_name, String location_code,
			String location_category, String location_group, String location_type, String sanction_load,
			String contract_demand, String supply_voltage, String category, String lattitude, String longitude,
			String log_timestamp, String ss_contact_number, String ss_contact_person, String ehv_ss, String is_active) {
		super();
		this.slno = slno;
		this.region = region;
		this.regionid = regionid;
		this.region_pid = region_pid;
		this.region_code = region_code;
		this.circle = circle;
		this.circleid = circleid;
		this.circle_pid = circle_pid;
		this.circle_code = circle_code;
		this.division = division;
		this.divisionid = divisionid;
		this.division_pid = division_pid;
		this.division_code = division_code;
		this.sd = sd;
		this.sdid = sdid;
		this.sd_pid = sd_pid;
		this.ss = ss;
		this.ssid = ssid;
		this.ss_pid = ss_pid;
		this.ss_code = ss_code;
		this.ptr = ptr;
		this.ptr_id = ptr_id;
		this.ptr_pid = ptr_pid;
		this.meter_sl_no = meter_sl_no;
		this.meter_make = meter_make;
		this.meter_type = meter_type;
		this.meter_location = meter_location;
		this.mf = mf;
		this.location_id = location_id;
		this.modem_sl_no = modem_sl_no;
		this.modem_mobile_no = modem_mobile_no;
		this.location_name = location_name;
		this.location_code = location_code;
		this.location_category = location_category;
		this.location_group = location_group;
		this.location_type = location_type;
		this.sanction_load = sanction_load;
		this.contract_demand = contract_demand;
		this.supply_voltage = supply_voltage;
		this.category = category;
		this.lattitude = lattitude;
		this.longitude = longitude;
		this.log_timestamp = log_timestamp;
		this.ss_contact_number = ss_contact_number;
		this.ss_contact_person = ss_contact_person;
		this.ehv_ss = ehv_ss;
		this.is_active = is_active;
	}
	public TotalMasterData() {
		super();
	}
	public Integer getSlno() {
		return slno;
	}
	public void setSlno(Integer slno) {
		this.slno = slno;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public double getRegionid() {
		return regionid;
	}
	public void setRegionid(double regionid) {
		this.regionid = regionid;
	}
	public double getRegion_pid() {
		return region_pid;
	}
	public void setRegion_pid(double region_pid) {
		this.region_pid = region_pid;
	}
	public String getRegion_code() {
		return region_code;
	}
	public void setRegion_code(String region_code) {
		this.region_code = region_code;
	}
	public String getCircle() {
		return circle;
	}
	public void setCircle(String circle) {
		this.circle = circle;
	}
	public double getCircleid() {
		return circleid;
	}
	public void setCircleid(double circleid) {
		this.circleid = circleid;
	}
	public double getCircle_pid() {
		return circle_pid;
	}
	public void setCircle_pid(double circle_pid) {
		this.circle_pid = circle_pid;
	}
	public String getCircle_code() {
		return circle_code;
	}
	public void setCircle_code(String circle_code) {
		this.circle_code = circle_code;
	}
	public String getDivision() {
		return division;
	}
	public void setDivision(String division) {
		this.division = division;
	}
	public double getDivisionid() {
		return divisionid;
	}
	public void setDivisionid(double divisionid) {
		this.divisionid = divisionid;
	}
	public double getDivision_pid() {
		return division_pid;
	}
	public void setDivision_pid(double division_pid) {
		this.division_pid = division_pid;
	}
	public String getDivision_code() {
		return division_code;
	}
	public void setDivision_code(String division_code) {
		this.division_code = division_code;
	}
	public String getSd() {
		return sd;
	}
	public void setSd(String sd) {
		this.sd = sd;
	}
	public double getSdid() {
		return sdid;
	}
	public void setSdid(double sdid) {
		this.sdid = sdid;
	}
	public double getSd_pid() {
		return sd_pid;
	}
	public void setSd_pid(double sd_pid) {
		this.sd_pid = sd_pid;
	}
	public String getSs() {
		return ss;
	}
	public void setSs(String ss) {
		this.ss = ss;
	}
	public double getSsid() {
		return ssid;
	}
	public void setSsid(double ssid) {
		this.ssid = ssid;
	}
	public double getSs_pid() {
		return ss_pid;
	}
	public void setSs_pid(double ss_pid) {
		this.ss_pid = ss_pid;
	}
	public String getSs_code() {
		return ss_code;
	}
	public void setSs_code(String ss_code) {
		this.ss_code = ss_code;
	}
	public String getPtr() {
		return ptr;
	}
	public void setPtr(String ptr) {
		this.ptr = ptr;
	}
	public double getPtr_id() {
		return ptr_id;
	}
	public void setPtr_id(double ptr_id) {
		this.ptr_id = ptr_id;
	}
	public double getPtr_pid() {
		return ptr_pid;
	}
	public void setPtr_pid(double ptr_pid) {
		this.ptr_pid = ptr_pid;
	}
	public String getMeter_sl_no() {
		return meter_sl_no;
	}
	public void setMeter_sl_no(String meter_sl_no) {
		this.meter_sl_no = meter_sl_no;
	}
	public String getMeter_make() {
		return meter_make;
	}
	public void setMeter_make(String meter_make) {
		this.meter_make = meter_make;
	}
	public String getMeter_type() {
		return meter_type;
	}
	public void setMeter_type(String meter_type) {
		this.meter_type = meter_type;
	}
	public String getMeter_location() {
		return meter_location;
	}
	public void setMeter_location(String meter_location) {
		this.meter_location = meter_location;
	}
	public float getMf() {
		return mf;
	}
	public void setMf(float mf) {
		this.mf = mf;
	}
	public double getLocation_id() {
		return location_id;
	}
	public void setLocation_id(double location_id) {
		this.location_id = location_id;
	}
	public String getModem_sl_no() {
		return modem_sl_no;
	}
	public void setModem_sl_no(String modem_sl_no) {
		this.modem_sl_no = modem_sl_no;
	}
	public String getModem_mobile_no() {
		return modem_mobile_no;
	}
	public void setModem_mobile_no(String modem_mobile_no) {
		this.modem_mobile_no = modem_mobile_no;
	}
	public String getLocation_name() {
		return location_name;
	}
	public void setLocation_name(String location_name) {
		this.location_name = location_name;
	}
	public String getLocation_code() {
		return location_code;
	}
	public void setLocation_code(String location_code) {
		this.location_code = location_code;
	}
	public String getLocation_category() {
		return location_category;
	}
	public void setLocation_category(String location_category) {
		this.location_category = location_category;
	}
	public String getLocation_group() {
		return location_group;
	}
	public void setLocation_group(String location_group) {
		this.location_group = location_group;
	}
	public String getLocation_type() {
		return location_type;
	}
	public void setLocation_type(String location_type) {
		this.location_type = location_type;
	}
	public String getSanction_load() {
		return sanction_load;
	}
	public void setSanction_load(String sanction_load) {
		this.sanction_load = sanction_load;
	}
	public String getContract_demand() {
		return contract_demand;
	}
	public void setContract_demand(String contract_demand) {
		this.contract_demand = contract_demand;
	}
	public String getSupply_voltage() {
		return supply_voltage;
	}
	public void setSupply_voltage(String supply_voltage) {
		this.supply_voltage = supply_voltage;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getLattitude() {
		return lattitude;
	}
	public void setLattitude(String lattitude) {
		this.lattitude = lattitude;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getLog_timestamp() {
		return log_timestamp;
	}
	public void setLog_timestamp(String log_timestamp) {
		this.log_timestamp = log_timestamp;
	}
	public String getSs_contact_number() {
		return ss_contact_number;
	}
	public void setSs_contact_number(String ss_contact_number) {
		this.ss_contact_number = ss_contact_number;
	}
	public String getSs_contact_person() {
		return ss_contact_person;
	}
	public void setSs_contact_person(String ss_contact_person) {
		this.ss_contact_person = ss_contact_person;
	}
	public String getEhv_ss() {
		return ehv_ss;
	}
	public void setEhv_ss(String ehv_ss) {
		this.ehv_ss = ehv_ss;
	}
	public String getIs_active() {
		return is_active;
	}
	public void setIs_active(String is_active) {
		this.is_active = is_active;
	}
	
	
	
	
	
	
}
