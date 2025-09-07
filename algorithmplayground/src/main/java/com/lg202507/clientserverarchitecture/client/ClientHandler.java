package com.lg202507.clientserverarchitecture.client;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

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

    public void run() throws IOException {
        while (running) {
            System.out.println("Please enter 'image' if you want to send the image to the server");
            Scanner sc = new Scanner(System.in);
            String prompt=sc.nextLine();
            sendText(prompt);
            String response=receiveText();
            System.out.println(response);

            if (response.contains("200 OK")) {
                System.out.println("Sending the file");
               File file=new File("src/main/resource/client/letheba.png");
                System.out.println(file.exists());
                if (file.exists()) {
                    System.out.println("file in being sent name:"+file.getName());
                    sendText(String.valueOf(file.length()));
                    sendfile(file);
                }
            }
            System.out.println("file sent");

            String response2=receiveText();
            if (response2.equals("OK")) {
                running=false;
            }
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
   public void sendfile(File image) throws IOException {
       FileInputStream fis = new FileInputStream(image);
       byte[] buffer = new byte[2048];
       int n = 0;
       while((n = fis.read(buffer))>0)
       {
           dout.write(buffer,0,n);
           dout.flush();
       }
       fis.close();

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