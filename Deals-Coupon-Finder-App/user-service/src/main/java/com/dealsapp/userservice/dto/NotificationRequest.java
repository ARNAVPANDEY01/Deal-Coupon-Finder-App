package com.dealsapp.userservice.dto;

public class NotificationRequest {
    private String email;
    private String subject;
    private String message;

    public NotificationRequest(String email, String s, String s1) {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
