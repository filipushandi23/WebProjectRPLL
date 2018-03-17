/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

/**
 *
 * @author Filipus
 */
import java.util.ArrayList;
import model.Cinema;
import model.Studio;
import org.hibernate.SessionFactory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


/**
 *
 * @author Filipus
 */
public class CinemaDAO {
    public static SessionFactory factory;
    public CinemaDAO(){
        try{
            factory = new Configuration().configure().buildSessionFactory();
        }catch(Exception e){
            System.err.println("error creating session factory");
            e.printStackTrace();
        }
    }
    
    public ArrayList<Cinema> getAllCinema(){
        Session session = factory.openSession();
        ArrayList<Cinema> result = null;
        Transaction tx = session.beginTransaction();
        
        Query q = session.createQuery("from Cinema");
        result = (ArrayList<Cinema>) q.list();
        tx.commit();
        session.close();
        return result;
    }
    
    public boolean insertCinema(Cinema c){
        boolean result=true;
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        try{
            session.save(c);
            tx.commit();
        }catch(Exception e){
            e.printStackTrace();
            result = false;
        }
        session.close();
        return result;
    }
    
    public boolean updateCinema(String cinemaName, String address, String city, String province){
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        Query q = session.createQuery("Update Cinema set  address = :add, city = :ct, province = :prv where cinemaName = :c_name");
        
        q.setParameter("c_name", cinemaName);
        q.setParameter("add", address);
        q.setParameter("prv", province);
        q.setParameter("ct", city);
        
        int result = q.executeUpdate();
        tx.commit();
        session.close();
        return result > 0;
    }
    
    public boolean deleteCinema(String name){
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        Query q = session.createQuery("DELETE FROM Cinema WHERE cinemaName = :c_name");
        q.setParameter("c_name", name);
        int result = q.executeUpdate();
        tx.commit();
        session.close();
        return result > 0;
    }
    
    public Cinema getCinema(String name){
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        Cinema _cinema = null;
        Query q = session.createQuery("from Movie WHERE cinemaName = :c_name");
        q.setParameter("c_name", name);
        _cinema = (Cinema) q.uniqueResult();
        tx.commit();
        session.close();
        return _cinema;
    }
    
}