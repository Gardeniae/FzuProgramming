package com.workdatabase.websocket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.HashMap;

@Component
@ServerEndpoint("/Weixin/{openid}")
public class WebSocketServer {
    private static final Logger LOG = LoggerFactory.getLogger(WebSocketServer.class);

    /**
     * 每个客户端一个token
     */
    private String openid;

    private static HashMap<String, Session> map = new HashMap<>();

    /**
     * 连接成功
     */
    @OnOpen
    public void onOpen(Session session, @PathParam("openid") String openid) {
        map.put(openid, session);
        this.openid = openid;
        LOG.info("有新连接：token：{}，session id：{}，当前连接数：{}", openid, session.getId(), map.size());
    }

    /**
     * 连接关闭
     */
    @OnClose
    public void onClose(Session session) {
        map.remove(this.openid);
        LOG.info("连接关闭，token：{}，session id：{}！当前连接数：{}", this.openid, session.getId(), map.size());
    }

    /**
     * 收到消息
     */
    @OnMessage
    public void onMessage(String message, Session session) {
        LOG.info("收到消息：{}，内容：{}", openid, message);
    }

    /**
     * 连接错误
     */
    @OnError
    public void onError(Session session, Throwable error) {
        LOG.error("发生错误", error);
    }

    /**
     * 群发消息
     */
    public void sendInfo(String message) {
        for (String openid : map.keySet()) {
            Session session = map.get(openid);
            try {
                session.getBasicRemote().sendText(message);
            } catch (IOException e) {
                LOG.error("推送消息失败：{}，内容：{}", openid, message);
            }
            LOG.info("推送消息：{}，内容：{}", openid, message);
        }
    }

}
