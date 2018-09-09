package com.sola.controller.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/ShiroTEST")
public class ShiroTEST {

    private static final Logger logger =LoggerFactory.getLogger(ShiroTEST.class) ;

    /**
     * 测试相关的配置文件shiro.imi
     * @return
     */
    /*2.1、首先通过new IniSecurityManagerFactory并指定一个ini配置文件来创建一个SecurityManager工厂；
    2.2、接着获取SecurityManager并绑定到SecurityUtils，这是一个全局设置，设置一次即可；
    2.3、通过SecurityUtils得到Subject，其会自动绑定到当前线程；如果在web环境在请求结束时需要解除绑定；然后获取身份验证的Token，如用户名/密码；
    2.4、调用subject.login方法进行登录，其会自动委托给SecurityManager.login方法进行登录；
    2.5、如果身份验证失败请捕获AuthenticationException或其子类，常见的如： DisabledAccountException（禁用的帐号）、LockedAccountException（锁定的帐号）、UnknownAccountException（错误的帐号）、ExcessiveAttemptsException（登录失败次数过多）、IncorrectCredentialsException （错误的凭证）、ExpiredCredentialsException（过期的凭证）等，具体请查看其继承关系；对于页面的错误消息展示，最好使用如“用户名/密码错误”而不是“用户名错误”/“密码错误”，防止一些恶意用户非法扫描帐号库；
    2.6、最后可以调用subject.logout退出，其会自动委托给SecurityManager.logout方法退出。*/
    @ResponseBody
    @RequestMapping(value = "/demo1")
    public Object demo1() {
        Subject subject = null;
        try {
            IniSecurityManagerFactory factory = new IniSecurityManagerFactory("classpath:shiroConfig/shiro.imi");
            //2、得到SecurityManager实例 并绑定给SecurityUtils
            SecurityManager securityManager = factory.getInstance();
            SecurityUtils.setSecurityManager(securityManager);
            //3、得到Subject及创建用户名/密码身份验证Token（即用户身份/凭证）
            subject = SecurityUtils.getSubject();

            UsernamePasswordToken token = new UsernamePasswordToken("sola", "123");

            //4、登录，即身份验证
            subject.login(token);
            System.out.println("验证成功");
        } catch (Exception e) {
            System.out.println(e.getMessage()); //失败消息
        } finally {
            //6、退出
            subject.logout();
        }
        return "demo1";
    }

    /**
     * 测试相关的配置文件shiro-realm.ini
     * @return
     */
    @ResponseBody
    @RequestMapping(value ="/demo2")
    public Object demo2(){

        Subject subject = null;
        try {
            IniSecurityManagerFactory factory = new IniSecurityManagerFactory("classpath:shiroConfig/shiro-realm.ini");
            //2、得到SecurityManager实例 并绑定给SecurityUtils
            SecurityManager securityManager = factory.getInstance();
            SecurityUtils.setSecurityManager(securityManager);
            //3、得到Subject及创建用户名/密码身份验证Token（即用户身份/凭证）
            subject = SecurityUtils.getSubject();

            UsernamePasswordToken token = new UsernamePasswordToken("sola", "123456");

            //4、登录，即身份验证
            subject.login(token);
            logger.info("身份验证成功");

            //得到一个身份集合，其包含了Realm验证成功的身份信息
            PrincipalCollection principals = subject.getPrincipals();
            logger.info("验证用户信息 {}", principals.asList());

        }catch (AuthenticationException u){
            logger.warn("身份验证失败");
        }
        catch (Exception e) {
            //系统异常
            logger.error("{}",e.getMessage());
            e.printStackTrace();
        } finally {
            //6、退出
            subject.logout();
        }

        return "demo2" ;
    }

}













