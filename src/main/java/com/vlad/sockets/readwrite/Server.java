package com.vlad.sockets.readwrite;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        try (ServerSocket server = new ServerSocket(3001);
             Socket socket = server.accept();
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
             BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            char[] message = new char[100];
            char[] echo = "echo:".toCharArray();

            int count = reader.read(message, echo.length, message.length - echo.length);

            System.arraycopy(echo, 0, message, 0, echo.length);

            writer.write(message, 0, count + echo.length);
            writer.flush();
        }

    }
}
