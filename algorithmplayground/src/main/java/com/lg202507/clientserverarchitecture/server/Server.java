package com.lg202507.clientserverarchitecture.server;

import java.io.IOException;
import java.net.ServerSocket;

public class Server {
    private ServerSocket sc;
    private boolean running=false;

    public Server(int portNum){
        try {
            sc = new ServerSocket(portNum);
            System.out.println("Connected...........");
            running=true;
        } catch (IOException e) {
            System.out.println("Server not connected.............try again");
            throw new RuntimeException(e);
        }
    }

    public void start() {
        while (running) {
            try {
                Thread t1 = new Thread(new ServerHandler(sc.accept()));
                System.out.println("Server running.............");
                t1.start();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public static void main(String[] args) {
        Server s = new Server(4001);
        s.start();
    }
}
