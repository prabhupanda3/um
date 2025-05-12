package com.fmt.Umd.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="meter_comm_track")
public  class LiveCommunication {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="slno")
	private Integer slno;
	@Column(name="meter_no")
	private String meterSerialNo;
	@Column(name="meter_data_status_code")
	private Integer meterDataStatusCode;
	@Column(name="d2_timestamp")
	private String d2TimeStamp;
	@Column(name="d3_timestamp")
	private String d3TimeStamp;
	@Column(name="log_timestamp")
    private String logtimestamp;
	@Column(name="meter_commisioned_timestamp")
	private String mct;
	@Column(name="meter_type")
	private String meterType;
	@Column(name="meter_data_type")
	private String meterDataType;
	@Column(name="meter_rtc_drift")
	private Integer mrd;
	@Column(name="power_fail_status_code")
	private Integer mfsc;
	@Column(name="RAPDRPID")
	private String rapdrpid;
	@Column(name="datasource")
	private String datasource;
	
	
	
	public LiveCommunication() {
		super();
	}
	public LiveCommunication(Integer slno, String meterSerialNo, Integer meterDataStatusCode, String d2TimeStamp,
			String d3TimeStamp, String logtimestamp, String mct, String meterType, String meterDataType, Integer mrd,
			Integer mfsc, String rapdrpid, String datasource) {
		super();
		this.slno = slno;
		this.meterSerialNo = meterSerialNo;
		this.meterDataStatusCode = meterDataStatusCode;
		this.d2TimeStamp = d2TimeStamp;
		this.d3TimeStamp = d3TimeStamp;
		this.logtimestamp = logtimestamp;
		this.mct = mct;
		this.meterType = meterType;
		this.meterDataType = meterDataType;
		this.mrd = mrd;
		this.mfsc = mfsc;
		this.rapdrpid = rapdrpid;
		this.datasource = datasource;
	}
	public Integer getSlno() {
		return slno;
	}
	public void setSlno(Integer slno) {
		this.slno = slno;
	}
	public String getMeterSerialNo() {
		return meterSerialNo;
	}
	public void setMeterSerialNo(String meterSerialNo) {
		this.meterSerialNo = meterSerialNo;
	}
	public Integer getMeterDataStatusCode() {
		return meterDataStatusCode;
	}
	public void setMeterDataStatusCode(Integer meterDataStatusCode) {
		this.meterDataStatusCode = meterDataStatusCode;
	}
	public String getD2TimeStamp() {
		return d2TimeStamp;
	}
	public void setD2TimeStamp(String d2TimeStamp) {
		this.d2TimeStamp = d2TimeStamp;
	}
	public String getD3TimeStamp() {
		return d3TimeStamp;
	}
	public void setD3TimeStamp(String d3TimeStamp) {
		this.d3TimeStamp = d3TimeStamp;
	}
	public String getLogtimestamp() {
		return logtimestamp;
	}
	public void setLogtimestamp(String logtimestamp) {
		this.logtimestamp = logtimestamp;
	}
	public String getMct() {
		return mct;
	}
	public void setMct(String mct) {
		this.mct = mct;
	}
	public String getMeterType() {
		return meterType;
	}
	public void setMeterType(String meterType) {
		this.meterType = meterType;
	}
	public String getMeterDataType() {
		return meterDataType;
	}
	public void setMeterDataType(String meterDataType) {
		this.meterDataType = meterDataType;
	}
	public Integer getMrd() {
		return mrd;
	}
	public void setMrd(Integer mrd) {
		this.mrd = mrd;
	}
	public Integer getMfsc() {
		return mfsc;
	}
	public void setMfsc(Integer mfsc) {
		this.mfsc = mfsc;
	}
	public String getRapdrpid() {
		return rapdrpid;
	}
	public void setRapdrpid(String rapdrpid) {
		this.rapdrpid = rapdrpid;
	}
	public String getDatasource() {
		return datasource;
	}
	public void setDatasource(String datasource) {
		this.datasource = datasource;
	}
	
}
