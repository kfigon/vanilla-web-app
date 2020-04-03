package pl.kamil.websocket;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;



//constant connection over TCP (not http)
// available to send data (duplex)

@ServerEndpoint("/mysocket")
public class MyWebSocket {


    static Session session;

    @OnClose
    public void close(Session session){
        this.session = null;
    }

    @OnOpen
    public void open(Session session){
        this.session = session; // save reference
    }

//    client -> server
    @OnMessage
    public void handleMessage(String message, Session session) {

    }
}
