package com.dealsapp.notificationservice.service;

import com.dealsapp.notificationservice.DTO.NotificationRequest;

public interface NotifyService {
    void sendNotification(NotificationRequest request);
}
