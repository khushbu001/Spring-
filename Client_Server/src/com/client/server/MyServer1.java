package com.client.server;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServer1 {
    ServerSocket serverSocket;
    Socket socket;
    DataInputStream dataInputStream;
    DataOutputStream dataOutputStream;
    int port=9909;
    
    public MyServer1() {
        try {
            System.out.println("Server Started");
            serverSocket = new ServerSocket(port);
            socket = serverSocket.accept();
            System.out.println(socket);
            System.out.println("CLIENT CONNECTED");
            dataInputStream = new DataInputStream(socket.getInputStream());
            dataOutputStream = new DataOutputStream(socket.getOutputStream());
            ServerChat();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public static void main(String as[]) {
        new MyServer1();
    }  
    
    public void ServerChat() throws IOException {
        String str, s1;
        do {
            str = dataInputStream.readUTF();
            System.out.println("Client Message:" + str);
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            s1 = br.readLine();
            dataOutputStream.writeUTF(s1);
            dataOutputStream.flush();
            //new MyClient1(port).start();
        } while (!s1.equals("bye"));
    }
}

