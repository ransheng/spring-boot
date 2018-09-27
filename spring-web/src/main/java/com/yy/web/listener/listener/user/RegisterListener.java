package com.yy.web.listener.listener.user;

import com.yy.web.listener.EventListener;
import com.yy.web.listener.annotation.ListenerAnnotation;
import com.yy.web.listener.enums.EventEnum;
import com.yy.web.listener.event.user.RegisterEvent;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @author ransheng
 * @desc
 * @create 2018-09-26
 **/
@Data
@Slf4j
@Component
public class RegisterListener implements EventListener<RegisterEvent> {

    /**
     * 获取事件发布枚举
     *
     * @return
     * @author ransheng
     */
    @Override
    public EventEnum getEvent() {
        return EventEnum.USER_REGISTER_MAIL;
    }

    @Override
    @Async
    @ListenerAnnotation(value = EventEnum.USER_REGISTER_MAIL)
    public void onApplicationEvent(RegisterEvent registerEvent) {
        double a=1/0;
        try{
            Thread.sleep(5000);
            log.info("执行用户注册发送邮件：{}",registerEvent.getEvent());
        }catch (Throwable e){
            log.error("用户注册发送邮件失败",e.getMessage(),e);
        }
    }
}
