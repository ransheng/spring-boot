package com.yy.web.mail.sender;

import com.yy.web.mail.sender.impl.MailSenderTemplateImpl;
import com.yy.web.mail.strategy.MailStrategy;
import com.yy.web.mail.vo.MailVO;

import javax.mail.MessagingException;

public interface MailSenderTemplate {

    /**
     * 发送邮件
     *
     * @param vo
     */
    void sendMail(MailVO vo) throws MessagingException;


    /**
     * 设置邮件发送策略
     *
     * @param strategy
     * @return
     */
    MailSenderTemplateImpl setStrategy(MailStrategy strategy);
}
