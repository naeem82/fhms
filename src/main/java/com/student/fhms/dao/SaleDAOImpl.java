package com.student.fhms.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.student.fhms.entity.Sale;

@Repository
public class SaleDAOImpl implements SaleDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Sale> getSales() {
		Session session=sessionFactory.getCurrentSession();
		Query<Sale> query=session.createQuery("from Sale",Sale.class);
		List<Sale> sales=query.getResultList();
		return sales;
	}

	@Override
	public Sale getSale(int id) {
		Session session=sessionFactory.getCurrentSession();
		Sale sale=session.get(Sale.class, id);
		return sale;
	}

	@Override
	public void saveSale(Sale sale) {
		Session session=sessionFactory.getCurrentSession();
		session.saveOrUpdate(sale);

	}

	@Override
	public void deleteSale(int id) {
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("delete from Sale where id=:theId");
		query.setParameter("theId", id);
		query.executeUpdate();

	}

	@Override
	public List<Sale> searchSale(String theSearchName) {
		// TODO Auto-generated method stub
		return null;
	}

}
