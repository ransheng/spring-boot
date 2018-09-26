package com.yy.web.controller;

import com.yy.web.listener.enums.EventEnum;
import com.yy.web.listener.event.user.RegisterEvent;
import com.yy.web.listener.vo.user.RegisterEventVO;
import com.yy.web.service.Publisher;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ransheng
 * @desc
 * @create 2018-09-26
 **/
@RestController
@RequestMapping("/")
@Slf4j
public class SayHiController {


    @Autowired
    Publisher publisher;

    @GetMapping("register")
    public String register(){
        publisher.publish(new RegisterEvent(EventEnum.USER_REGISTER_MAIL,new RegisterEventVO("用户id")));
        log.info("注册成功");
        return "ok";
    }

    @GetMapping(value = "sayHi")
    public  String sayHi(String name){
        return "hello "+name;
    }
}
