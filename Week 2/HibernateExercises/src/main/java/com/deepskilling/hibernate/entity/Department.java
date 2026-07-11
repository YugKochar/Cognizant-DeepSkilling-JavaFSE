package com.deepskilling.hibernate.entity;

import javax.persistence.*;

@Entity
@Table(name = "departments")
public class Department {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "dept_name", unique = true, nullable = false)
    private String name;
    
    @Column(name = "location")
    private String location;
    
    public Department() {}
    
    public Department(String name, String location) {
        this.name = name;
        this.location = location;
    }
    
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    
    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }
}