package com.student.fhms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="cow_pictures")
public class CowPictures {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="cow_image",nullable=false,columnDefinition="mediumblob")
	private byte[] image;
	@Column(name="description")
	private String description;

	public CowPictures() {

	}

	public CowPictures(byte[] image, String description) {
		this.image = image;
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	@Override
	public String toString() {
		return "CowPictures [id=" + id + ", description=" + description + "]";
	}

}
