package db;

import models.Customer;
import models.Order;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class DBOrder {

    private static Session session;
    private static Transaction transaction;

    public static void save(Order order) {
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            session.save(order);
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public static List<Order> getAll(){
        session = HibernateUtil.getSessionFactory().openSession();
        List<Order> results = null;
        try {
            Criteria cr = session.createCriteria(Customer.class);
            results = cr.list();
        } catch(HibernateException e){
            e.printStackTrace();
        } finally {
            session.close();
        }
        return results;
    }

    public static Order findById(int id){
        Order result = null;
        session = HibernateUtil.getSessionFactory().openSession();

        try {
            Criteria cr = session.createCriteria(Order.class);
            cr.add(Restrictions.eq("id", id));
            result = (Order) cr.uniqueResult();
        } catch(HibernateException ex){
            ex.printStackTrace();
        } finally {
            session.close();
        }
        return result;
    }
}
