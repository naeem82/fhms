package com.student.fhms.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

@Entity
@Table(name="cow")
public class Cow {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="color")
	private String color;
	@Column(name="age")
	private int age;
	@Column(name="gender")
	private String gender;
	@Column(name="dob")
	private Date dob;
	@OneToMany(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinColumn(name="cow_id")
	private List<CowPictures> cowPictures;
	public Cow() {
		
	}
	public Cow(String color, int age, String gender, Date dob) {
		
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
	
	public void add(CowPictures cowPicture){
		if(cowPictures==null){
			cowPictures=new ArrayList<>();
		}
		cowPictures.add(cowPicture);
	}
	public List<CowPictures> getCowPictures() {
		return cowPictures;
	}
	public void setCowPictures(List<CowPictures> cowPictures) {
		this.cowPictures = cowPictures;
	}
	
	

}
