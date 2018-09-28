package com.yy.web.mail.strategy.impl;


import com.yy.web.mail.strategy.MailStrategy;
import com.yy.web.mail.vo.MailVO;

/**
 * Created by ransheng
 */
public class TextStrategy implements MailStrategy {

    @Override
    public String message(MailVO vo) {
        return vo.getEmailContent();
    }
}
