package com.cognizant.orm_learn.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Country {

    private static final Logger LOGGER = LoggerFactory.getLogger(Country.class);

    private String code;
    private String name;

    // No-argument constructor required for XML property reflection injection
    public Country() {
        LOGGER.debug("Inside Country Constructor.");
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        LOGGER.debug("Setting Code: {}", code);
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        LOGGER.debug("Setting Name: {}", name);
        this.name = name;
    }

    @Override
    public String toString() {
        return "Country [code=" + code + ", name=" + name + "]";
    }
}