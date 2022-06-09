package com.example.javapythonstory.code.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.internet.MimeMessage;

@Component
public class EmailUtil {

    @Autowired
    private static JavaMailSender jms;

    @Value("${spring.mail.username}")
    private static String from;

    public static String sendEmail(String to, String subject, String text){
        try{
            MimeMessage message = null;
            message = jms.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message,true);
            helper.setFrom(from);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(text);
            jms.send(message);
            return "success";
        }catch (Exception e){
            System.out.println(e.getMessage());
            return "fail";
        }
    }

}
