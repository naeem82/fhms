package com.student.fhms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.student.fhms.dao.CowDAO;
import com.student.fhms.entity.Cow;
@Service("cowService")
public class CowServiceImpl implements CowService {
	@Autowired
	private CowDAO cowDAO;
	@Override
	public List<Cow> getCows() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cow getCow(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public void saveCow(Cow cow) {
		cowDAO.saveCow(cow);

	}

	@Override
	public void deleteCow() {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Cow> searchCow(String theSearchName) {
		// TODO Auto-generated method stub
		return null;
	}

}
