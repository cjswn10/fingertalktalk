package com.fingertalktalk.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class EchoHandler extends TextWebSocketHandler {
    private Logger logger = LoggerFactory.getLogger(EchoHandler.class);
    //다중채팅을 위해 List사용
    private List<WebSocketSession> sessionList = new ArrayList<WebSocketSession>();
    private HashMap nameMap = new HashMap();
    private String[] namelist = new String[]{"연듀","핸이","졈미니","예으니","끼끼끼"};
    private int i = 0;
    // 클라이언트 연결 이후에 실행되는 메소드
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        sessionList.add(session);
        nameMap.put(session.getId(), namelist[i]);i++;
        logger.info("{}({}) 연결됨", session.getId());
    }

    // 클라이언트가 웹소켓서버로 메시지를 전송했을 때 실행되는 메소드
    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {

        logger.info("{}로 부터 {} 받음", session.getId(), message.getPayload());

        String name="";
        //연결되어있는 모든 클라이언트들에게 메시지를 전송한다
        for(WebSocketSession sess : sessionList){
            if(message.getPayload().equals("1")){
                sess.sendMessage(new TextMessage("<b>"+nameMap.get(session.getId()) +" 접속 ><</b>"));
            }
            else {
                sess.sendMessage(new TextMessage(nameMap.get(session.getId()) + " : " + message.getPayload()));
            }
        }

    }
    /**
     * 클라이언트가 연결을 끊었을 때 실행되는 메소드
     */
    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        sessionList.remove(session);
        for(WebSocketSession sess : sessionList) {
            sess.sendMessage(new TextMessage("<b>"+nameMap.get(session.getId()) + "님이 퇴장하셨습니다.</b>" ));
        }
    }
}
