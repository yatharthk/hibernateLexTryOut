package org.myBank.util;

import org.hibernate.SessionFactory;

import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.myBank.entity.CustomerLoan;
import org.myBank.entity.CustomerLoanPK;


public class HibernateUtil {

    private static final SessionFactory sessionFactory;

    static {
        try {
            Configuration configuration = new Configuration().configure();
            configuration.addAnnotatedClass(CustomerLoan.class);
            configuration.addAnnotatedClass(CustomerLoanPK.class);
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties()).build();
            sessionFactory = configuration.buildSessionFactory(serviceRegistry);

        } catch (Throwable ex) {
            System.out.println("Registry Initialization Exception " + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSession(){
        return sessionFactory;
    }
}
