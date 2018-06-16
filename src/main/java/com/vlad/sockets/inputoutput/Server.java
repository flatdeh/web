package com.vlad.sockets.inputoutput;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;

public class Server {
    public static void main(String[] args) throws IOException {
        try (ServerSocket server = new ServerSocket(3000);
             Socket socket = server.accept();
             BufferedInputStream bufferedInputStream = new BufferedInputStream(socket.getInputStream());
             BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(socket.getOutputStream());) {


            byte[] message = new byte[100];
            String echo = "echo:";
            int echoLength = echo.length();

            for (int i = 0; i < echoLength; i++) {
                message[i] = (byte) echo.charAt(i);
            }

            int freeSpace = message.length - echoLength;

            while (true) {
                int count;
                while ((count = bufferedInputStream.read(message, echoLength, freeSpace)) != -1) {
                    bufferedOutputStream.write(message, 0, count + echoLength);
                    bufferedOutputStream.flush();
                }
            }
        }
    }
}
