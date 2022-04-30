package com.abhi.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
    public static SessionFactory sFactory= null;
    public static SessionFactory getFactory()
    {
        try{
                if (sFactory == null) {

                    sFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
                }
            }catch (Exception e){
            e.printStackTrace();
        }

            return sFactory;

    }
}
