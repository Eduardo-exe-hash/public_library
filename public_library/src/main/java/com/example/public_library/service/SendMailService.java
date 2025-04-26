package com.example.public_library.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class SendMailService {

    @Autowired
    private JavaMailSender mailSender;
    public void sendReserve(String to, String nameBook){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject("Confirmation of the Book Reserve");
        message.setText("Your Amount has been Sucessful");

        mailSender.send(message);
    }
}
