package com.dealsapp.notificationservice.service;

import com.dealsapp.notificationservice.DTO.NotificationRequest;
import com.dealsapp.notificationservice.model.NotificationEntity;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class NotificationService implements NotifyService {

    @Autowired
    public NotificationService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }


    @Autowired
    private final JavaMailSender mailSender;

    @Override
    public void sendNotification(NotificationRequest request) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(request.getEmail());
        message.setSubject(request.getSubject());
        message.setText(request.getMessage());
        mailSender.send(message);
    }

    public void sendNotification(NotificationEntity entity) {
        try {

            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);


            helper.setTo("pandeyarnav2002@gmail.com");
            helper.setSubject("Deals App Notification");
            helper.setText(entity.getMessage(), false);


            mailSender.send(message);

//            System.out.println(entity.getUserID());
            System.out.println(entity.getMessage());

        } catch (MessagingException e) {
            System.err.println("Failed to send email: " + e.getMessage());
        }
    }
}
