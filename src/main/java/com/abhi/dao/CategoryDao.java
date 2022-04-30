package com.abhi.dao;

import com.abhi.entities.Category;
import com.abhi.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class CategoryDao {
    private SessionFactory factory;

    public CategoryDao() {
        factory= HibernateUtils.getFactory();
    }

    public int addCategory(Category cat)
    {
        int cid=0;
        try {
            Session session = factory.openSession();
            Transaction tx = session.beginTransaction();
             cid = (int) session.save(cat);
            tx.commit();
            session.close();
        }catch (Exception e)
        {
            e.printStackTrace();
        }

        return cid;
    }

    public List<Category> getCategories()
    {
        List<Category> list= factory.openSession().createQuery("from Category").list();
        return list;
    }

    public  Category getCategoryByid(int id)
    {
        Category c=(Category) factory.openSession().createQuery("from Category Where categoryId =:e").setParameter("e",id).uniqueResult();
        return c;
    }
}
