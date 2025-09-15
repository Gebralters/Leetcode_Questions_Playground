package com.lg202507.clientserverarchitecture.client;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        ClientHandler client = new ClientHandler("localhost", 4001);
        try {
            client.run();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
