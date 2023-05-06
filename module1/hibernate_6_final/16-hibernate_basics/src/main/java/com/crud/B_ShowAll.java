package com.crud;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.factory.SessionFactoryUtil;

public class B_ShowAll {

	public static void main(String[] args) {


		SessionFactory factory=SessionFactoryUtil.getSessionFactory();
		
		Session session=factory.openSession();
		
		//read the records
		
		List<Product> list=session.createQuery("select p from Product p",Product.class).getResultList();

		list.forEach(p-> System.out.println(p));
	}

}
