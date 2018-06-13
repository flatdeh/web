package com.vlad.sockets;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        try (Scanner in = new Scanner(System.in);
             Socket client = new Socket("localhost", 3000);
             BufferedInputStream bufferedInputStream = new BufferedInputStream(client.getInputStream());
             BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(client.getOutputStream())) {

            String message = in.nextLine();

            bufferedOutputStream.write(message.getBytes());
            bufferedOutputStream.flush();

            byte[] answer = new byte[100];
            int count = bufferedInputStream.read(answer);

            System.out.println(new String(answer, 0, count));
        }

    }
}
