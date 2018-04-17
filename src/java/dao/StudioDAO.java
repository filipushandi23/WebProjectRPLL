/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import static dao.MovieDAO.factory;
import java.util.ArrayList;
import model.Studio;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Filipus
 */
public class StudioDAO {

    public static SessionFactory factory;

    public StudioDAO() {
        try {
            factory = new Configuration().configure().buildSessionFactory();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public boolean insertStudio(Studio s){
        boolean result=true;
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        try{
            session.save(s);
            tx.commit();
        }catch(Exception e){
            e.printStackTrace();
            result = false;
        }
        session.close();
        return result;
    }
    
    public ArrayList<Studio> getAllStudios(){
        Session session = factory.openSession();
        ArrayList<Studio> result = null;
        Transaction tx = session.beginTransaction();
        
        Query q = session.createQuery("from Studio");       
        result = (ArrayList<Studio>) q.list();
        tx.commit();
        session.close();
        return result;
    }
    
    public Studio getStudioByNumber(int studioNumber){
        Session session = factory.openSession();
        Studio result = null;
        Transaction tx = session.beginTransaction();
        
        Query q = session.createQuery("from Studio where studioNumber = :sNum");
        q.setParameter("sNum", studioNumber);
        result = (Studio) q.uniqueResult();
        tx.commit();
        session.close();
        return result;
    }
    
    public ArrayList<Studio> getStudiosByCinemaName(String cinemaName){
        ArrayList<Studio> tmp = getAllStudios();
        ArrayList<Studio> result = new ArrayList<>();
        for (Studio studio : tmp) {
            if(studio.getCinema().getCinemaName().equals(cinemaName)){
                result.add(studio);
            }
        }
        return result;
    }
}
