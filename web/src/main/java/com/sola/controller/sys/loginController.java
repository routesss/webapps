package com.sola.controller.sys;

import com.sola.utils.resultUtil.Result;
import com.sola.vo.LoginUserVo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * Created by sola on 2018/10/28.
 */
@Controller
@RequestMapping(value = "/login")
public class loginController {

    private static final Logger logger = LoggerFactory.getLogger(loginController.class) ;

    @RequestMapping(value = "")
    public String login(){

        return "sys/login/login" ;
    }


    @ResponseBody
    @RequestMapping(value = "/sublogin", method = RequestMethod.POST)
    public Object submitLogin(LoginUserVo userVo){
        Result result = new Result();
        result.setState(1);
        result.setMsg("unknown");
        try{
            Subject subject = SecurityUtils.getSubject();

            UsernamePasswordToken token = new UsernamePasswordToken(userVo.getUsername(), userVo.getPassword());
            //4、登录，即身份验证
            subject.login(token);
            result.setState(0);
            result.setMsg("验证成功");
            //subject.checkRole("超级管理员");
        }catch (Exception e){
            result.setState(1);
            //result.setMsg(e.getMessage());
            result.setMsg("验证失败");
            logger.info("validate fail {}", e.getMessage());
        }

        return result ;
    }


    @ResponseBody
    @RequiresRoles("admin") //验证角色
    @RequestMapping(value = "/test")
    public Object test(){

        return "text" ;
    }

    @ResponseBody
    //@RequiresRoles("admin1")
    @RequiresPermissions("user:add") //验证权限
    @RequestMapping(value = "/test2")
    public Object test2(){

        return "text" ;
    }
}
