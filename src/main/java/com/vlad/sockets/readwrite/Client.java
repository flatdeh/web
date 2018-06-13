package com.vlad.sockets.readwrite;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        try (Scanner in = new Scanner(System.in);
             Socket client = new Socket("localhost", 3001);
             BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()))) {

            String message = in.nextLine();

            writer.write(message);
            writer.flush();

            char[] answer = new char[100];
            int count = reader.read(answer);

            System.out.println(new String(answer,0,count));
        }

    }
}
