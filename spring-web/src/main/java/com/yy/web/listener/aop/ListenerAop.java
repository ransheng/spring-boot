package com.yy.web.listener.aop;

import com.yy.web.listener.annotation.ListenerAnnotation;
import com.yy.web.listener.enums.EventEnum;
import com.yy.web.listener.event.AbstractEvent;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author ransheng
 * @desc 异常事件补偿
 * @create 2018-09-27
 **/
@Aspect
@Component
@Slf4j
public class ListenerAop {


    @Pointcut("@annotation(listener)")
    public void pointcut(ListenerAnnotation listener){};

    /**
     * 延迟加载（防止主线程事物未提交）
     * @param listener
     */
    @Before(value = "pointcut(listener)")
    public void before(ListenerAnnotation listener){
        try {
            log.info("{}延迟加载{}毫秒",listener.value(),listener.millis());
            Thread.sleep(listener.millis());
        }catch (Throwable e){
            log.error("事件监听延迟加载异常",e.getMessage(),e);
        }
    }

    /**
     * 事件监听执行出现异常时，做事务补偿
     * @param listener
     * @param ex
     */
    @AfterThrowing(pointcut = "pointcut(listener)",throwing = "ex")
    public void AfterThrowing(JoinPoint pjp, ListenerAnnotation listener, Throwable ex){
        log.info("事件:{},参数:{},异常信息:{}",listener,pjp.getArgs(),ex);
        Object[] objects=pjp.getArgs();
        if(objects==null || objects.length<1 || !(objects[0] instanceof AbstractEvent)){
            return;
        }
        //异常数据可存入mysql、redis等数据库，通过定时器扫描做业务补偿
        log.info("业务异常数据记录....");
    }
}
