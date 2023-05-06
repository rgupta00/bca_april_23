package com.bankapp.hello;

import com.bankapp.factory.SessionFactoryUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.math.BigDecimal;

public class A_Insert {
    public static void main(String[] args) {


        //1. sessionfactroy
        SessionFactory sessionFactory=SessionFactoryUtil.getSessionFactory();

        //2. session
        Session session=sessionFactory.openSession();//openSession vs getCurrentSession
        //3. start the tx

        Transaction tx=session.getTransaction();
        try{
            tx.begin();
            Account account=new Account("pooja",new BigDecimal(1000));
            Account account2=new Account("sunita",new BigDecimal(1000));
            session.persist(account);
            session.persist(account2);
            //5. commit
            tx.commit();
        }catch (HibernateException ex){
            //4. rollback
            tx.rollback();
        }

        session.close();
        sessionFactory.close();
        //close the session

        //close the sf


    }
}
















