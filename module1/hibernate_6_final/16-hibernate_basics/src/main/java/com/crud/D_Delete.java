package com.crud;

import java.math.BigDecimal;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.factory.SessionFactoryUtil;

public class D_Delete {

	public static void main(String[] args) {
		
		SessionFactory factory=SessionFactoryUtil.getSessionFactory();
		
		Session session=factory.openSession();
		
		Transaction tx=session.getTransaction();
		
		try {
			tx.begin();
			
			Product product=session.get(Product.class, 1);
			session.delete(product);
			
			tx.commit();
		}catch(HibernateException ex) {
			tx.rollback();
		}
		
		
		session.close();
		factory.close();
	}

}






















