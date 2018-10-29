package com.sola.filter;

import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authz.AuthorizationFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * 自定义shiro过滤器
 * Created by sola on 2018/10/29.
 */
public class RolesOrFilter extends AuthorizationFilter {
    @Override
    protected boolean isAccessAllowed(ServletRequest servletRequest, ServletResponse servletResponse, Object o) throws Exception {

        Subject subject = getSubject(servletRequest, servletResponse);

        String[] roles = (String[])o ;
        if(roles == null || roles.length == 0){
            return true ;
        }
        for(String roleItem : roles){
            if(subject.hasRole(roleItem)){
                return true ;
            }
        }

        return false;
    }
}
