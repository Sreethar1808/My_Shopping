package com.My_Shopping.My_Shopping.service;

import com.My_Shopping.My_Shopping.expections.MailNotSend;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class MailService {

    @Autowired
    JavaMailSender javaMailSender;

    public void sendmail(String message, String buyermail, String subjectLine)
    {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage);
        try{
            mimeMessageHelper.setTo(buyermail);
            mimeMessageHelper.setSubject(subjectLine);
            mimeMessageHelper.setText(message);
            javaMailSender.send(mimeMessage);
        }
        catch (Exception e)
        {
              throw new MailNotSend("Mail not Send try again later");
        }
    }
}
