package com.lg202507.clientserverarchitecture.client;

public class Main {
    public static void main(String[] args) {
        ClientHandler client = new ClientHandler("localhost", 4001);
        client.run();
    }
}
