package org.example;

import org.example.entity.Customer;
import org.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

public class UpdateDemo {

    public static void main(String[] args) {
        try(Session session = HibernateUtil.getSession().openSession()){
            session.beginTransaction();

            System.out.println("Entering 1 record in db");
            Customer c = new Customer();
            c.setId(1007);
            c.setCustomerName("Aditya");
            session.merge(c);
            session.getTransaction().commit();
            System.out.println("One record created");

            session.beginTransaction();
            System.out.println("Update the details for the 1007 id we entered");
            Query query = session.createQuery("update Customer c set c.customerName='Alok'" +
                    "where c.id=1007",Customer.class);
            int updatedRows = query.executeUpdate();
            if(updatedRows==0||updatedRows==1) System.out.println(updatedRows+" row affected");
            else{
                System.out.println(updatedRows+"rows affected");
            }
            session.getTransaction().commit();
        }
        catch (Exception e){
            System.err.println(e.getMessage());
        }
    }
}
