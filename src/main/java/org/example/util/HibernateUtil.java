package org.example.util;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.example.entity.DesktopEntity;
import org.example.entity.Trainee;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;


public class HibernateUtil {

    private static Logger logger = (Logger) LogManager.getLogger(HibernateUtil.class);
    private static SessionFactory sessionFactory;

    static {

        try {

            Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
            configuration.addAnnotatedClass(DesktopEntity.class);
            configuration.addAnnotatedClass(Trainee.class);

            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties()).build();
            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        } catch (ExceptionInInitializerError ex) {
            logger.error("Initial SessionFactory creation failed." + ex);

            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
