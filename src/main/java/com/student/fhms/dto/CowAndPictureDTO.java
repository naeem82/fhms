package com.student.fhms.dto;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.student.fhms.entity.Cow;
import com.student.fhms.entity.CowPicture;
import com.student.fhms.utility.CustomeMultipartFile;

public class CowAndPictureDTO {

	private int id;
	private String cowTagNo;
	private String cowType;
	private String color;
	private int age;
	private String gender;
	
	private String dob;
	private int picId;
	private MultipartFile file;
	private String fileName;
	private byte [] contents;
	private String base64ImageFile;
	private String description;
	public String getBase64ImageFiel() {
		return base64ImageFile;
	}

	public String getDob() {
		
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getBase64ImageFile() {
		return base64ImageFile;
	}

	public void setBase64ImageFile(String base64ImageFile) {
		this.base64ImageFile = base64ImageFile;
	}

	

	public String getCowType() {
		return cowType;
	}

	public void setCowType(String cowType) {
		this.cowType = cowType;
	}

	public CowAndPictureDTO() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCowTagNo() {
		return cowTagNo;
	}

	public void setCowTagNo(String cowTagNo) {
		this.cowTagNo = cowTagNo;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
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
	

	public int getPicId() {
		return picId;
	}

	public void setPicId(int picId) {
		this.picId = picId;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public byte[] getContents() {
		return contents;
	}

	public void setContents(byte[] contents) {
		this.contents = contents;
	}

	public Cow getCow() {
		Date theDob = null;
		try {
			 DateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
			theDob = formatter.parse(dob);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Cow cow = new Cow(id,cowTagNo,cowType, color, age, gender, theDob);
		return cow;

	}

	public CowPicture getCowPicture() {
		CowPicture cowPicture = new CowPicture();
		cowPicture.setId(picId);
		cowPicture.setFileName(file.getOriginalFilename());
		System.out.println("---------------- getCowPicture()--------------pic Name :"+file.getOriginalFilename());
		System.out.println("---------------- getCowPicture()----------fileSize :"+file.getSize());
		cowPicture.setDescription(description);
		try {
			cowPicture.setImage(file.getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return cowPicture;
	}

	public void fillDTO(Cow cow){
		
		if(cow!=null){
			System.out.println(cow);
			List<CowPicture>  list=cow.getCowPictures();
			CowPicture picture=list.get(0);
			
			 setId(cow.getId());
			  setCowTagNo(cow.getCowTagNo());
			  setCowType(cow.getCowType());
			 setColor(cow.getColor());
			setAge(cow.getAge());
			  setGender(cow.getGender());
			  System.out.println(" Data in Data Base :"+cow.getDob().toString());
			 setDob(cow.getDob().toString());
			 // setBirthDate(new SimpleDateFormat("dd/mm/yyyy").format(cow.getDob()));
			 if(picture!=null){
			 setPicId(picture.getId());
				 System.out.println("--------------------filldto----------Picture File Name:"+picture.getFileName());
			 setFileName(picture.getFileName());
			 setBase64ImageFile(picture.getBase64imageFile());
			  setDescription(picture.getDescription());
			  MultipartFile f=new CustomeMultipartFile(picture.getImage(), picture.getFileName());
			  System.out.println("--------------------filldto----------converted Multipart File:"+f.getSize());
			  setFile(f);
			 }
			
			
		}
		
	}

}
