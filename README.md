# spring-boot
spring event listener 解耦

# com.yy.web.listener 包描述
1、所有event事件继承com.yy.web.listener.event.AbstractEvent

2、所有event参数vo需继承com.yy.web.listener.vo.BaseEventVO

3、event类型有枚举com.yy.web.listener.enums.EventEnum 统一管理

4、事件监听类需com.yy.web.listener.listener.* 包下，并实现com.yy.web.listener.EventListener接口

5、com.yy.web.listener.aop.ListenerAop做异常业务记录，方便后期异常业务事物补偿，切入点为@ListenerAnnotation注解的方法

