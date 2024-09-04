package com.fmt.Umd.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Load_Servey_Staging")
public class LoadServey {
	@Id
    @Column(name="seqid")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name="datasourceid")
	private String datasourceid;
	@Column(name="current_b")
	private String current_b;
	@Column(name="voltage_yn")
	private String voltage_yn;
	@Column(name="current_y")
	private String current_y;
	@Column(name="voltage_bn")
	private String voltage_bn;
	@Column(name="meterserialno")
	private String meterserialno;
	@Column(name="current_r")
	private String current_r;
	@Column(name="voltage_rn")
	private String voltage_rn;
	@Column(name="reactiveenergy_varh_lead_import")
	private String reactiveenergy_varh_lead_import;
	@Column(name="reactiveenergy_varh_lag_export")
	private String reactiveenergy_varh_lag_export;
	@Column(name="reactiveenergy_varh_lag_import")
	private String reactiveenergy_varh_lag_import;
	@Column(name="reactiveenergy_varh_lead_export")
	private String reactiveenergy_varh_lead_export;
	@Column(name="meterreading_timestamp")
	private String meterreading_timestamp;
	@Column(name="server_timestamp")
	private String server_timestamp;
	@Column(name="devicemanufacturer_tblrefid")
	private String devicemanufacturer_tblrefid;
	@Column(name="activepowerimport_wh")
	private String activepowerimport_wh;
	@Column(name="apparentpowerimport_vah")
	private String apparentpowerimport_vah;
	@Column(name="sequence_number",unique=true)
	private String sequence_number;
	@Column(name="activepowerexport_wh")
	private String activepowerexport_wh;
	@Column(name="apparentpowerexport_vah")
	private String apparentpowerexport_vah;
	@Column(name="neutralcurrent")
	private String neutralcurrent;
	@Column(name="statusbyte")
	private String statusbyte;
	@Column(name="Sender")
	private String sender;
	@Column(name="processed",nullable = false)
	private boolean processed=false;
	@Column(name="file_name")
	private String fileName;
	
	
	
	public LoadServey() {
		super();
	}
	public LoadServey(Long id, String datasourceid, String current_b, String voltage_yn, String current_y,
			String voltage_bn, String meterserialno, String current_r, String voltage_rn,
			String reactiveenergy_varh_lead_import, String reactiveenergy_varh_lag_export,
			String reactiveenergy_varh_lag_import, String reactiveenergy_varh_lead_export,
			String meterreading_timestamp, String server_timestamp, String devicemanufacturer_tblrefid,
			String activepowerimport_wh, String apparentpowerimport_vah, String sequence_number,
			String activepowerexport_wh, String apparentpowerexport_vah, String neutralcurrent, String statusbyte,
			String sender, boolean processed,String fileName) {
		super();
		this.id = id;
		this.datasourceid = datasourceid;
		this.current_b = current_b;
		this.voltage_yn = voltage_yn;
		this.current_y = current_y;
		this.voltage_bn = voltage_bn;
		this.meterserialno = meterserialno;
		this.current_r = current_r;
		this.voltage_rn = voltage_rn;
		this.reactiveenergy_varh_lead_import = reactiveenergy_varh_lead_import;
		this.reactiveenergy_varh_lag_export = reactiveenergy_varh_lag_export;
		this.reactiveenergy_varh_lag_import = reactiveenergy_varh_lag_import;
		this.reactiveenergy_varh_lead_export = reactiveenergy_varh_lead_export;
		this.meterreading_timestamp = meterreading_timestamp;
		this.server_timestamp = server_timestamp;
		this.devicemanufacturer_tblrefid = devicemanufacturer_tblrefid;
		this.activepowerimport_wh = activepowerimport_wh;
		this.apparentpowerimport_vah = apparentpowerimport_vah;
		this.sequence_number = sequence_number;
		this.activepowerexport_wh = activepowerexport_wh;
		this.apparentpowerexport_vah = apparentpowerexport_vah;
		this.neutralcurrent = neutralcurrent;
		this.statusbyte = statusbyte;
		this.sender = sender;
		this.processed = processed;
		this.fileName=fileName;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDatasourceid() {
		return datasourceid;
	}
	public void setDatasourceid(String datasourceid) {
		this.datasourceid = datasourceid;
	}
	public String getCurrent_b() {
		return current_b;
	}
	public void setCurrent_b(String current_b) {
		this.current_b = current_b;
	}
	public String getVoltage_yn() {
		return voltage_yn;
	}
	public void setVoltage_yn(String voltage_yn) {
		this.voltage_yn = voltage_yn;
	}
	public String getCurrent_y() {
		return current_y;
	}
	public void setCurrent_y(String current_y) {
		this.current_y = current_y;
	}
	public String getVoltage_bn() {
		return voltage_bn;
	}
	public void setVoltage_bn(String voltage_bn) {
		this.voltage_bn = voltage_bn;
	}
	public String getMeterserialno() {
		return meterserialno;
	}
	public void setMeterserialno(String meterserialno) {
		this.meterserialno = meterserialno;
	}
	public String getCurrent_r() {
		return current_r;
	}
	public void setCurrent_r(String current_r) {
		this.current_r = current_r;
	}
	public String getVoltage_rn() {
		return voltage_rn;
	}
	public void setVoltage_rn(String voltage_rn) {
		this.voltage_rn = voltage_rn;
	}
	public String getReactiveenergy_varh_lead_import() {
		return reactiveenergy_varh_lead_import;
	}
	public void setReactiveenergy_varh_lead_import(String reactiveenergy_varh_lead_import) {
		this.reactiveenergy_varh_lead_import = reactiveenergy_varh_lead_import;
	}
	public String getReactiveenergy_varh_lag_export() {
		return reactiveenergy_varh_lag_export;
	}
	public void setReactiveenergy_varh_lag_export(String reactiveenergy_varh_lag_export) {
		this.reactiveenergy_varh_lag_export = reactiveenergy_varh_lag_export;
	}
	public String getReactiveenergy_varh_lag_import() {
		return reactiveenergy_varh_lag_import;
	}
	public void setReactiveenergy_varh_lag_import(String reactiveenergy_varh_lag_import) {
		this.reactiveenergy_varh_lag_import = reactiveenergy_varh_lag_import;
	}
	public String getReactiveenergy_varh_lead_export() {
		return reactiveenergy_varh_lead_export;
	}
	public void setReactiveenergy_varh_lead_export(String reactiveenergy_varh_lead_export) {
		this.reactiveenergy_varh_lead_export = reactiveenergy_varh_lead_export;
	}
	public String getMeterreading_timestamp() {
		return meterreading_timestamp;
	}
	public void setMeterreading_timestamp(String meterreading_timestamp) {
		this.meterreading_timestamp = meterreading_timestamp;
	}
	public String getServer_timestamp() {
		return server_timestamp;
	}
	public void setServer_timestamp(String server_timestamp) {
		this.server_timestamp = server_timestamp;
	}
	public String getDevicemanufacturer_tblrefid() {
		return devicemanufacturer_tblrefid;
	}
	public void setDevicemanufacturer_tblrefid(String devicemanufacturer_tblrefid) {
		this.devicemanufacturer_tblrefid = devicemanufacturer_tblrefid;
	}
	public String getActivepowerimport_wh() {
		return activepowerimport_wh;
	}
	public void setActivepowerimport_wh(String activepowerimport_wh) {
		this.activepowerimport_wh = activepowerimport_wh;
	}
	public String getApparentpowerimport_vah() {
		return apparentpowerimport_vah;
	}
	public void setApparentpowerimport_vah(String apparentpowerimport_vah) {
		this.apparentpowerimport_vah = apparentpowerimport_vah;
	}
	public String getSequence_number() {
		return sequence_number;
	}
	public void setSequence_number(String sequence_number) {
		this.sequence_number = sequence_number;
	}
	public String getActivepowerexport_wh() {
		return activepowerexport_wh;
	}
	public void setActivepowerexport_wh(String activepowerexport_wh) {
		this.activepowerexport_wh = activepowerexport_wh;
	}
	public String getApparentpowerexport_vah() {
		return apparentpowerexport_vah;
	}
	public void setApparentpowerexport_vah(String apparentpowerexport_vah) {
		this.apparentpowerexport_vah = apparentpowerexport_vah;
	}
	public String getNeutralcurrent() {
		return neutralcurrent;
	}
	public void setNeutralcurrent(String neutralcurrent) {
		this.neutralcurrent = neutralcurrent;
	}
	public String getStatusbyte() {
		return statusbyte;
	}
	public void setStatusbyte(String statusbyte) {
		this.statusbyte = statusbyte;
	}
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public boolean isProcessed() {
		return processed;
	}
	public void setProcessed(boolean processed) {
		this.processed = processed;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	

}
