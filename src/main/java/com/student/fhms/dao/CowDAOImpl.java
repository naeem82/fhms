package com.student.fhms.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.student.fhms.entity.Cow;

@Repository
public class CowDAOImpl implements CowDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Cow> getCows() {
		Session session=sessionFactory.getCurrentSession();
		Query<Cow> query=session.createQuery("from  Cow",Cow.class);
		List<Cow> cows=query.getResultList();
		return cows;
	}

	@Override
	public Cow getCow(int id) {
		Session session=sessionFactory.getCurrentSession();
		Cow cow=session.get(Cow.class, id);
		return cow;
	}

	@Override
	public void saveCow(Cow cow) {
		Session session=sessionFactory.getCurrentSession();
		session.saveOrUpdate(cow);

	}

	@Override
	public void deleteCow(int id) {
		Session session=sessionFactory.getCurrentSession();
		//Cow cow=new Cow();
		//cow.setId(id);  // it weill take more time first it update the db and then delete object
		//session.delete(cow);// we will use hibernate query Language becoz it is more efficient
		Query query=session.createQuery("delete from Cow where id=:theId");
		query.setParameter("theId", id);
		query.executeUpdate();
		

	}

	@Override
	public List<Cow> searchCow(String theSearchName) {
		// TODO Auto-generated method stub
		return null;
	}

}
