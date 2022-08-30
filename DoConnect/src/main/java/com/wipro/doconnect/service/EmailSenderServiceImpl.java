/*@Author:Rajesh
Modified Date:30-08-2022
Description:EmailSenderServiceImpl implementation class for interface EmailSenderService.
*/

package com.wipro.doconnect.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.wipro.doconnect.service.EmailSenderService;

@Service
public class EmailSenderServiceImpl implements EmailSenderService {
	
	@Autowired
    private final JavaMailSender mailSender;

    public EmailSenderServiceImpl(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    /*@Author:Rajesh
	Modified Date:30-08-2022
	Description:sendEmail service.
	Params:to, subject, message
	ReturnType:void
	*/
    @Override
    public void sendEmail(String to, String subject, String message) {

        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("$(DoConnect.org)");
        simpleMailMessage.setTo(to);
        simpleMailMessage.setSubject(subject);
        simpleMailMessage.setText(message);

        this.mailSender.send(simpleMailMessage);
        System.out.println("Mail sent successful");
    }
}
