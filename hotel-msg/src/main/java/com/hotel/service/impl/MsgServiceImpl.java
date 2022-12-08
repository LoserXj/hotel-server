package com.hotel.service.impl;


import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.hotel.service.MsgService;
import org.springframework.stereotype.Service;

import javax.websocket.Session;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class MsgServiceImpl implements MsgService {


    public static Map<String, Session> sessionMap = new ConcurrentHashMap<>();

    public void onOpen(Session session, String name){
        sessionMap.put(name, session);
        JSONObject result = new JSONObject();
        JSONArray array = new JSONArray();
        result.set("users", array);
        for (String key : sessionMap.keySet()) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.set("username", key);
            // {"username", "zhang", "username": "admin"}
            array.add(jsonObject);
        }
        sendAll(JSONUtil.toJsonStr(result));
    }
    public void onClose(String name){
        sessionMap.remove(name);
    }
    public void onMessage(String message,Session session,String username,String toUsername){
        Session toSession=sessionMap.get(toUsername);
        if(toSession!=null){
            JSONObject jsonObject = new JSONObject();
            jsonObject.set("text",message);
            try {
                toSession.getBasicRemote().sendText(jsonObject.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public void onError(Session session,Throwable error){
        error.printStackTrace();
    }
    public void sendAll(String msg){
        for(Session session: sessionMap.values()){
            try {
                session.getBasicRemote().sendText(msg);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
