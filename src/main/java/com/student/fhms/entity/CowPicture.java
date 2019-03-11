package com.student.fhms.entity;



import java.io.UnsupportedEncodingException;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.commons.codec.binary.Base64;
@Entity
@Table(name="cow_picture")
public class CowPicture {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="file_name")
	private String fileName;
	@Column(name="file_path")
	private String filePath;
	@Lob  
	@Basic(fetch=FetchType.LAZY)  //optional
	@Column(name="image",nullable=false)
	private byte[] image;
	@Column(name="description")
	private String description;
	@Transient
	private String base64imageFile;
	

	public String getBase64imageFile() {
		byte[] encodeBase64 = Base64.encodeBase64(getImage());
		String base64Encoded=null;
		try {
			base64Encoded = new String(encodeBase64, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			// 
			e.printStackTrace();
		}
		
		return base64Encoded;
		//return base64imageFile;
	}

	public void setBase64imageFile(String base64imageFile) {
		this.base64imageFile = base64imageFile;
	}

	public CowPicture() {

	}

	public CowPicture(byte[] image, String description,String fileName) {
		this.image = image;
		this.description = description;
		this.fileName=fileName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	

//	public String getBase64Encoded() {
//		byte[] encodeBase64 = Base64.encodeBase64(getImage());
//		String base64Encoded=null;
//		try {
//			base64Encoded = new String(encodeBase64, "UTF-8");
//		} catch (UnsupportedEncodingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		return base64Encoded;
//	}

	@Override
	public String toString() {
		return "CowPictures [id=" + id + ", description=" + description + "]";
	}

}
