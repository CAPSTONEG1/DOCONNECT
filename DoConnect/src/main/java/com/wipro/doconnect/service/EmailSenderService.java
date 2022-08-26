package com.wipro.doconnect.service;

public interface EmailSenderService
{
    void sendEmail(String to, String subject, String message);
}
