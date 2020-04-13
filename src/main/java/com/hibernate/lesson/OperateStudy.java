package com.hibernate.lesson;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class OperateStudy {
    public static void main(String[] args) {
        Configuration con = new Configuration().configure();
        SessionFactory sf = con.buildSessionFactory();

        Session session = sf.openSession();
        Transaction tx = null;
        try {


            tx = session.beginTransaction();
            StudyEntity se = new StudyEntity();
            se.setName("hibernate");
            se.setLesson("0409");

            session.save(se);
            tx.commit();
        }catch (Exception e){
            if(tx!=null) {
                tx.rollback();
            }
        }
    }
}
