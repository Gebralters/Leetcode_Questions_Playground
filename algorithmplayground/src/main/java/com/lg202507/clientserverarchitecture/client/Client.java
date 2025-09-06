package com.lg202507.clientserverarchitecture.client;

import java.io.File;
import java.io.IOException;
import java.net.Socket;

public class Client {
   ClientHandler clientHandler;

    public Client(String hostname, int portNumber) {
        clientHandler = new ClientHandler(hostname, portNumber);

    }

//    public javafx() {
//        File file=new File();
//        sendimagebtn(){
//            clientHandler.sendimage();
//        }
//    }
}
