package com.deepskilling.hibernate.repository;

import com.deepskilling.hibernate.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class EmployeeRepository {
    private SessionFactory sessionFactory;
    
    public EmployeeRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    public void saveEmployee(Employee employee) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.save(employee);
            session.getTransaction().commit();
        } finally {
            session.close();
        }
    }
    
    public Employee findById(Long id) {
        Session session = sessionFactory.openSession();
        try {
            return session.get(Employee.class, id);
        } finally {
            session.close();
        }
    }
    
    public void updateEmployee(Employee employee) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.update(employee);
            session.getTransaction().commit();
        } finally {
            session.close();
        }
    }
}