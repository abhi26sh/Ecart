package com.abhi.dao;

import com.abhi.entities.Category;
import com.abhi.entities.Product;
import com.abhi.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class ProductDao {
    private SessionFactory factory;

    public ProductDao() {
        factory= HibernateUtils.getFactory();
    }

    public int addProduct(Product p)
    {
        int pid=0;
        try {
            Session session = factory.openSession();
            Transaction tx = session.beginTransaction();
            pid = (int) session.save(p);
            tx.commit();
            session.close();
        }catch (Exception e)
        {
            e.printStackTrace();
        }

        return pid;
    }

    public List<Product> getAllProducts(){
        List<Product> p= factory.openSession().createQuery("from Product ").list();
        return p;
    }

    public List<Product> getAllProductsById(int cid){
        List pr= factory.openSession().createQuery("from Product as P WHERE P.category.categoryId =:e").setParameter("e",cid).list();
        return pr;
    }

}
