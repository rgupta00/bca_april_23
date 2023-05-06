package com.crud;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.factory.SessionFactoryUtil;

public class E_GetById {

	public static void main(String[] args) {


		SessionFactory factory=SessionFactoryUtil.getSessionFactory();
		
		Session session=factory.openSession();
		
		//read the records
		
		Product product=session.get(Product.class, 10);
		System.out.println(product);
	}

}
