package com.fmt.Umd.Dashboard.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="daysummary")
public class Daysummary {
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private Integer slno;
	@Column(name="discom")
	private String discom;
	@Column(name="circle")
	private String circle;
	@Column(name="division")
	private String division;
	@Column(name="sdo")
	private String sdo;
	@Column(name="comm_date")
	private String comm_date;
	@Column(name="comm")
	private String comm;
	@Column(name="notcomm")
	private String notcomm;
	@Column(name="nevcomm")
	private String nevcomm;
	@Column(name="poweroff")
	private String poweroff;
	@Column(name="mcf")
	private String mcf;
	@Column(name="log_timestamp")
	private String log_timestamp;
	@Column(name="loadprofile")
	private String loadprofile;
	public Daysummary() {
		super();
	}
	public Daysummary(Integer slno, String discom, String circle, String division, String sdo, String comm_date,
			String comm, String notcomm, String nevcomm, String poweroff, String mcf, String log_timestamp,
			String loadprofile) {
		super();
		this.slno = slno;
		this.discom = discom;
		this.circle = circle;
		this.division = division;
		this.sdo = sdo;
		this.comm_date = comm_date;
		this.comm = comm;
		this.notcomm = notcomm;
		this.nevcomm = nevcomm;
		this.poweroff = poweroff;
		this.mcf = mcf;
		this.log_timestamp = log_timestamp;
		this.loadprofile = loadprofile;
	}
	public Integer getSlno() {
		return slno;
	}
	public void setSlno(Integer slno) {
		this.slno = slno;
	}
	public String getDiscom() {
		return discom;
	}
	public void setDiscom(String discom) {
		this.discom = discom;
	}
	public String getCircle() {
		return circle;
	}
	public void setCircle(String circle) {
		this.circle = circle;
	}
	public String getDivision() {
		return division;
	}
	public void setDivision(String division) {
		this.division = division;
	}
	public String getSdo() {
		return sdo;
	}
	public void setSdo(String sdo) {
		this.sdo = sdo;
	}
	public String getComm_date() {
		return comm_date;
	}
	public void setComm_date(String comm_date) {
		this.comm_date = comm_date;
	}
	public String getComm() {
		return comm;
	}
	public void setComm(String comm) {
		this.comm = comm;
	}
	public String getNotcomm() {
		return notcomm;
	}
	public void setNotcomm(String notcomm) {
		this.notcomm = notcomm;
	}
	public String getNevcomm() {
		return nevcomm;
	}
	public void setNevcomm(String nevcomm) {
		this.nevcomm = nevcomm;
	}
	public String getPoweroff() {
		return poweroff;
	}
	public void setPoweroff(String poweroff) {
		this.poweroff = poweroff;
	}
	public String getMcf() {
		return mcf;
	}
	public void setMcf(String mcf) {
		this.mcf = mcf;
	}
	public String getLog_timestamp() {
		return log_timestamp;
	}
	public void setLog_timestamp(String log_timestamp) {
		this.log_timestamp = log_timestamp;
	}
	public String getLoadprofile() {
		return loadprofile;
	}
	public void setLoadprofile(String loadprofile) {
		this.loadprofile = loadprofile;
	}
	

}
