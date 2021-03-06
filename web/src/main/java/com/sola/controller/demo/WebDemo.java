package com.sola.controller.demo;

import com.sola.entity.sys.SysUser;
import com.sola.service.demo.ServiceDemo;
import com.sola.service.sys.SysUserService;
import com.sola.serviceimpl.sys.SysUserServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.*;
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

    @Autowired
    private SysUserService sysUserService ;

    /**
     * 测试跳转
     * @return
     */
    @RequestMapping(value = "/demo1")
    public String demo1(){

        logger.info("demo1 日志消息 " + new Date()) ;
        logger.info("demo2 日志消息 " + new Date()) ;


        return "demo/demo1" ;
    }

    /**
     * 测试依赖注入
     * @return
     */
    @RequiresRoles("admin")
    @RequestMapping("/demo2")
    @ResponseBody
    public String demo2(){

        SysUser sysUser = sysUserService.selectByPrimaryKey("1");
        System.out.println(sysUser.getLoginName());

        return serviceDemo.demo1() ;
    }

    @RequiresRoles("admin2")
    @RequestMapping("/demo3")
    @ResponseBody
    public String demo3(){

        return serviceDemo.demo2() ;
    }

    /**
     * socket测试页面
     * @return
     */
    @RequestMapping("/toSocket")
    public String toSocket(){

        return "webSocket/socket" ;
    }


}










