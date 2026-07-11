package com.cognizant.orm_learn.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.cognizant.orm_learn.model.StockExchange;
import com.cognizant.orm_learn.repository.StockExchangeRepository;

@Service
public class StockExchangeService {

    @Autowired
    private StockExchangeRepository stockExchangeRepository;

    @Transactional(readOnly = true)
    public List<StockExchange> getAllStockExchanges() {
        return stockExchangeRepository.findAll();
    }
}