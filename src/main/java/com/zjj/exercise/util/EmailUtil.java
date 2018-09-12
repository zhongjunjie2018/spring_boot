package com.zjj.exercise.util;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

/**
 * 发送邮件
 */
@Component
public class EmailUtil {

    private static Logger logger = Logger.getLogger(EmailUtil.class);

    @Autowired
    private JavaMailSender mailSender;

    //@Value("${mail.fromMail.addr}")
    private String from;

    public String sendSimpleEmail(String[] tos,String subject,String content){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(tos);
        message.setSubject(subject);
        message.setText(content);
        try{
            mailSender.send(message);
        }catch (Exception e){
            return "fail";
        }
        return "success";
    }



}
