package com.yy.web.listener;

import com.yy.web.listener.enums.EventEnum;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

public interface EventListener<E extends ApplicationEvent> extends ApplicationListener<E> {

    /**
     * 获取事件发布枚举
     *
     * @author ransheng
     *
     * @return
     */
    EventEnum getEvent();

}
