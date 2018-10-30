package com.sola.utils.MySessionManager;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.UnknownSessionException;
import org.apache.shiro.session.mgt.SessionKey;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.apache.shiro.web.session.mgt.WebSessionKey;

import javax.servlet.ServletRequest;
import java.io.Serializable;

/** 自定义session管理器
 * Created by sola on 2018/10/30.
 */
public class MySessionManager extends DefaultWebSessionManager {

    /**
     * 需要重写token作为sessionid的方法
     */

    /**
     * 优化读取session 对于一次请求 将session放入到request中 优化一次请求多次从数据源(例如redis)中获取session
     * @param sessionKey
     * @return
     * @throws UnknownSessionException
     */
    @Override
    protected Session retrieveSession(SessionKey sessionKey) throws UnknownSessionException {
        Serializable sessionId = getSessionId(sessionKey);
        ServletRequest request = null ;
        Session session = null ;
        if(sessionKey instanceof WebSessionKey){
            //获取request
            request = ((WebSessionKey)sessionKey).getServletRequest() ;
        }
        if(request != null && sessionId != null){
            session = (Session)request.getAttribute(sessionId.toString()) ;
            //如果request中找到了session则返回该session
            if(session != null){
                return session ;
            }
        }
        //获取session
        session = super.retrieveSession(sessionKey) ;
        if(request != null && sessionId != null){
            /*从数据源中获取session放入request中*/
            request.setAttribute(sessionId.toString(), session);
        }
        return session;
    }
}
