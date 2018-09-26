package com.yy.web.listener.event;

import com.yy.web.listener.enums.EventEnum;
import lombok.Data;
import org.springframework.context.ApplicationEvent;

/**
 * @author ransheng
 * @desc
 * @create 2018-09-14
 **/
@Data
public abstract class AbstractEvent<T> extends ApplicationEvent {

    private T id;

    public AbstractEvent(EventEnum eventEnum, T id) {
        super(eventEnum);
        this.id=id;
    }
}
