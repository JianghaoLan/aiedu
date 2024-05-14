package org.cvlab.aiedu.websocket;

import lombok.extern.slf4j.Slf4j;
import org.cvlab.aiedu.vo.AudioStreamRespVo;
import org.cvlab.aiedu.vo.AudioStreamVo;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import java.io.IOException;
import java.util.Arrays;

@Component
@Slf4j
public class AudioStreamHandler extends AppWebsocketHandler {
    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage message) throws IOException {
        String payload = message.getPayload();
        AudioStreamVo streamVo = readValue(payload, AudioStreamVo.class);

        resolve(session, streamVo);

    }

    private void resolve(WebSocketSession session, AudioStreamVo streamVo) throws IOException {
        if (streamVo.getSignal() != null) {
            if (streamVo.getSignal().equals("end")) {
                AudioStreamRespVo respVo = new AudioStreamRespVo();
                respVo.setSignal("server_finish");
                sendMessage(session, respVo);
                session.close();
                log.info("User audio stream closed.");
            } else if (streamVo.getSignal().equals("start")) {
                log.info("User audio stream started.");
                AudioStreamRespVo respVo = new AudioStreamRespVo();
                respVo.setSignal("server_ready");
                sendMessage(session, respVo);
            } else {
                log.error("Error in user audio message: Unrecognized signal field({}).", streamVo.getSignal());
                session.close(CloseStatus.BAD_DATA);
            }
            return;
        }
        if (streamVo.getData() != null) {
            System.out.println(Arrays.toString(streamVo.getData()));
        }
    }
}
