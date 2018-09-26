package com.yy.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ransheng
 * @desc
 * @create 2018-09-26
 **/
@RestController
@RequestMapping("rest")
public class SayHiController {


    @GetMapping(value = "sayHi")
    public  String sayHi(String name){
        return "hello "+name;
    }
}
