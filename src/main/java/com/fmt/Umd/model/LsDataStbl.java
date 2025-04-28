package com.fmt.Umd.model;



import java.sql.Timestamp;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="ls_data_stbl")
@Entity
public class LsDataStbl {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="recordid")
    private Integer recordid;
	@Column(name="cdfid")
    private String cdfid;
	@Column(name="d4_date")
	private String d4_date;
	@Column(name="time_delay")
	private int time_delay;
	@Column(name = "D4_TIME_STAMP",columnDefinition = "TIMESTAMP(6)")
    private LocalDateTime D4_TIME_STAMP;
	@Column(name="vr") 
	private double vr;         
	@Column(name="vy")
	private double vy;         
	@Column(name="vb")
	private double vb;         
	@Column(name="lr")
	private double lr;         
	@Column(name="ly")
	private double ly;         
	@Column(name="lb")
	private double lb;         
	@Column(name="kwh_e")
	private double kwh_e;      
	@Column(name="kwh_i")
	private double kwh_i;      
	@Column(name="kvah_e")
	private double kvah_e;     
	@Column(name="kvah_i")
	private double kvah_i;     
	@Column(name="kvarh_lag")
	private double kvarh_lag;  
	@Column(name="kvarh_lead")
	private double kvarh_lead; 
	@Column(name="voltage_avg")
	private double voltage_avg;
	@Column(name="current_avg")
	private double current_avg;
	@Column(name="log_timestamp")
    private Timestamp log_timestamp;
	@Column(name="phase_supply")
	private String phase_supply;
	@Column(name="energy_utilised")
	private String energy_utilised;
	@Column(name="energy_saved")
	private String energy_saved;
	public Integer getRecordid() {
		return recordid;
	}
	public void setRecordid(Integer recordid) {
		this.recordid = recordid;
	}
	public String getCdfid() {
		return cdfid;
	}
	public void setCdfid(String cdfid) {
		this.cdfid = cdfid;
	}
	public String getD4_date() {
		return d4_date;
	}
	public void setD4_date(String d4_date) {
		this.d4_date = d4_date;
	}
	public int getTime_delay() {
		return time_delay;
	}
	public void setTime_delay(int time_delay) {
		this.time_delay = time_delay;
	}
	
	
	
	
	
	public LocalDateTime getD4_TIME_STAMP() {
		return D4_TIME_STAMP;
	}
	public void setD4_TIME_STAMP(LocalDateTime d4_TIME_STAMP) {
		D4_TIME_STAMP = d4_TIME_STAMP;
	}
	public double getVr() {
		return vr;
	}
	public void setVr(double vr) {
		this.vr = vr;
	}
	public double getVy() {
		return vy;
	}
	public void setVy(double vy) {
		this.vy = vy;
	}
	public double getVb() {
		return vb;
	}
	public void setVb(double vb) {
		this.vb = vb;
	}
	public double getLr() {
		return lr;
	}
	public void setLr(double lr) {
		this.lr = lr;
	}
	public double getLy() {
		return ly;
	}
	public void setLy(double ly) {
		this.ly = ly;
	}
	public double getLb() {
		return lb;
	}
	public void setLb(double lb) {
		this.lb = lb;
	}
	public double getKwh_e() {
		return kwh_e;
	}
	public void setKwh_e(double kwh_e) {
		this.kwh_e = kwh_e;
	}
	public double getKwh_i() {
		return kwh_i;
	}
	public void setKwh_i(double kwh_i) {
		this.kwh_i = kwh_i;
	}
	public double getKvah_e() {
		return kvah_e;
	}
	public void setKvah_e(double kvah_e) {
		this.kvah_e = kvah_e;
	}
	public double getKvah_i() {
		return kvah_i;
	}
	public void setKvah_i(double kvah_i) {
		this.kvah_i = kvah_i;
	}
	public double getKvarh_lag() {
		return kvarh_lag;
	}
	public void setKvarh_lag(double kvarh_lag) {
		this.kvarh_lag = kvarh_lag;
	}
	public double getKvarh_lead() {
		return kvarh_lead;
	}
	public void setKvarh_lead(double kvarh_lead) {
		this.kvarh_lead = kvarh_lead;
	}
	public double getVoltage_avg() {
		return voltage_avg;
	}
	public void setVoltage_avg(double voltage_avg) {
		this.voltage_avg = voltage_avg;
	}
	public double getCurrent_avg() {
		return current_avg;
	}
	public void setCurrent_avg(double current_avg) {
		this.current_avg = current_avg;
	}
	public Timestamp getLog_timestamp() {
		return log_timestamp;
	}
	public void setLog_timestamp(Timestamp log_timestamp) {
		this.log_timestamp = log_timestamp;
	}
	public String getPhase_supply() {
		return phase_supply;
	}
	public void setPhase_supply(String phase_supply) {
		this.phase_supply = phase_supply;
	}
	public String getEnergy_utilised() {
		return energy_utilised;
	}
	public void setEnergy_utilised(String energy_utilised) {
		this.energy_utilised = energy_utilised;
	}
	public String getEnergy_saved() {
		return energy_saved;
	}
	public void setEnergy_saved(String energy_saved) {
		this.energy_saved = energy_saved;
	}
	
	
	
}
