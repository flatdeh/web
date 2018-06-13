package com.vlad.sockets.inputoutput;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        try (ServerSocket server = new ServerSocket(3000);
             Socket socket = server.accept();
             BufferedInputStream bufferedInputStream = new BufferedInputStream(socket.getInputStream());
             BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(socket.getOutputStream());) {


            byte[] message = new byte[100];
            byte[] echo = "echo:".getBytes();

            int count = bufferedInputStream.read(message, echo.length, message.length - echo.length);

            System.arraycopy(echo, 0, message, 0, echo.length);

            bufferedOutputStream.write(message, 0, count + echo.length);
        }

    }
}
