package com.fmt.Umd.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="d4_data")
public class D4data {
	@Id
    @Column(name="app_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long appId;
	@Column(name="CDFID")
	private String cdfid;
	@Column(name="D4_DATE")
	private String d4date;
	@Column(name="TIME_DELAY")
	private double timeDelay;
	@Column(name="DATA_STRING")
	private String dataString;
	@Column(name="METER_SERIAL_NO")
	private String meterSlno;
	@Column(name="D4_TIME_STAMP")
	private String d4timeStamp;
	@Column(name="LOG_TIME_STAMP")
	private String logTimeStamp;
	public Long getAppId() {
		return appId;
	}
	public void setAppId(Long appId) {
		this.appId = appId;
	}
	
	
	public String getCdfid() {
		return cdfid;
	}
	public void setCdfid(String cdfid) {
		this.cdfid = cdfid;
	}
	public String getD4date() {
		return d4date;
	}
	public void setD4date(String d4date) {
		this.d4date = d4date;
	}
	public double getTimeDelay() {
		return timeDelay;
	}
	public void setTimeDelay(double timeDelay) {
		this.timeDelay = timeDelay;
	}
	public String getDataString() {
		return dataString;
	}
	public void setDataString(String dataString) {
		this.dataString = dataString;
	}
	public String getMeterSlno() {
		return meterSlno;
	}
	
	public void setMeterSlno(String meterSlno) {
		this.meterSlno = meterSlno;
	}
	public String getD4timeStamp() {
		return d4timeStamp;
	}
	public void setD4timeStamp(String d4timeStamp) {
		this.d4timeStamp = d4timeStamp;
	}
	public String getLogTimeStamp() {
		return logTimeStamp;
	}
	public void setLogTimeStamp(String logTimeStamp) {
		this.logTimeStamp = logTimeStamp;
	}
	
	
	
	
	
}
