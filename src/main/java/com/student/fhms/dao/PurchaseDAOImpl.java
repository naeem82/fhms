package com.student.fhms.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.student.fhms.entity.Cow;
import com.student.fhms.entity.Purchase;

@Repository
public class PurchaseDAOImpl implements PurchaseDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Purchase> getPurchases() {
		Session session=sessionFactory.getCurrentSession();
		Query<Purchase> query=session.createQuery("from Purchase",Purchase.class);
		List<Purchase> purchases=query.getResultList();
		return purchases;
	}
	

	@Override
	public Purchase getPurchase(int id) {
		Session session=sessionFactory.getCurrentSession();
		Purchase purchase=session.get(Purchase.class, id);
		return purchase;
	}

	@Override
	public void savePurchase(Purchase purchase) {
		Session session=sessionFactory.getCurrentSession();
		session.saveOrUpdate(purchase);

	}

	@Override
	public void deletePurchase(int id) {
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("delete from Purchase where id=:theId");
		query.setParameter("theId", id);
		query.executeUpdate();

	}

	@Override
	public List<Purchase> searchPurchase(String theSearchName) {
		// TODO Auto-generated method stub
		return null;
	}
	public List<Purchase> getPurchaseInformationCowsThatAreNotSold(){
		Session session=sessionFactory.getCurrentSession();
		String query="select p.id,p.purchase_date,p.description,p.price,p.customer_id "+
					 "from purchase p ,cow c "+
					 "where p.id=c.purchase_id "+
					 "and c.sale_id is null";
		List<Purchase> purchases = session.createNativeQuery(query, Purchase.class).list();
		return purchases;
	}
}
