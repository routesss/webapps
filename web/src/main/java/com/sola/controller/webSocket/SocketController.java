package com.sola.controller.webSocket;

import com.alibaba.fastjson.JSON;
import com.sola.vo.webSocketVo.WsEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

//BinaryWebSocketHandler
//TextWebSocketHandler
public class SocketController extends TextWebSocketHandler {

    private final static String wsName = "ws-name" ;
    private Map<String, WebSocketSession> sessionMap = Collections.synchronizedMap(new HashMap<String, WebSocketSession>()) ;   //记录连接的session
    private static final Logger logger =LoggerFactory.getLogger(SocketController.class) ;           //日志

    private Map<String, WebSocketSession> sessionMapNames = Collections.synchronizedMap(new HashMap<String, WebSocketSession>()) ;   //缓存name和session的对应关系 为了不遍历seeeionMap找到name对应的session

    public SocketController() {
        System.out.println("SocketController 构建");
    }

    /**
     * 收到消息时触发的回调
     */
    protected void handleTextMessage(WebSocketSession session, TextMessage message){
        try{
            String payload = message.getPayload(); //client发过来的内容

            WsEntity wsEntity = JSON.parseObject(payload, WsEntity.class);
            wsEntity.setFrom(getSessionMessage(wsName, session).toString());
            wsEntity.setWsSessions(null);
            wsEntity.setDateNow();
            sendMessage(wsEntity);

        }catch (Exception e){
            logger.error("webSocket handleTextMessage error", e.getMessage());
            e.printStackTrace();
        }
        //super.handleTextMessage(session, message);
    }

    /**
     * 断开连接后触发的回调
     */
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        logger.info("close connect success url{} id{}", session.getUri(), session.getId());
        sessionMap.remove(session.getId()) ;
        String username = getSessionMessage(wsName, session).toString() ;
        sessionMapNames.remove(username) ;//删除name和session的对应关系

        WsEntity wsEntity = new WsEntity();
        wsEntity.setFrom("system") ;
        wsEntity.setContent(username+"离开");

        for(Map.Entry<String, WebSocketSession> sessionItem : sessionMap.entrySet()){
            wsEntity.addSession(Integer.parseInt(sessionItem.getKey()), getSessionMessage(wsName, sessionItem.getValue()).toString());
        }

        sendMessage(wsEntity);

        super.afterConnectionClosed(session, status);
    }

    /**
     * 建立连接后触发的回调
     */
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        logger.info("create connect success url{} id{}", session.getUri(), session.getId());
        sessionMap.put(session.getId(), session) ;
        String username = getSessionMessage(wsName, session).toString() ;//用户标识名
        sessionMapNames.put(username, session) ;//缓存name和session的对应关系

        WsEntity wsEntity = new WsEntity();
        wsEntity.setFrom("system") ;
        wsEntity.setContent(username+"加入");
        for(Map.Entry<String, WebSocketSession> sessionItem : sessionMap.entrySet()){
            wsEntity.addSession(Integer.parseInt(sessionItem.getKey()), getSessionMessage(wsName, sessionItem.getValue()).toString());
        }

        sendMessage(wsEntity);

        super.afterConnectionEstablished(session);
    }

    /**
     * 传输消息出错时触发的回调
     */
    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
        logger.error("传输消息出错时触发的回调 {}", exception.getMessage());
        super.handleTransportError(session, exception);
    }

    /**
     * 是否处理分片消息
     */
    public boolean supportsPartialMessages() {
        return super.supportsPartialMessages();
    }


    /**
     * 发送消息
     */
    private void sendMessage(WsEntity wsEntity) throws IOException {

        if(wsEntity.getTo() == null){
            //广播
            for(WebSocketSession sessionItem : sessionMap.values()){
                TextMessage textMessage = new TextMessage(wsEntity.toJson()) ;
                sessionItem.sendMessage(textMessage);
            }
        }else{
            //发对应的session
            String[] to_names = wsEntity.getTo().split(",") ;
            for(String to_name : to_names){
                TextMessage textMessage = new TextMessage(wsEntity.toJson()) ;
                sessionMapNames.get(to_name).sendMessage(textMessage) ;
            }
        }

    }

    /**
     * 从session中获取消息
     * @param key
     * @param session
     * @return
     */
    private Object getSessionMessage(String key, WebSocketSession session){
        Map<String, Object> attributes = session.getAttributes();
        return attributes.get(key) ;
    }
}
