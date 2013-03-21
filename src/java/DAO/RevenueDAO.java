/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Sustainability.Diversionsaving;
import Sustainability.HibernateUtil;
import Sustainability.Revenue;
import Sustainability.Transportation;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author S405364
 */
public class RevenueDAO {

    SessionFactory sessionFactory = null;
    Session session = null;
    Revenue revenue;
    ArrayList<Revenue> revenueList;

    /**
     * Inserts single instance of revenue into database.
     *
     * @param _revenue
     */
    public void insertRevenueRecord(Revenue _revenue) {
        Long recentLot;
        try {
            sessionFactory = HibernateUtil.getSessionFactory();
            session = sessionFactory.openSession();
            org.hibernate.Transaction tx = session.beginTransaction();
//            Transportation trans = new Transportation();
//            trans.setDate(new Date());
//            trans.setCost(60.00);
            TransportationDAO tDAO = new TransportationDAO();
//            tDAO.insertTransportationCost(trans);
            ArrayList<Transportation> list = tDAO.getTransCosts();
            Collections.sort(list, new Comparator<Transportation>() {
                @Override
                public int compare(Transportation object1, Transportation object2) {
                    return object1.getLot().compareTo(object1.getLot());
                }
            });
            Transportation temp=list.get(list.size()-1);
            
            _revenue.setTransportation(temp);
            System.out.println(_revenue.getCategory().getCategoryName());
            System.out.println(_revenue.getTransportation().getLot());
            session.save(_revenue);
            tx.commit();
            System.out.println("Revenue recorded successfully");
        } catch (Exception e) {
            //e.printStackTrace();
            e.printStackTrace();
            System.out.println("Cannot insert revenue.\n"+e.getMessage());
        }
    }

    /**
     * This method is used to insert a group of revenues.
     *
     * @param _revenues Arraylist of revenue objects to be inserted into
     * database.
     */
    public void insertRevenueRecords(ArrayList<Revenue> _revenues) {
        sessionFactory = HibernateUtil.getSessionFactory();
        session = sessionFactory.getCurrentSession();
        org.hibernate.Transaction tx = session.beginTransaction();
        tx.begin();
        Transportation trans = new Transportation();
        trans.setDate(new Date());
        TransportationDAO tDAO = new TransportationDAO();
        tDAO.insertTransportationCost(trans);
        for (Revenue r : _revenues) {
            System.out.println("helloman:"+r.getCategory().getCategoryName());
            insertRevenueRecord(r);
        }
        //tx.commit();
    }
    
    public ArrayList<Revenue> getRevenues(Date startDate, Date endDate) {
        revenueList = new ArrayList<Revenue>();
        try {
            sessionFactory = HibernateUtil.getSessionFactory();
            session = sessionFactory.getCurrentSession();
            org.hibernate.Transaction tx = session.beginTransaction();
            Query query = session.createSQLQuery("select * from Revenue u where u.Date>=:sDate && u.Date<=:eDate")
                    .addEntity(Revenue.class)
                    .setParameter("sDate", startDate)
                    .setParameter("eDate", endDate);
            List result = query.list();
            Iterator<Revenue> iterator = result.iterator();
            while (iterator.hasNext()) {
                Revenue r = new Revenue();
                r = iterator.next();
                revenueList.add(r);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        session.close();
        return revenueList;
    }
}
