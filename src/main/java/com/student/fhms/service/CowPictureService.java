package com.student.fhms.service;

import java.util.List;

import com.student.fhms.entity.CowPicture;

public interface CowPictureService {
	public List<CowPicture> getCowPictures();
	public CowPicture getCowPicture(int id);
	public void saveCowPicture(CowPicture cowPicture);
	public void deleteCowPicture(int id);
	public List<CowPicture> searchCowPicture(String theSearchName);
	public List<CowPicture> getPicturesByCowId(int cowId);

}
