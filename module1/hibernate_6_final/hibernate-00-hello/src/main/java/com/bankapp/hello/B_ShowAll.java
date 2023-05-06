package com.bankapp.hello;

import com.bankapp.factory.SessionFactoryUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.math.BigDecimal;
import java.util.List;

public class B_ShowAll {
    public static void main(String[] args) {


        //1. sessionfactroy
        SessionFactory sessionFactory=SessionFactoryUtil.getSessionFactory();

        //2. session
        Session session=sessionFactory.openSession();//openSession vs getCurrentSession
        //3. start the tx


        //we want to show all tuples : tx ? Y/N

        List<Account> accounts=session
                .createQuery("select a from Account a", Account.class)
                .getResultList();
        System.out.println("----------------");
        accounts.forEach(a-> System.out.println(a));

        //close the session
        session.close();
        //close the sf
        sessionFactory.close();







    }
}
















