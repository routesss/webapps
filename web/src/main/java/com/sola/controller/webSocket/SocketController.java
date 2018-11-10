package com.sola.controller.webSocket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

//BinaryWebSocketHandler
//TextWebSocketHandler
public class SocketController extends TextWebSocketHandler {

    private Map<String, WebSocketSession> sessionMap = Collections.synchronizedMap(new HashMap<String, WebSocketSession>()) ;   //记录连接的session
    private static final Logger logger =LoggerFactory.getLogger(SocketController.class) ;           //日志


    public SocketController() {
        System.out.println("SocketController 构建");
    }

    /**
     * 收到消息时触发的回调
     */
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        String payload = message.getPayload();
        //logger.info("web socket message {}", payload);
        //测试代码 使用后删除 -------start-------- 用于发送消息代码
        for (String key :sessionMap.keySet()){
            WebSocketSession webSocketSession = sessionMap.get(key);
            TextMessage textMessage = new TextMessage("user  " + session.getId() + " : " + payload) ;
            webSocketSession.sendMessage(textMessage);
        }
        //测试代码 使用后删除 -------end----------
        //super.handleTextMessage(session, message);
    }

    /**
     * 断开连接后触发的回调
     */
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        logger.info("close connect success url{} id{}", session.getUri(), session.getId());
        sessionMap.remove(session.getId()) ;
        super.afterConnectionClosed(session, status);
    }

    /**
     * 建立连接后触发的回调
     */
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        logger.info("create connect success url{} id{}", session.getUri(), session.getId());
        sessionMap.put(session.getId(), session) ;
        super.afterConnectionEstablished(session);
    }

    /**
     * 传输消息出错时触发的回调
     */
    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
        System.out.println("传输消息出错时触发的回调");
        super.handleTransportError(session, exception);
    }

    /**
     * 是否处理分片消息
     */
    public boolean supportsPartialMessages() {
        return super.supportsPartialMessages();
    }
}
