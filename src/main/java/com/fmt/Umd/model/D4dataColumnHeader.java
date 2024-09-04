package com.fmt.Umd.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="d4_columns_header")
public class D4dataColumnHeader {
	@Id
    @Column(name="id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(name="METER_SERIAL_NO")
     private String msn;
	@Column(name="LOAD_COLUMNS_HEADER")
	private String lch;
	public String getMsn() {
		return msn;
	}
	public void setMsn(String msn) {
		this.msn = msn;
	}
	public String getLch() {
		return lch;
	}
	public void setLch(String lch) {
		this.lch = lch;
	}
	
	
}
