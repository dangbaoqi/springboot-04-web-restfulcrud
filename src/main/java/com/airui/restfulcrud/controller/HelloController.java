package com.airui.restfulcrud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.Map;

/**
 * @author dangbaoqi
 * @date 2019/10/24-10:30
 */
@Controller
public class HelloController {

//    @RequestMapping({"/","/login.html","/login"})
//    public  String index(){
//        return "login";
//    }


    //通过'@ResponseBody'注解直接在页面写出返回内容
    @ResponseBody
    @RequestMapping("/hello")
    public String hello(){
        return "Hello World";
    }


    //使用了模板引擎
    @RequestMapping("/success")
    public String success(Map<String,Object> map){
        map.put("recommend","我是个程序员！");
        map.put("users", Arrays.asList("zhangsan","lisi","xiaozhi"));
        return "SUCCESS";
    }
}
