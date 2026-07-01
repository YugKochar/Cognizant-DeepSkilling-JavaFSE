package com.deepskilling.hibernate.repository;

import com.deepskilling.hibernate.entity.Department;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class DepartmentRepository {
    private SessionFactory sessionFactory;
    
    public DepartmentRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    public void saveDepartment(Department department) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.save(department);
            session.getTransaction().commit();
        } finally {
            session.close();
        }
    }
    
    public Department findById(Long id) {
        Session session = sessionFactory.openSession();
        try {
            return session.get(Department.class, id);
        } finally {
            session.close();
        }
    }
}