package org.example.util;

import org.example.entity.Customer;
import org.hibernate.InstantiationException;
import org.hibernate.SessionFactory;

import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;


public class HibernateUtil {

    private static final SessionFactory sessionFactory;

    static {
        try {
            Configuration configuration = new Configuration().configure();
            configuration.addAnnotatedClass(Customer.class);
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties()).build();
            sessionFactory = configuration.buildSessionFactory(serviceRegistry);

        } catch (Throwable ex) {
            System.out.println("Registry INitailzation Exception " + ex);
            throw new ExceptionInInitializerError(ex);

        }
    }

    public static SessionFactory getSession(){
        return sessionFactory;
    }
}
