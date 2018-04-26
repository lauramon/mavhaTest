package ar.com.lauramon.administracion;


import org.hibernate.Session;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

import ar.com.lauramon.util.HibernateUtil;
import ar.com.lauramon.model.Persona;

/* Clase que implementa los servicios de crear, obtener y obtener 
 * todas las personas de la DB 
 * 
 */
public class AdministracionPersona {

    private static SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    protected static Session getSession() {
        return sessionFactory.getCurrentSession();
    }


    public static void guardar(Persona persona) {

        Session session = sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        
        getSession().saveOrUpdate(persona);
        tx.commit();
    }

    public static Persona obtener(Long dni) {
        Persona persona;
        Session session = sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        persona = (Persona)  getSession().get(Persona.class, dni);
        tx.commit();
        return persona;
    }

    public static List<Persona> obtenerTodos() {
        List<Persona> personas;
        Session session = sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        personas = (List<Persona>) getSession().createCriteria(Persona.class).list();
        tx.commit();
        
        return personas;
    }

}

