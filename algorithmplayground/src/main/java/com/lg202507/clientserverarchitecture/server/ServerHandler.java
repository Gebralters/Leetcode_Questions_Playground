package com.lg202507.clientserverarchitecture.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.StringTokenizer;

public class ServerHandler implements Runnable{
    private Socket sc;
    private boolean running=false;

    private PrintWriter pr;
    private BufferedReader br;
    private DataOutputStream dout;
    private DataInputStream din;

    public ServerHandler(Socket socket) {

        try {
            this.sc=socket;
            pr=new PrintWriter(sc.getOutputStream(),true);
            br = new BufferedReader(new InputStreamReader(sc.getInputStream()));
            dout = new DataOutputStream(new BufferedOutputStream(sc.getOutputStream()));
            din = new DataInputStream(new BufferedInputStream(sc.getInputStream()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        running=true;
    }

    @Override
    public void run() {
        while (running) {
           String response1=receiveText();
            String strarray = response1.substring(5);


            System.out.println(strarray);
            if (response1.contains("NAME")) {
              sendText("letheba");
            }
            String response2=receiveText();
            if (response2.contains("SURNAME")) {
                sendText("kaka");
            }
        }
        closeConnection();
        System.out.println("Connection Closed");
    }

    private void sendText(String message) {
        pr.println(message);
        pr.flush();
    }

    private String receiveText() {
        String response = null;
        try {
            response = br.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return response;
    }

    public void closeConnection() {
        try {
            sc.close();
            br.close();
            pr.close();
            dout.close();
            din.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
