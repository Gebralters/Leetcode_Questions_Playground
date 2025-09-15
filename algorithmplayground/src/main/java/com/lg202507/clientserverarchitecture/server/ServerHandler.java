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
            if (response1.equals("image")) {
                sendText("200 OK");

                String fileSize=receiveText();
                System.out.println(response1);
                int fileint= Integer.parseInt(fileSize);
                System.out.println("File size received filesize:"+fileint);
                try {
                    receiveData(fileint);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("file received");
            }
            sendText("OK");
            running=false;
        }
        closeConnection();
        System.out.println("Connection Closed");
    }

    private void receiveData(int fileSize) throws IOException {
        File fileToDownLoad = new File("src/main/resource/server/letheba.png");
        FileOutputStream fos = new FileOutputStream(fileToDownLoad); //to write the incoming data to disk
        byte[] buffer = new byte[1024];
        int n=0;
        int totalbytes = 0;
        while(totalbytes!=fileSize)
        {
            n= din.read(buffer,0, buffer.length);
            fos.write(buffer,0,n);
            fos.flush();
            totalbytes+=n;
        }
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
