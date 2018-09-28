package com.yy.web.controller;

import com.yy.web.listener.enums.EventEnum;
import com.yy.web.listener.event.user.RegisterEvent;
import com.yy.web.listener.vo.user.RegisterEventVO;
import com.yy.web.mail.sender.MailSenderTemplate;
import com.yy.web.mail.strategy.impl.TextStrategy;
import com.yy.web.mail.strategy.impl.ThymeleafStrategy;
import com.yy.web.mail.vo.MailVO;
import com.yy.web.service.Publisher;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring4.SpringTemplateEngine;

import javax.mail.MessagingException;

/**
 * @author ransheng
 * @desc
 * @create 2018-09-26
 **/
@RestController
@RequestMapping("/")
@Slf4j
public class SayHiController {


    @Autowired
    MailSenderTemplate mailSenderTemplate;

    @Autowired
    SpringTemplateEngine springTemplateEngine;

    @Autowired
    Publisher publisher;

    @GetMapping(value = "textSender")
    public String textSender(){
        try{
            MailVO mail=new MailVO();
            mail.setEmailContent("发送mail");
            mail.setReceivers(new String[]{"854906217@qq.com"});
            mail.setSubject("spring boot mail");
            mailSenderTemplate.setStrategy(new TextStrategy()).sendMail(mail);
        }catch (MessagingException e){
            e.printStackTrace();
        }
        return "text";
    }

    @GetMapping(value = "thymeleafSender")
    public String thymeleafSender(){
        try{
            Context context=new Context();
            context.setVariable("hello","sprint boot");
            MailVO mail=new MailVO();
            mail.setEmailContent("发送mail");
            mail.setReceivers(new String[]{"854906217@qq.com"});
            mail.setSubject("spring boot mail");
            mailSenderTemplate.setStrategy(new ThymeleafStrategy(context,"mail/hello").setSpringTemplateEngine(springTemplateEngine)).sendMail(mail);
        }catch (MessagingException e){
            e.printStackTrace();
        }
        return "ok";
    }

    @GetMapping("register")
    public String register(){
        publisher.publish(new RegisterEvent(EventEnum.USER_REGISTER_MAIL,new RegisterEventVO("用户id")));
        log.info("注册成功");
        return "ok";
    }

    @GetMapping(value = "sayHi")
    public  String sayHi(String name){
        return "hello "+name;
    }
}
