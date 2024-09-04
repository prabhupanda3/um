package com.fmt.Umd.Dto;

import java.util.List;

import com.fmt.Umd.model.LoadServey;



public class FileDto {
 
	private String fileName;
	private List<LoadServey> data;
	
	public FileDto() {
		super();
	}

	public FileDto(String fileName, List<LoadServey> data) {
		super();
		this.fileName = fileName;
		this.data = data;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public List<LoadServey> getData() {
		return data;
	}

	public void setData(List<LoadServey> data) {
		this.data = data;
	}
	
	

}
