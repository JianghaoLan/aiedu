package org.cvlab.aiedu.config;

import org.cvlab.aiedu.websocket.AppWebsocketHandler;
import org.cvlab.aiedu.websocket.AudioStreamHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import org.springframework.web.socket.server.standard.ServletServerContainerFactoryBean;
import org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor;

@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {

    private final AudioStreamHandler audioHandler;

    WebSocketConfig(AudioStreamHandler audioHandler) {
        this.audioHandler = audioHandler;
    }

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(audioHandler, "/audio/stream")
                .addInterceptors(new HttpSessionHandshakeInterceptor())
                .setAllowedOrigins("*");
    }

    @Bean
    public ServletServerContainerFactoryBean createWebSocketContainer() {
        ServletServerContainerFactoryBean container = new ServletServerContainerFactoryBean();
        // ws 传输数据的时候，数据过大有时候会接收不到，所以在此处设置bufferSize
        container.setMaxTextMessageBufferSize(32768 * 4);
        container.setMaxBinaryMessageBufferSize(32768 * 4);
        container.setMaxSessionIdleTimeout(20000L);
        return container;
    }
}
