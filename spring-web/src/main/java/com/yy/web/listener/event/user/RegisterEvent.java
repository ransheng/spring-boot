package com.yy.web.listener.event.user;

import com.yy.web.listener.enums.EventEnum;
import com.yy.web.listener.event.AbstractEvent;
import com.yy.web.listener.vo.user.RegisterEventVO;
import lombok.Data;

/**
 * @author ransheng
 * @desc
 * @create 2018-09-26
 **/
@Data
public class RegisterEvent extends AbstractEvent<String> {

    private RegisterEventVO event;

    public RegisterEvent(EventEnum eventEnum, RegisterEventVO event) {
        super(eventEnum, event.getId());
        this.event = event;
    }
}
