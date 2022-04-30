package com.abhi.dao;

import com.abhi.entities.Users;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.Query;

public class UserDao {
    private SessionFactory factory;

    public UserDao(SessionFactory factory) {
        this.factory = factory;
    }

    public Users getUserByMailAndPass(String email, String password)
    {
        Users user=null;

        try{

            Session session= this.factory.openSession();
            user = (Users) session.createQuery("FROM Users as U WHERE U.uMail = :userMail").setParameter("userMail", email)
                    .uniqueResult();
//            String query= "from Users where uMail ='email'";
//
//            Transaction tx= session.beginTransaction();
//            user=(Users) session.createQuery(query).uniqueResult();
//            q.setParameter("e",email);
//            q.setParameter("p",password);

//            tx.commit();
            session.close();
            System.out.println(user);
        }catch(Exception e)
        {
            e.printStackTrace();
            System.out.println("hello");
        }
        return user;
    }
}
