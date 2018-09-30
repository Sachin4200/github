package com.niit.sportsbackend.dao;



import java.util.List;

import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.niit.sportsbackend.model.Customer;
@Repository
@Transactional

public class CustomerDaoImpl implements CustomerDao {
private SessionFactory sessionFactory;
	public boolean addCustomer(Customer customer) {
		Session session=sessionFactory.getCurrentSession();
		try {
			session.save(customer);
			return true;
		}
		catch(HibernateException e) {
			e.printStackTrace();
	    	return false;	
		}
	}

	public boolean updateCustomer(Customer customer) {
		
		Session session=sessionFactory.getCurrentSession();
		
		try {
			session.update(customer);
			 return true;
		}
		catch(HibernateException e) {
         e.printStackTrace();
		 return false;
	}
	}

	public boolean deleteCustomer(int customerId) {
     Session session=sessionFactory.getCurrentSession();
		
		try {
			session.delete(getCustomerById(customerId));
			return true;
		}
		catch(HibernateException e){
			e.printStackTrace();
		
		return false;
	}
	}

	public List<Customer> getAllCustomer() {

        Session session=sessionFactory.getCurrentSession();
        
        try {
        Query query=session.createQuery("from Customer");
        List<Customer> customerList=(List<Customer>)query.getResultList();
        return customerList;
        }
		catch(HibernateException e) {
			e.printStackTrace();
			return null;
		}

	}

	public Customer getCustomerById(int customerId) {
		Session session=sessionFactory.getCurrentSession();
		try {
			Customer customer=(Customer)session.get(Customer.class, customerId);
			return customer;
		}
		
		catch(HibernateException e) {
		 e.printStackTrace();	
		 return null;
	}

	}

}
