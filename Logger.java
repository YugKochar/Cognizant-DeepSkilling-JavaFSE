package com.cognizant.singleton;

/**
 * Exercise 1: Implementing the Singleton Pattern
 */
public class Logger {

    private static Logger instance;

    private Logger() {
        System.out.println("[System Info]: Logger Utility initialized for the first time.");
    }

    public static synchronized Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

   
    public void log(String message) {
        System.out.println("[LOG ENTRY]: " + message);
    }
}