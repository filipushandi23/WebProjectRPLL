/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;


import java.util.ArrayList;
import model.Seat;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Filipus
 */
public class SeatDAO {
    public static SessionFactory factory;
    public SeatDAO(){
        try {
            factory = new Configuration().configure().buildSessionFactory();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public ArrayList<Seat> getAllSeat(){
        Session session = factory.openSession();
        ArrayList<Seat> result = null;
        Transaction tx = session.beginTransaction();
        
        Query q = session.createQuery("from Seat");       
        result = (ArrayList<Seat>) q.list();
        tx.commit();
        session.close();
        return result;
    }
    
    public ArrayList<Seat> getSeatByStudioName(String name){
        ArrayList<Seat> tmp = getAllSeat();
        ArrayList<Seat> result = new ArrayList<>();
        for (Seat seat : tmp) {
            if(seat.getStudio().getStudioName().equals("name")){
                result.add(seat);
            }
        }
        return result;
    }
}
