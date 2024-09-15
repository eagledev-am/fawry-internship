package fawry.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static SessionFactory sessionFactory;

    public synchronized static SessionFactory getSessionFactory() {
        if(sessionFactory == null){
            Configuration configuration = new Configuration();
            configuration.configure("hibernate.cfg.xml");
            configuration.addAnnotatedClass(Process.class);
            sessionFactory = configuration.buildSessionFactory();
        }
        return sessionFactory;
    }
}
