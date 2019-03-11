package com.student.fhms.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="cow")
public class Cow {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="cow_tag_no")
	private String cowTagNo;
	@Column(name="color")
	private String color;
	@Column(name="age")
	private int age;
	@Column(name="gender")
	private String gender;
	
	
	@Temporal(TemporalType.DATE)
	@Column(name="dob")
	private Date dob;
	@OneToMany(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinColumn(name="cow_id")
	private List<CowPicture> cowPictures;
	public Cow(){
		
	}
	public Cow(int id,String cowTagNo,String color, int age, String gender, Date dob) {
		this.id=id;
		this.cowTagNo=cowTagNo;
		this.color = color;
		this.age = age;
		this.gender = gender;
		this.dob = dob;
	}
	public Cow(String cowTagNo,String color, int age, String gender, Date dob) {
		this.cowTagNo=cowTagNo;
		this.color = color;
		this.age = age;
		this.gender = gender;
		this.dob = dob;
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
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	@Override
	public String toString() {
		return "Cow [id=" + id + ", color=" + color + ", age=" + age + ", gender=" + gender + ", dob=" + dob + "]";
	}
	
	public void add(CowPicture cowPicture){
		if(cowPictures==null){
			cowPictures=new ArrayList<>();
		}
		cowPictures.add(cowPicture);
	}
	public List<CowPicture> getCowPictures() {
		return cowPictures;
	}
	public void setCowPictures(List<CowPicture> cowPictures) {
		this.cowPictures = cowPictures;
	}
	
	

}
