package com.yy.web.service;

import com.yy.web.listener.event.AbstractEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * @author ransheng
 * @desc
 * @create 2018-09-26
 **/
@Component
public class Publisher {

    @Autowired
    ApplicationContext applicationContext;

    public void publish(AbstractEvent abstractEvent){
        applicationContext.publishEvent(abstractEvent);
    }
}
