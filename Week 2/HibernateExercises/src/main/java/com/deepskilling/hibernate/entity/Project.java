package com.deepskilling.hibernate.entity;

import javax.persistence.*;

@Entity
@Table(name = "projects")
public class Project {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "project_name", nullable = false)
    private String name;
    
    @Column(name = "budget")
    private double budget;
    
    @Column(name = "employee_id")
    private Long employeeId;
    
    public Project() {}
    
    public Project(String name, double budget, Long employeeId) {
        this.name = name;
        this.budget = budget;
        this.employeeId = employeeId;
    }
    
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    
    public double getBudget() { return budget; }
    public void setBudget(double budget) { this.budget = budget; }
    
    public Long getEmployeeId() { return employeeId; }
    public void setEmployeeId(Long employeeId) { this.employeeId = employeeId; }
}