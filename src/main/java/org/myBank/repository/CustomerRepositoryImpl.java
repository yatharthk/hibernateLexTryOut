package org.myBank.repository;

import org.myBank.entity.Customer;
import org.myBank.util.HibernateUtil;
import org.hibernate.Session;

public class CustomerRepositoryImpl implements CustomerRepository {
    @Override
    public void addCustomer(Customer c) {
        Session session = HibernateUtil.getSession().openSession();
        session.beginTransaction();
        session.persist(c);
        session.getTransaction().commit();
        session.close();

    }

    @Override
    public Customer getCustomer(int id) {
        Session session = HibernateUtil.getSession().openSession();
        Customer c  = session.get(Customer.class,id);
        session.close();
        return c;
    }

    @Override
    public void updateCustomer(int id, Customer c) {
        Session session = HibernateUtil.getSession().openSession();
        Customer temp = session.get(Customer.class,id);
        temp.setCustomerName(c.getCustomerName());
        temp.setDateOfBirth(c.getDateOfBirth());
        temp.setAge(c.getAge());
        session.beginTransaction();
        session.merge(temp);
        session.getTransaction().commit();
        session.close();
        System.out.println("Customer with id "+ id+" updated");
    }

    @Override
    public void deleteCustomer(int id) {
        Session session = HibernateUtil.getSession().openSession();
        Customer temp = session.get(Customer.class,id);
        session.beginTransaction();
        session.remove(temp);
        session.getTransaction().commit();
        session.close();

        System.out.println("customer with id"+ id+"deleted");
    }
}
