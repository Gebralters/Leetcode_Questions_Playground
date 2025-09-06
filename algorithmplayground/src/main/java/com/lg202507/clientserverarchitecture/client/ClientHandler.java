package com.lg202507.clientserverarchitecture.client;

import java.io.*;
import java.net.Socket;

public class ClientHandler {
    private Socket sc=null;
    private boolean running = false;

    private PrintWriter pr=null;
    private BufferedReader br=null;
    private DataOutputStream dout=null;
    private DataInputStream din=null;

    public ClientHandler(String hostname, int portNum) {
        try {
            this.sc = new Socket(hostname, portNum);
            this.running=true;
            this.pr = new PrintWriter(sc.getOutputStream(),true);
            this.br = new BufferedReader(new InputStreamReader(sc.getInputStream()));
            this.dout = new DataOutputStream(new BufferedOutputStream(sc.getOutputStream()));
            this.din = new DataInputStream(new BufferedInputStream(sc.getInputStream()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void run() {
        while (running) {


            sendText("NAME/200");
            String response1=receiveText();
            System.out.println(response1);
            sendText("SURNAME");
            String response2=receiveText();
            System.out.println(response2);
            running=false;
        }
        closeConnection();
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

    //    public void sendimage(File file) {
//        sendfile(file);
//    }
//
//
//    public void sendPdf(File file) {
//        sendfile(file);
//    }
//   public void sendfile(File image) {
//       fos = new FileOutputStream(image); //to write the incoming data to disk
//       byte[] buffer = new byte[1024];
//       int n=0;
//       int totalbytes = 0;
//       while(totalbytes!=fileSize)
//       {
//           n= din.read(buffer,0, buffer.length);
//           fos.write(buffer,0,n);
//           fos.flush();
//           totalbytes+=n;
//       }
//
//   }
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