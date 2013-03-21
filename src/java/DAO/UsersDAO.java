package DAO;

import Sustainability.Diversionsaving;
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

//    public List getAllUsers() {
//        try {
//            sessionFactory = HibernateUtil.getSessionFactory();
//            session = sessionFactory.getCurrentSession();
//            org.hibernate.Transaction tx = session.beginTransaction();
//            userList = new ArrayList<Users>();
//            Query q = session.createQuery("from Users");
//            userList = (ArrayList<Users>) q.list();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return userList;
//    }
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

    /**
     * This method is used to add new user to the system
     *
     * @param _user Users object. Don't forget to set username as it is a
     * primary key.
     */
    public void addUsers(Users _user) {
        try {
            sessionFactory = HibernateUtil.getSessionFactory();
            session = sessionFactory.getCurrentSession();
            org.hibernate.Transaction tx = session.beginTransaction();
            tx.begin();
            session.save(_user);
            tx.commit();
            System.out.println("Users successfully added");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

     
/**
 * This method is used to edit a particular user.
 *
 * @param _user User object with the new values to bet set for a user. User can
 * only be edited based on the their username so username cannot be updated.
 */
public void editUsers(Users _user){
        try {
            sessionFactory = HibernateUtil.getSessionFactory();
            session = sessionFactory.getCurrentSession();
            org.hibernate.Transaction tx = session.beginTransaction();
            tx.begin();
            Query query = session.createSQLQuery("update Users set firstname=:newFirstName" +
    				", lastname=:newLastName, role=:newRole, password=:newPassword"+
                    " where username = :searchusername");
            query.setParameter("newFirstName", _user.getFirstname());
            query.setParameter("newLastName", _user.getLastname());
            query.setParameter("newRole", _user.getRole());
            query.setParameter("newPassword",_user.getPassword());
            query.setParameter("searchusername", _user.getUsername());
            query.executeUpdate();
            tx.commit();
            System.out.println("User updated successfully");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Users not updated successfully.\n"+e.getMessage());
        }
    }
}