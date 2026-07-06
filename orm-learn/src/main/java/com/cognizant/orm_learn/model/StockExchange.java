package com.cognizant.orm_learn.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.FetchType;

@Entity
@Table(name="stock_exchange")
public class StockExchange {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="se_id")
    private int id;

    @Column(name="se_code")
    private String code;

    @Column(name="se_name")
    private String name;

    // Many Stock Exchanges belong to One Country
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="se_co_code") // Maps to the foreign key column in database
    private Country country;

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public Country getCountry() { return country; }
    public void setCountry(Country country) { this.country = country; }

    @Override
    public String toString() {
        return "StockExchange [id=" + id + ", code=" + code + ", name=" + name + ", country=" + country + "]";
    }
}