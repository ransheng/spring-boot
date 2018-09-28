package com.yy.web.mail.vo;

import lombok.Data;
import org.springframework.core.io.ClassPathResource;

import java.io.File;

/**
 * @author ransheng
 * @desc 邮件发送
 * @create 2018-09-27
 **/
@Data
public class MailVO {

    /**
     * 邮件发送者
     */
    private String sender;

    /**
     * 邮件接收者
     */
    private String[] receivers;

    /**
     * 邮件抄送人
     */
    private String[] cc;

    /**
     * 邮件抄送人
     */
    private String[] bcc;

    /**
     * Email发送的内容
     */
    private String emailContent;

    /**
     * 邮件主题
     */
    private String subject;

    /**
     * 邮件附件
     */
    private File[] attachFile;

    /**
     * 内连内容,内嵌到html之中
     */
    private ClassPathResource[] classPathResource;

}
