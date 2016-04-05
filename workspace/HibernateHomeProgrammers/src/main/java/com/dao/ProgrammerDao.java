package com.dao;

import com.hibernate.HibernateUtil;
import com.model.Programmer;
import org.hibernate.Session;

import java.util.List;

/**
 * Created by alexey.savchuk on 04.04.2016.
 */
public class ProgrammerDao {


    public int saveProgrammer(Programmer programmer) {
      Session session=  HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        int id=(Integer) session.save(programmer);
        session.getTransaction().commit();
        return id;
    }


    public List<Programmer> getAllProgrammers() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        @SuppressWarnings("unchecked")
        List<Programmer> programmers = (List<Programmer>) session.createQuery("FROM Programmer p ORDER BY p.firstName ASC").list();

        session.getTransaction().commit();
        return programmers;
    }

    public void updateProgrammer(long id, String firstName, String lastName) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Programmer programmer = (Programmer) session.get(Programmer.class, id);
        programmer.setFirstName(firstName);
        programmer.setLastName(lastName);
        //session.update(student);//No need to update manually as it will be updated automatically on transaction close.
        session.getTransaction().commit();
    }


    public void deleteProgrammer(long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Programmer programmer = (Programmer) session.get(Programmer.class, id);
        session.delete(programmer);
        session.getTransaction().commit();
    }



}
