package com.crud;

import java.math.BigDecimal;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.factory.SessionFactoryUtil;

public class A_Insert {

	public static void main(String[] args) {
		
		SessionFactory factory=SessionFactoryUtil.getSessionFactory();
		
		Session session=factory.openSession();
		
		Transaction tx=session.getTransaction();
		
		try {
			tx.begin();
			
			Product product=new Product("laptop", new BigDecimal(91000));
			Product product2=new Product("mouse", new BigDecimal(1200));
			
			session.save(product);
			session.save(product2);
			
			tx.commit();
		}catch(HibernateException ex) {
			tx.rollback();
		}
		
		
		session.close();
		factory.close();
	}

}






















