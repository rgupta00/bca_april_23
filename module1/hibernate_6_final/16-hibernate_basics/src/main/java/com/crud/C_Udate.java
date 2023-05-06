package com.crud;

import java.math.BigDecimal;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.factory.SessionFactoryUtil;

public class C_Udate {

	public static void main(String[] args) {
		
		SessionFactory factory=SessionFactoryUtil.getSessionFactory();
		
		Session session=factory.openSession();
		
		Transaction tx=session.getTransaction();
		
		try {
			tx.begin();
			
			Product product=session.get(Product.class, 1);
			product.setPrice(new BigDecimal(92000));
			
			session.merge(product);
			
			tx.commit();
		}catch(HibernateException ex) {
			tx.rollback();
		}
		
		
		session.close();
		factory.close();
	}

}






















