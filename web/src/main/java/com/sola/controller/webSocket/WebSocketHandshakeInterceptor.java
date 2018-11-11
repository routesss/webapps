package com.sola.controller.webSocket;

import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.HandshakeInterceptor;

import java.util.Map;

/**
 * WebSocket握手请求的拦截器
 * 在握手之前执行该方法, 继续握手返回true, 中断握手返回false. 通过attributes参数设置WebSocketSession的属性
 * 在握手之后执行该方法. 无论是否握手成功都指明了响应状态码和相应头.
 */
public class WebSocketHandshakeInterceptor implements HandshakeInterceptor {

    private final static String wsName = "ws-name" ;

    @Override
    public boolean beforeHandshake(ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse, WebSocketHandler webSocketHandler, Map<String, Object> map) throws Exception {

        if(serverHttpRequest instanceof ServletServerHttpRequest){

            String flag_name = ((ServletServerHttpRequest) serverHttpRequest).getServletRequest().getParameter(wsName) ;//获取webSocket握手时传过来的参数 ws = new WebSocket("ws://localhost:8080/socket?ws-name="+$name);
            /*((ServletServerHttpRequest) serverHttpRequest).getServletRequest().getSession() ;*/ //该session时web容器的session
            map.put(wsName, flag_name) ;
        }

        return true;
    }

    @Override
    public void afterHandshake(ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse, WebSocketHandler webSocketHandler, Exception e) {

    }
}
