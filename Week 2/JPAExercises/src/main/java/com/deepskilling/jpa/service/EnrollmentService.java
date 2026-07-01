package com.deepskilling.jpa.service;

import com.deepskilling.jpa.entity.Enrollment;
import javax.persistence.EntityManager;

public class EnrollmentService {
    private EntityManager em;
    
    public EnrollmentService(EntityManager em) {
        this.em = em;
    }
    
    public void enrollStudentInCourse(Long studentId, Long courseId, String date) {
        em.getTransaction().begin();
        
        Enrollment enrollment = new Enrollment(studentId, courseId, date);
        em.persist(enrollment);
        
        em.getTransaction().commit();
    }
    
    public void updateGrade(Long enrollmentId, String grade) {
        em.getTransaction().begin();
        
        Enrollment enrollment = em.find(Enrollment.class, enrollmentId);
        if (enrollment != null) {
            enrollment.setGrade(grade);
            em.merge(enrollment);
        }
        
        em.getTransaction().commit();
    }
}