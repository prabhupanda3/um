package com.fmt.Umd.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "device_diagnosis_summary")
public class DeviceDiagnosisSummary {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    @Column(name = "meter_serial_no", length = 45, nullable = false,unique = true)
	    private String meterSerialNo;

	    @Column(name = "modem_serial_no", length = 45)
	    private String modemSerialNo;

	    @Column(name = "diag_timestamp", length = 60)
	    private String diagTimestamp;

	    @Column(name = "fv", length = 90)
	    private String fv;

	    @Column(name = "battery", length = 180)
	    private String battery;

	    @Column(name = "gsm_signal", length = 180)
	    private String gsmSignal;

	    @Column(name = "signal_quality_error", length = 9)
	    private String signalQualityError;

	    @Column(name = "temperature", length = 18)
	    private String temperature;

	    @Column(name = "simno", length = 69)
	    private String simNo;

	    @Column(name = "imeino", length = 60)
	    private String imeiNo;

	    @Column(name = "cablestatus", length = 6)
	    private String cableStatus;

	    @Column(name = "ipaddress", length = 60)
	    private String ipAddress;

	    @Column(name = "readtime", length = 36)
	    private String readTime;

	    @Column(name = "transmittime", length = 36)
	    private String transmitTime;

	    @Column(name = "metermake", length = 45)
	    private String meterMake;

	    @Column(name = "ftp_conf_status", length = 6)
	    private String ftpConfStatus;

	    @Column(name = "pota_status", length = 6)
	    private String potaStatus;

	    @Column(name = "log_timestamp")
	    private java.sql.Timestamp logTimestamp;

		public DeviceDiagnosisSummary(Long id, String meterSerialNo, String modemSerialNo, String diagTimestamp,
				String fv, String battery, String gsmSignal, String signalQualityError, String temperature,
				String simNo, String imeiNo, String cableStatus, String ipAddress, String readTime, String transmitTime,
				String meterMake, String ftpConfStatus, String potaStatus, Timestamp logTimestamp) {
			super();
			this.id = id;
			this.meterSerialNo = meterSerialNo;
			this.modemSerialNo = modemSerialNo;
			this.diagTimestamp = diagTimestamp;
			this.fv = fv;
			this.battery = battery;
			this.gsmSignal = gsmSignal;
			this.signalQualityError = signalQualityError;
			this.temperature = temperature;
			this.simNo = simNo;
			this.imeiNo = imeiNo;
			this.cableStatus = cableStatus;
			this.ipAddress = ipAddress;
			this.readTime = readTime;
			this.transmitTime = transmitTime;
			this.meterMake = meterMake;
			this.ftpConfStatus = ftpConfStatus;
			this.potaStatus = potaStatus;
			this.logTimestamp = logTimestamp;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getMeterSerialNo() {
			return meterSerialNo;
		}

		public void setMeterSerialNo(String meterSerialNo) {
			this.meterSerialNo = meterSerialNo;
		}

		public String getModemSerialNo() {
			return modemSerialNo;
		}

		public void setModemSerialNo(String modemSerialNo) {
			this.modemSerialNo = modemSerialNo;
		}

		public String getDiagTimestamp() {
			return diagTimestamp;
		}

		public void setDiagTimestamp(String diagTimestamp) {
			this.diagTimestamp = diagTimestamp;
		}

		public String getFv() {
			return fv;
		}

		public void setFv(String fv) {
			this.fv = fv;
		}

		public String getBattery() {
			return battery;
		}

		public void setBattery(String battery) {
			this.battery = battery;
		}

		public String getGsmSignal() {
			return gsmSignal;
		}

		public void setGsmSignal(String gsmSignal) {
			this.gsmSignal = gsmSignal;
		}

		public String getSignalQualityError() {
			return signalQualityError;
		}

		public void setSignalQualityError(String signalQualityError) {
			this.signalQualityError = signalQualityError;
		}

		public String getTemperature() {
			return temperature;
		}

		public void setTemperature(String temperature) {
			this.temperature = temperature;
		}

		public String getSimNo() {
			return simNo;
		}

		public void setSimNo(String simNo) {
			this.simNo = simNo;
		}

		public String getImeiNo() {
			return imeiNo;
		}

		public void setImeiNo(String imeiNo) {
			this.imeiNo = imeiNo;
		}

		public String getCableStatus() {
			return cableStatus;
		}

		public void setCableStatus(String cableStatus) {
			this.cableStatus = cableStatus;
		}

		public String getIpAddress() {
			return ipAddress;
		}

		public void setIpAddress(String ipAddress) {
			this.ipAddress = ipAddress;
		}

		public String getReadTime() {
			return readTime;
		}

		public void setReadTime(String readTime) {
			this.readTime = readTime;
		}

		public String getTransmitTime() {
			return transmitTime;
		}

		public void setTransmitTime(String transmitTime) {
			this.transmitTime = transmitTime;
		}

		public String getMeterMake() {
			return meterMake;
		}

		public void setMeterMake(String meterMake) {
			this.meterMake = meterMake;
		}

		public String getFtpConfStatus() {
			return ftpConfStatus;
		}

		public void setFtpConfStatus(String ftpConfStatus) {
			this.ftpConfStatus = ftpConfStatus;
		}

		public String getPotaStatus() {
			return potaStatus;
		}

		public void setPotaStatus(String potaStatus) {
			this.potaStatus = potaStatus;
		}

		public java.sql.Timestamp getLogTimestamp() {
			return logTimestamp;
		}

		public void setLogTimestamp(java.sql.Timestamp logTimestamp) {
			this.logTimestamp = logTimestamp;
		}
	
	    
	    
	    

	
	
}
