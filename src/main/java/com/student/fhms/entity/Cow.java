package com.student.fhms.entity;

import java.util.Date;

import javax.persistence.Entity;

@Entity
public class Cow {
	private int id;
	private String color;
	private int age;
	private String gender;
	private Date dob;
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
	
	

}
