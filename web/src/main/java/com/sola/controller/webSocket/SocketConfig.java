package com.sola.controller.webSocket;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@Configuration
@EnableWebSocket
public class SocketConfig implements WebSocketConfigurer {

    public void registerWebSocketHandlers(WebSocketHandlerRegistry webSocketHandlerRegistry) {
        //配置有两种方式：注解和 xml 。其作用就是将 WebSocket 处理器添加到注册中心。
        webSocketHandlerRegistry.addHandler(new SocketController(), "/socket").addInterceptors(new WebSocketHandshakeInterceptor()) ;//添加WebSocketHandshakeInterceptor拦截器 处理传过来的参数 例如name
    }
}
