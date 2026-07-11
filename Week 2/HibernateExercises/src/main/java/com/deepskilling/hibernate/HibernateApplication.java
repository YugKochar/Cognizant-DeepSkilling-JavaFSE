package com.deepskilling.hibernate;

import com.deepskilling.hibernate.entity.Department;
import com.deepskilling.hibernate.entity.Employee;
import com.deepskilling.hibernate.repository.DepartmentRepository;
import com.deepskilling.hibernate.repository.EmployeeRepository;
import org.hibernate.SessionFactory;

public class HibernateApplication {
    
    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateConfig.getSessionFactory();
        
        DepartmentRepository deptRepo = new DepartmentRepository(sessionFactory);
        EmployeeRepository empRepo = new EmployeeRepository(sessionFactory);
        
        // Save Department
        Department dept = new Department("Engineering", "New York");
        deptRepo.saveDepartment(dept);
        
        // Save Employee
        Employee emp = new Employee("Vinay Kumar", "vinay@deepskilling.com", 85000, dept.getId());
        empRepo.saveEmployee(emp);
        
        System.out.println("Data saved successfully!");
        
        HibernateConfig.shutdown();
    }
}