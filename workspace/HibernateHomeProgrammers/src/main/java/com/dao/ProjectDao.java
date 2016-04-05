package com.dao;

import com.hibernate.HibernateUtil;
import com.model.Programmer;
import com.model.Project;
import org.hibernate.Session;

import java.io.Serializable;
import java.util.List;

/**
 * Created by alexey.savchuk on 04.04.2016.
 */
public class ProjectDao implements Serializable{

    public long saveProject(Project project) {
        Session session=  HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        long id=(Long) session.save(project);
        session.getTransaction().commit();
        return id;
    }


    public void deleteProject(long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Project project = (Project) session.get(Project.class, id);
        session.delete(project);
        session.getTransaction().commit();
    }



}
