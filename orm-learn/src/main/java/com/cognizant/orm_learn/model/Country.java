package com.cognizant.orm_learn.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.OneToMany;
import jakarta.persistence.FetchType;
import java.util.List;

@Entity
@Table(name="country")
public class Country {

    @Id
    @Column(name="co_code")
    private String code;

    @Column(name="co_name")
    private String name;

    // One Country has Many Stock Exchanges.
    // mappedBy points to the 'country' variable inside the StockExchange class.
    @OneToMany(mappedBy = "country", fetch = FetchType.LAZY)
    private List<StockExchange> stockExchanges;

    // Getters and Setters
    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public List<StockExchange> getStockExchanges() { return stockExchanges; }
    public void setStockExchanges(List<StockExchange> stockExchanges) { this.stockExchanges = stockExchanges; }

    @Override
    public String toString() {
        return "Country [code=" + code + ", name=" + name + "]";
    }
}