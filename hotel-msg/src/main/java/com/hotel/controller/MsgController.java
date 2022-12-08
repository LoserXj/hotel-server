package com.hotel.controller;


import com.hotel.service.MsgService;
import com.hotel.service.impl.MsgServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/socket/{username}/{toUsername}")
@RestController
public class MsgController {
    //@Autowired
    private MsgService msgService=new MsgServiceImpl();

    @OnOpen
    public void onOpen(Session session, @PathParam("username")String name){
        msgService.onOpen(session,name);
    }
    @OnClose
    public void onClose(@PathParam("username")String name){
        msgService.onClose(name);
    }
    @OnMessage
    public void onMessage(String message, Session session, @PathParam("username")String username,@PathParam("toUsername")String toUsername){
        msgService.onMessage(message,session,username,toUsername);
    }
    @OnError
    public void onError(Session session,Throwable error){
        msgService.onError(session,error);
    }
}
