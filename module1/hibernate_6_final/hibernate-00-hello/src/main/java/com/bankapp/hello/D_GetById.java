package com.bankapp.hello;

import com.bankapp.factory.SessionFactoryUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.math.BigDecimal;

public class D_GetById {
    public static void main(String[] args) {


        //1. sessionfactroy
        SessionFactory sessionFactory=SessionFactoryUtil.getSessionFactory();

        //2. session
        Session session=sessionFactory.openSession();//openSession vs getCurrentSession
        //3. start the tx

        Transaction tx=session.getTransaction();

        Account account=session.load(Account.class,3 ); //get vs load


        System.out.println("-----------------------");

        System.out.println(account);

        session.close();

        sessionFactory.close();


        //close the session

        //close the sf


    }
}
















