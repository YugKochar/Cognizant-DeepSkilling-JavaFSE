package com.deepskilling.springcore;

public class EmailNotification {
    public void sendEmail(String to, String message) {
        System.out.println("Sending email to: " + to);
        System.out.println("Message: " + message);
    }
}