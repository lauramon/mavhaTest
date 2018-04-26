package ar.com.lauramon.util;
 
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil
{
    private static final SessionFactory sessionFactory = buildSessionFactory();
    
    private static SessionFactory buildSessionFactory() {
        try {
            // Creacion del sessionfactory a partir del hibernate.cfg.xml
            return new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
 
    public static SessionFactory getSessionFactory() {      
        return sessionFactory;
    }
 
    public static void shutdown() {
        getSessionFactory().close();
    }
     
   }