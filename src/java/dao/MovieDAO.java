/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import model.Movie;
import org.hibernate.SessionFactory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


/**
 *
 * @author Filipus
 */
public class MovieDAO {
    public static SessionFactory factory;
    public MovieDAO(){
        try{
            factory = new Configuration().configure().buildSessionFactory();
        }catch(Exception e){
            System.err.println("error creating session factory");
            e.printStackTrace();
        }
    }
    
    public ArrayList<Movie> getAllMovie(){
        Session session = factory.openSession();
        ArrayList<Movie> result = null;
        Transaction tx = session.beginTransaction();
        
        Query q = session.createQuery("from Movie");
        result = (ArrayList<Movie>) q.list();
        tx.commit();
        session.close();
        return result;
    }
    
    public boolean insertMovie(Movie m){
        boolean result=true;
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        try{
            session.save(m);
            tx.commit();
        }catch(Exception e){
            e.printStackTrace();
            result = false;
        }
        session.close();
        return result;
    }
    
    public boolean updateMovie(int id, String title, String synopsis, double rating, int duration, String poster, int status){
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        Query q = session.createQuery("Update Movie set title = :ttl, synopsis = :syn, rating = :rtg, "
                + "duration = :dr, poster = :pst, status = :st where movieId = :m_id");
        q.setParameter("ttl", title);
        q.setParameter("syn", synopsis);
        q.setParameter("rtg", rating);
        q.setParameter("dr", duration);
        q.setParameter("pst", poster);
        q.setParameter("st", status);
        q.setParameter("m_id", id);
        
        int result = q.executeUpdate();
        tx.commit();
        session.close();
        return result > 0;
    }
    
    public boolean deleteMovie(int id){
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        Query q = session.createQuery("DELETE FROM Movie WHERE movieId = :m_id");
        q.setParameter("m_id", id);
        int result = q.executeUpdate();
        tx.commit();
        session.close();
        return result > 0;
    }
    
    public Movie getMovie(int id){
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        Movie _movie = null;
        Query q = session.createQuery("from Movie WHERE movieId = :m_id");
        q.setParameter("m_id", id);
        _movie = (Movie) q.uniqueResult();
        tx.commit();
        session.close();
        return _movie;
    }
}
