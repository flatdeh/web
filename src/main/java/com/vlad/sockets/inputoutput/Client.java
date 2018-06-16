package com.vlad.sockets.inputoutput;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        try (Scanner in = new Scanner(System.in);
             Socket client = new Socket("localhost", 3000);
             BufferedInputStream bufferedInputStream = new BufferedInputStream(client.getInputStream());
             BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(client.getOutputStream())) {

            byte[] answer = new byte[100];

            while (true) {
                String message = in.nextLine();
                bufferedOutputStream.write(message.getBytes());
                bufferedOutputStream.flush();
                System.out.println("Write-> " + message);
                bufferedOutputStream.flush();

                int count;
                count = bufferedInputStream.read(answer);
                System.out.println(new String(answer, 0, count));
            }

        }
    }
}
