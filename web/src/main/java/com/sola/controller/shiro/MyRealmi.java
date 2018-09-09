package com.sola.controller.shiro;


import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 自定义 Realm 域
 */
public class MyRealmi extends AuthorizingRealm {

    private static final Logger logger = LoggerFactory.getLogger(MyRealmi.class);

    /**
     * Realm域名字
     *
     * @return
     */
    @Override
    public String getName() {
        return this.getClass().getName();
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        String username = (String) authenticationToken.getPrincipal();//得到用户名
        String password = new String((char[]) authenticationToken.getCredentials());//得到密码

        //-----这里可以用token中的username和password去数据库查询用户,这里测试先写死
        if (!"sola".equals(username)) {
            //如果用户名错误
            throw new UnknownAccountException();
        }
        if (!"123456".equals(password)) {
            //如果密码错误
            throw new IncorrectCredentialsException();
        }
        //如果身份认证验证成功，返回一个AuthenticationInfo实现；
        return new SimpleAuthenticationInfo(username, password, getName());

    }
}
