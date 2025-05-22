package com.dealsapp.notificationservice.model;

import lombok.Data;

@Data

public class NotificationEntity {

    private Long userID;
    private String message;

    public NotificationEntity(){

    }

    public NotificationEntity(Long userID, String message) {
        this.userID = userID;
        this.message = message;
    }

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
