package com.student.fhms.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.student.fhms.entity.Customer;
@Repository
public class CustomerDAOImpl implements CustomerDAO {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Customer> getCustomers() {
		Session session=sessionFactory.getCurrentSession();
		Query<Customer> query=session.createQuery("from Customer",Customer.class);
		List<Customer> customers=query.getResultList();
		return customers;
	}

	@Override
	public Customer getCustomer(int id) {
		Session session=sessionFactory.getCurrentSession();
		Customer customer=session.get(Customer.class, id);
		return customer;
	}

	@Override
	public void saveCustomer(Customer customer) {
		Session session=sessionFactory.getCurrentSession();
		session.saveOrUpdate(customer);

	}

	@Override
	public void deleteCustomer(int id) {
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("delete from Customer where id=:theId");
		query.setParameter("theId", id);
		query.executeUpdate();
	}

	@Override
	public List<Customer> searchCustomer(String theSearchName) {
		Session session=sessionFactory.getCurrentSession();
		Query theQuery=null;
		if((theSearchName!=null) && (theSearchName.trim().length()>0) ){
			theQuery=session.createQuery(
					 "from Customer where firstName like:theName and lastName like:theName",Customer.class);
			theQuery.setParameter("theName","%"+ theSearchName+"%");
		}else
		{
			theQuery=session.createQuery("from Customer",Customer.class);
		}
		
		List<Customer> customers=theQuery.getResultList();
		return customers;
	}

}
