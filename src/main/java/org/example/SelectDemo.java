package org.example;

import org.example.entity.Customer;
import org.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class SelectDemo {

    public static void main(String[] args) {
        try(Session session = HibernateUtil.getSession().openSession()) {
            session.beginTransaction();
//            System.out.println("Adding a customer");
//            Customer c = new Customer();
//            c.setId(1009);c.setCustomerName("Rahul");
//            session.persist(c);
//            session.getTransaction().commit();

            System.out.println("Selecting the customer id's from Customer Table");
            String SELECT_CUSTOMER_ID = "select c.id from Customer c";
            System.out.println("Displaying records from customer table");
            Query<Integer> customerIdList = session.createQuery(SELECT_CUSTOMER_ID,Integer.class);
            customerIdList.stream().forEach(x->System.out.println("Customer id :" +x));

            System.out.println("Select all from customers table and display");
            String SELECT_ALL="from Customer";
            Query<Customer> customerList = session.createQuery(SELECT_ALL,Customer.class);
            customerList.stream().forEach(System.out::println);

            System.out.println("Display all customer names where id >= 1000");
            String SELECT_CUSTOMERS_BASED_ON_ID = "select c.customerName from Customer c where c.id >=1000";
            Query query = session.createQuery(SELECT_CUSTOMERS_BASED_ON_ID, Customer.class);
            List<String> customerNamesList = query.getResultList();
            customerNamesList.forEach(System.out::println);


            System.out.println("Selecting all customers");
            Query query2 = session.createNativeQuery
                            ("select * from Customer_HQL c where c.id >=:customerId").addEntity(Customer.class);
                    query2.setParameter("customerId", 1000);

            List res = query2.getResultList();
            res.forEach(System.out::println);

            }
        catch (Exception e){
            System.err.println(e.getMessage());
        }
    }
}
