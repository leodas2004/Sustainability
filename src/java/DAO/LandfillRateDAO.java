                /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Sustainability.Category;
import Sustainability.HibernateUtil;
import Sustainability.LandFillRate;
import Sustainability.Users;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author s405364
 */
public class LandfillRateDAO {

    SessionFactory sessionFactory = null;
    Session session = null;

    public void addLandFillRate(LandFillRate _landfillrate) {
        try {
            sessionFactory = HibernateUtil.getSessionFactory();
            session = sessionFactory.getCurrentSession();
            org.hibernate.Transaction tx = session.beginTransaction();
            tx.begin();
            session.save(_landfillrate);
            tx.commit();
            System.out.println("Landfill rate successfully added");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Landfill rate could not be added\n" + e.getMessage());
        }
    }

    /**
     * This method is used to get all the land fill rates.
     *
     * @return returns an arraylist of landfill rates.
     */
    public ArrayList<LandFillRate> getLandfillRates() {
        ArrayList<LandFillRate> landfilllist;
        landfilllist=new ArrayList<LandFillRate>();
        try {
            sessionFactory = HibernateUtil.getSessionFactory();
            session = sessionFactory.getCurrentSession();
            org.hibernate.Transaction tx = session.beginTransaction();
            sessionFactory = HibernateUtil.getSessionFactory();
            session = sessionFactory.getCurrentSession();
            
            Query query = session.createSQLQuery("select * from landfillrate")
                    .addEntity(LandFillRate.class);

            List result = query.list();
            Iterator<LandFillRate> iterator = result.iterator();
            landfilllist= new ArrayList<LandFillRate>();
            while (iterator.hasNext()) {
                LandFillRate landfillrate = new LandFillRate();
                landfillrate = iterator.next();
                landfilllist.add(landfillrate);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        session.close();
        return landfilllist;
    }
}
