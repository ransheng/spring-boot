package com.yy.web.mail.strategy.impl;


import com.yy.web.mail.strategy.MailStrategy;
import com.yy.web.mail.vo.MailVO;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring4.SpringTemplateEngine;

/**
 * Created by ransheng
 */

public class ThymeleafStrategy implements MailStrategy {

    private SpringTemplateEngine springTemplateEngine;
    private Context context;
    private String templateName;

    public ThymeleafStrategy setSpringTemplateEngine(SpringTemplateEngine springTemplateEngine) {
        this.springTemplateEngine = springTemplateEngine;
        return this;
    }

    public ThymeleafStrategy(Context context, String templateName) {
        this.context = context;
        this.templateName = templateName;
    }

    public ThymeleafStrategy setContext(Context context) {
        this.context = context;
        return this;
    }

    @Override
    public String message(MailVO vo) {
        String content = this.springTemplateEngine.process(this.templateName, context);
        return content;
    }
}
