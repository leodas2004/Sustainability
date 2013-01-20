package DAO;

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
public class UsersDAO {

    ArrayList<Users> userList = null;
    SessionFactory sessionFactory = null;
    Session session = null;

    public List getAllUsers() {
        try {
            sessionFactory = HibernateUtil.getSessionFactory();
            session = sessionFactory.getCurrentSession();
            org.hibernate.Transaction tx = session.beginTransaction();
            userList = new ArrayList<Users>();
            Query q = session.createQuery("from Users");
            userList = (ArrayList<Users>) q.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userList;
    }
//this method will be used to verify the username and password for login purpose
    public Users verifyCredentials(String username, String password) {
        Users user = new Users();
        try {
            sessionFactory = HibernateUtil.getSessionFactory();
            session = sessionFactory.getCurrentSession();
            org.hibernate.Transaction tx = session.beginTransaction();
            sessionFactory = HibernateUtil.getSessionFactory();
            session = sessionFactory.getCurrentSession();
            Query query = session.createSQLQuery("select * from users u where u.Username=:uname and u.Password=:pass")
                    .addEntity(Users.class)
                    .setParameter("uname", username.toLowerCase())
                    .setParameter("pass", password);

            List result = query.list();
            Iterator<Users> iterator = result.iterator();
            if (iterator.hasNext()) {
                user = iterator.next();
            } else {
                user = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        session.close();
        return user;
    }
}