package org.example;

import org.example.entity.Customer;
import org.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

public class DeleteDemo {

    public static void main(String[] args) {
        try( Session session = HibernateUtil.getSession().openSession()){
            session.beginTransaction();
            System.out.println("Inserting customer into db");
            Customer c = new Customer();
            c.setId(1002);c.setCustomerName("sam");
            session.persist(c);
            session.getTransaction().commit();
            System.out.println("Customer inserted with id:"+c.getId());

            session.beginTransaction();

            Query<Customer> query = session.createQuery("delete Customer c where c.id =:cId",Customer.class);
            query.setParameter("cId","1002");
            int updatedRows = query.executeUpdate();
            System.out.println(updatedRows+"rows affected.");
            session.getTransaction().commit();
        }
        catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
