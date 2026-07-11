package com.deepskilling.hibernate.repository;

import com.deepskilling.hibernate.entity.Project;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class ProjectRepository {
    private SessionFactory sessionFactory;
    
    public ProjectRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    public void saveProject(Project project) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.save(project);
            session.getTransaction().commit();
        } finally {
            session.close();
        }
    }
    
    public Project findById(Long id) {
        Session session = sessionFactory.openSession();
        try {
            return session.get(Project.class, id);
        } finally {
            session.close();
        }
    }
}