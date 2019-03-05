package com.student.fhms.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.student.fhms.entity.Cow;

@Repository("cowDAO")
public class CowDAOImpl implements CowDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

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
	public void saveCow(Cow cow) {
		Session session=sessionFactory.getCurrentSession();
		session.saveOrUpdate(cow);

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
