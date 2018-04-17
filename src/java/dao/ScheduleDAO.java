/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import java.util.ArrayList;
import model.Schedule;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author Filipus
 */
public class ScheduleDAO {
    
    public ArrayList<Schedule> getAllSchedule() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        ArrayList<Schedule> result;

        try {
            Query q = session.createQuery("FROM Schedule");
            result = (ArrayList<Schedule>) q.list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }

        return result;
    }
    
    public ArrayList<Schedule> getAll(int movieId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        ArrayList<Schedule> tmp = getAllSchedule();
        ArrayList<Schedule> result = new ArrayList<>();
        for (Schedule schedule : tmp) {
            if(schedule.getMovie().getMovieId()==movieId){
                result.add(schedule);
            }
        }
        return result;
    }
}
