package db;

import models.Customer;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class DBCustomer {

    private static Session session;
    private static Transaction transaction;

    public static void save(Customer customer) {
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            session.save(customer);
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public static List<Customer> getAll(){
        session = HibernateUtil.getSessionFactory().openSession();
        List<Customer> results = null;
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

    public static Customer findById(int id){
        Customer result = null;
        session = HibernateUtil.getSessionFactory().openSession();

        try {
            Criteria cr = session.createCriteria(Customer.class);
            cr.add(Restrictions.eq("id", id));
            result = (Customer) cr.uniqueResult();
        } catch(HibernateException ex){
            ex.printStackTrace();
        } finally {
            session.close();
        }
        return result;
    }
}
