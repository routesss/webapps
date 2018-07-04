package com.sola.controller.demo;

import com.sola.service.demo.ServiceDemo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

/**
 * 测试类
 */
@Controller
@RequestMapping(value = "/webDemo")
public class WebDemo {

    private static final Logger logger =LoggerFactory.getLogger(WebDemo.class) ;

    @Autowired
    private ServiceDemo serviceDemo ;

    /**
     * 测试跳转
     * @return
     */
    @RequestMapping(value = "/demo1")
    public String demo1(){

        logger.info("demo1 日志消息 " + new Date()) ;

        return "demo/demo1" ;
    }

    /**
     * 测试依赖注入
     * @return
     */
    @RequestMapping("/demo2")
    @ResponseBody
    public String demo2(){

        return serviceDemo.demo1() ;
    }

    @RequestMapping("/demo3")
    @ResponseBody
    public String demo3(){

        return serviceDemo.demo2() ;
    }
}
