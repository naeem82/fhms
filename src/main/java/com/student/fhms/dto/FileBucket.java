package com.student.fhms.dto;

import org.springframework.web.multipart.MultipartFile;

public class FileBucket {
	private MultipartFile file;
	private String description;
	// To add file Picture we need cowId
	private String base64ImageFile;
	private int cowId;
	public FileBucket(){
		
	}
	public MultipartFile getFile() {
		return file;
	}
	public void setFile(MultipartFile file) {
		this.file = file;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getBase64ImageFile() {
		return base64ImageFile;
	}
	public void setBase64ImageFile(String base64ImageFile) {
		this.base64ImageFile = base64ImageFile;
	}
	public int getCowId() {
		return cowId;
	}
	public void setCowId(int cowId) {
		this.cowId = cowId;
	}
	
	

}
