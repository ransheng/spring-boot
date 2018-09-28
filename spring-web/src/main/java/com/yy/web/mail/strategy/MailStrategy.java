package com.yy.web.mail.strategy;

import com.yy.web.mail.vo.MailVO;

public interface MailStrategy {

    String message(MailVO mail);
}
