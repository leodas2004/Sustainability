/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Sustainability.Category;
import Sustainability.HibernateUtil;
import Sustainability.Users;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author S405364
 */
public class CategoryDAO {

    ArrayList<Category> categoryList = null;
    SessionFactory sessionFactory = null;
    Session session = null;

    /**
     * This method is used to retrieve all the category
     *
     * @return Returns a list of category
     */
    public ArrayList<Category> getCategoryList() {
        Users user = new Users();
        try {
            sessionFactory = HibernateUtil.getSessionFactory();
            session = sessionFactory.getCurrentSession();
            org.hibernate.Transaction tx = session.beginTransaction();
            sessionFactory = HibernateUtil.getSessionFactory();
            session = sessionFactory.getCurrentSession();
            Query query = session.createSQLQuery("select * from category")
                    .addEntity(Category.class);

            List result = query.list();
            Iterator<Category> iterator = result.iterator();
            categoryList = new ArrayList<Category>();
            while (iterator.hasNext()) {
                Category cat = new Category();
                cat = iterator.next();
                categoryList.add(cat);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        session.close();
        return categoryList;

    }
}