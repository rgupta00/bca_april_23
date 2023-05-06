package com.bankapp.hello;

import com.bankapp.factory.HibernateSessionFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.math.BigDecimal;

public class Demo {
    public static void main(String[] args) {
        SessionFactory sessionFactory= HibernateSessionFactory.getSessionFactory();

        Session session= sessionFactory.openSession();
        session.getTransaction().begin();

        Account account=new Account("raj",new BigDecimal(1000));
        session.persist(account);
        session.getTransaction().commit();

        session.close();
        sessionFactory.close();
    }
}
