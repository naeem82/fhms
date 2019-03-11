package com.student.fhms.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.student.fhms.entity.CowPicture;
@Repository
public class CowPictureDAOImpl implements CowPictureDAO {
	@Autowired
	private SessionFactory sessionFactory;
	@Override
	public List<CowPicture> getCowPictures() {
		Session session=sessionFactory.getCurrentSession();
		Query<CowPicture> query=session.createQuery("from CowPicture",CowPicture.class);
		List<CowPicture> cowPictures=query.getResultList();
		return cowPictures;
	}

	@Override
	public CowPicture getCowPicture(int id) {
		Session session=sessionFactory.getCurrentSession();
		CowPicture cowPicture=session.get(CowPicture.class, id);
		return cowPicture;
	}

	@Override
	public void saveCowPicture(CowPicture cowPicture) {
		Session session=sessionFactory.getCurrentSession();
		session.saveOrUpdate(cowPicture);
	}

	@Override
	public void deleteCowPicture(int id) {
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("delete from CowPicture where id =:theId");
		query.setParameter("theId", id);
		query.executeUpdate();
	}

	@Override
	public List<CowPicture> searchCowPicture(String theSearchName) {
		// TODO Auto-generated method stub
		return null;
	}

}
