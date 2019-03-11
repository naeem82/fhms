package com.student.fhms.dao;

import java.util.List;

import com.student.fhms.entity.Cow;
import com.student.fhms.entity.CowPicture;

public interface CowPictureDAO {
	public List<CowPicture> getCowPictures();
	public CowPicture getCowPicture(int id);
	public void saveCowPicture(CowPicture cowPicture);
	public void deleteCowPicture(int id);
	public List<CowPicture> searchCowPicture(String theSearchName);

}
