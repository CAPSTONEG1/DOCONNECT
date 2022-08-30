/*@Author:RamyaSri
Modified Date:30-08-2022
Description:EmailSenderService interface which contains abstract methods.
*/


package com.wipro.doconnect.service;

public interface EmailSenderService
{
    void sendEmail(String to, String subject, String message);
}
