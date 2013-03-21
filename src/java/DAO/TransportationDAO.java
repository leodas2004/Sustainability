/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Sustainability.HibernateUtil;
import Sustainability.Revenue;
import Sustainability.Transportation;
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
public class TransportationDAO {

    SessionFactory sessionFactory = null;
    Session session = null;
    Transportation transportation;

    public void insertTransportationCost(Transportation _transportation) {
        try {
            sessionFactory = HibernateUtil.getSessionFactory();
            session = sessionFactory.getCurrentSession();
            org.hibernate.Transaction tx = session.beginTransaction();
            tx.begin();
            System.out.println("man:"+_transportation.getCost());
            session.save(_transportation);
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public ArrayList<Transportation> getTransCosts(){
        ArrayList<Transportation> transList;
        transList = new ArrayList<Transportation>();
        try {
            sessionFactory = HibernateUtil.getSessionFactory();
            session = sessionFactory.getCurrentSession();
            org.hibernate.Transaction tx = session.beginTransaction();
            sessionFactory = HibernateUtil.getSessionFactory();
            session = sessionFactory.getCurrentSession();
            Query query = session.createSQLQuery("select * from transportation")
                    .addEntity(Transportation.class);

            List result = query.list();
            Iterator<Transportation> iterator = result.iterator();
          
            while (iterator.hasNext()) {
                Transportation cat = new Transportation();
                cat = iterator.next();
                transList.add(cat);
            }
            return transList;
        } catch (Exception e) {
            e.printStackTrace();
            return transList;
        }
    }
}
