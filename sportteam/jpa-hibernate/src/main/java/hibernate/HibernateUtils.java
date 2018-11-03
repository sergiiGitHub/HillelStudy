package hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by sergii on 02.11.18.
 */
@SuppressWarnings("deprecation")
public class HibernateUtils {
    private static SessionFactory sessionFactory;

    static {
        try {
            sessionFactory = new Configuration().configure().buildSessionFactory();
        } catch (Exception ex) {
            System.err.println("Sesiotn could not create" + ex);
        }

    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
