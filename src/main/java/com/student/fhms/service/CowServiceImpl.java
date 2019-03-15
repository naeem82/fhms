package com.student.fhms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.student.fhms.dao.CowDAO;
import com.student.fhms.entity.Cow;
@Service
public class CowServiceImpl implements CowService {
	@Autowired
	private CowDAO cowDAO;
	@Override
	@Transactional
	public List<Cow> getCows() {
		return cowDAO.getCows();
	}

	@Override
	@Transactional
	public Cow getCow(int id) {
		return cowDAO.getCow(id);
	}

	@Override
	@Transactional
	public void saveCow(Cow cow) {
		cowDAO.saveCow(cow);

	}

	@Override
	@Transactional
	public void deleteCow(int id) {
		cowDAO.deleteCow(id);

	}

	@Override
	@Transactional
	public List<Cow> searchCow(String theSearchName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public List<Cow> getPurchasedCows() {
		
		return cowDAO.getPurchasedCows();
	}

	@Override
	@Transactional
	public List<Cow> getSaleableCows() {
		
		return cowDAO.getSaleableCows();
	}

	@Override
	@Transactional
	public List<Cow> getPurchasedButNotSoldCows() {
		
		return cowDAO.getPurchasedButNotSoldCows();
	}

}
