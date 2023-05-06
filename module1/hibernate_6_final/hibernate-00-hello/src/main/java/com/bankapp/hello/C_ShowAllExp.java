package com.bankapp.hello;

import com.bankapp.factory.SessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class C_ShowAllExp {
    public static void main(String[] args) {


        //1. sessionfactroy
        SessionFactory sessionFactory=SessionFactoryUtil.getSessionFactory();

        //2. session
        Session session=sessionFactory.openSession();//openSession vs getCurrentSession
        //3. start the tx


        //we want to show all tuples : tx ? Y/N---->ClassCastException

//        List<String> names=session
//                .createQuery("select a.name,a.balance from Account a", String.class)
//                .getResultList();
//        System.out.println("----------------");
//        names.forEach(n-> System.out.println(n));

        //DTO will create dto to put the data 2 column
//        List<Object[]> names=session
//                .createQuery("select a.name,a.balance from Account a", Object[].class)
//                .getResultList();
//        System.out.println("----------------");
//
//        for(Object[] arr: names){
//            System.out.println(arr[0]+": "+ arr[1]);
//        }

        //HQL
        //Projection operation
        List<AccountDto> AccountDtos=session
                .createQuery("select new com.bankapp.hello.AccountDto(a.name,a.balance) from Account a", AccountDto.class)
                .getResultList();
        System.out.println("----------------");

        AccountDtos.forEach(a-> System.out.println(a));

        //close the session
        session.close();
        //close the sf
        sessionFactory.close();







    }
}
















