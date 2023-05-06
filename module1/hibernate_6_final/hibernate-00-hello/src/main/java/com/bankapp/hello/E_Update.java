package com.bankapp.hello;

import com.bankapp.factory.SessionFactoryUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.math.BigDecimal;

public class E_Update {
    public static void main(String[] args) {


        //1. sessionfactroy
        SessionFactory sessionFactory=SessionFactoryUtil.getSessionFactory();

        //2. session
        Session session=sessionFactory.openSession();//openSession vs getCurrentSession
        //3. start the tx

        Transaction tx=session.getTransaction();
        try{
            tx.begin();
              //get the record if found udpate the name
                Account account=session.get(Account.class, 3);
                account.setName("ravi");

                session.merge(account);

              //then update vs merge (better) Why?

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
















