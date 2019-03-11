package com.student.fhms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.student.fhms.dao.CowPictureDAO;
import com.student.fhms.entity.CowPicture;

@Service
@Transactional
public class CowPictureServiceImpl implements CowPictureService {
	
	@Autowired
	private CowPictureDAO cowPictureDAO;
	@Override
	public List<CowPicture> getCowPictures() {
		
		return cowPictureDAO.getCowPictures();
	}

	@Override
	public CowPicture getCowPicture(int id) {
		
		return cowPictureDAO.getCowPicture(id);
	}

	@Override
	public void saveCowPicture(CowPicture cowPicture) {
		
		cowPictureDAO.saveCowPicture(cowPicture);

	}

	@Override
	public void deleteCowPicture(int id) {
		
		cowPictureDAO.deleteCowPicture(id);

	}

	@Override
	public List<CowPicture> searchCowPicture(String theSearchName) {
		
		return cowPictureDAO.searchCowPicture(theSearchName);
	}

}
