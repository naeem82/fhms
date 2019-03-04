package com.student.fhms.entity;

import javax.persistence.Column;

public class CowPictures {
	private int id;
	// @Column(name="cow_image",nullable=false,columnDefinition="mediumblob")
	private byte[] image;
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
