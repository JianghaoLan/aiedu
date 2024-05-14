package org.cvlab.aiedu.websocket;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;

public class AppWebsocketHandler extends TextWebSocketHandler {

    @Autowired
    protected ObjectMapper objectMapper;

    public <T> T readValue(String content, Class<T> valueType) {
        try {
            return objectMapper.readValue(content, valueType);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public <T> T readValue(String content, TypeReference<T> valueTypeRef) {
        try {
            return objectMapper.readValue(content, valueTypeRef);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    protected void sendMessage(WebSocketSession session, Object content) throws IOException {
        session.sendMessage(new TextMessage(objectMapper.writeValueAsString(content)));
    }

    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
    }
}