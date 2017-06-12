package com.jokerpeng.demo.websocketdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.drafts.Draft;
import org.java_websocket.handshake.ServerHandshake;

import java.net.URI;
import java.net.URISyntaxException;


public class MainActivity extends AppCompatActivity {
    WebSocketClient webSocketClient;
    Draft draft;
    private String address = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            webSocketClient = new WebSocketClient(new URI(address)) {
                @Override
                public void onOpen(ServerHandshake handshakedata) {
                    //连接成功
                }

                @Override
                public void onMessage(String message) {
                    //服务端消息
                }

                @Override
                public void onClose(int code, String reason, boolean remote) {
                    //连接断开，remote判定是客户端断开还是服务端断开
                    closeConnect();
                }

                @Override
                public void onError(Exception ex) {

                }
            };
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        webSocketClient.connect();
    }

    public void closeConnect(){
        webSocketClient.close();
    }
}
