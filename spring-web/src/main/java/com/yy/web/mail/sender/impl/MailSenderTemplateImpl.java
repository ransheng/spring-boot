package com.yy.web.mail.sender.impl;

import com.yy.web.mail.sender.MailSenderTemplate;
import com.yy.web.mail.strategy.MailStrategy;
import com.yy.web.mail.strategy.impl.TextStrategy;
import com.yy.web.mail.vo.MailVO;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.mail.MailProperties;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.Date;

/**
 * @author ransheng
 * @desc
 * @create 2018-09-27
 **/
@Component
@Slf4j
public class MailSenderTemplateImpl implements MailSenderTemplate {

    @Autowired
    private JavaMailSender mailSender;

    private MailStrategy strategy;

    @Autowired
    private MailProperties mail;

    @Override
    public MailSenderTemplateImpl setStrategy(MailStrategy strategy) {
        this.strategy = strategy;
        return this;
    }

    @Override
    public void sendMail(MailVO vo) throws MessagingException {
        if(vo.getReceivers()==null || vo.getReceivers().length<1){
            log.info("接收人邮箱不能为空:{}",vo);
            return;
        }
        MimeMessage mimeMessage = mailSender.createMimeMessage();

        // 第二个参数表示这个是mulipart类型的
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, "utf-8");
        boolean isHtmlText = true;

        if (this.strategy instanceof TextStrategy) {
            isHtmlText = false;
        }

        this.emailMessage(helper, vo);

        // true表示发送的是html消息
        helper.setText(this.sendContent(vo), isHtmlText);

        // 显示是内置图片等
        if (vo.getClassPathResource() != null && vo.getClassPathResource().length > 0) {
            for (ClassPathResource resource : vo.getClassPathResource()) {
                String fileName = resource.getFilename();
                helper.addInline(fileName.substring(0, fileName.lastIndexOf(".")), resource);
            }
        }

        // 附件
        if (vo.getAttachFile() != null && vo.getAttachFile().length > 0) {
            for (File file : vo.getAttachFile()) {
                FileSystemResource resource = new FileSystemResource(file);
                helper.addAttachment(file.getName(), resource);
            }
        }

        mailSender.send(mimeMessage);

    }


    private void emailMessage(MimeMessageHelper helper, MailVO vo) throws MessagingException {
        if (vo.getCc() != null && vo.getCc().length> 0) {
            helper.setCc(vo.getCc());
        }
        if (vo.getBcc() != null && vo.getBcc().length > 0) {
            helper.setBcc(vo.getBcc());
        }
        if(StringUtils.isNotBlank(vo.getSender())){
            helper.setFrom(vo.getSender());
        }else{
            helper.setFrom(mail.getUsername());
        }
        helper.setTo(vo.getReceivers());
        helper.setSubject(vo.getSubject());
        helper.setSentDate(new Date());
    }

    private String sendContent(MailVO vo) {
        return this.strategy.message(vo).toString();
    }


}
