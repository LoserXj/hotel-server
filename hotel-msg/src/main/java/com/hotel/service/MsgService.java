package com.hotel.service;


import javax.websocket.Session;

public interface MsgService {
    void onOpen(Session session, String name);
    void onClose(String name);
    void onMessage(String message,Session session,String username,String toUsername);
    void onError(Session session,Throwable error);
    void sendAll(String msg);
}
