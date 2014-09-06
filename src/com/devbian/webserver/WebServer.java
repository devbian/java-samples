package com.devbian.webserver;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
/**
 * Created by phnix on 2014/9/6.
 */
public class WebServer {
    public static final int HTTP_PORT = 8080;
    private ServerSocket serverSocket;

    public void startServer(int port) {
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("new web socket startup on " + port);
            while (true) {
                Socket socket = serverSocket.accept();
                new Processor(socket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        WebServer server = new WebServer();
        if (args.length == 1) {
            server.startServer(Integer.parseInt(args[0]));
        } else server.startServer(HTTP_PORT);
    }
}
