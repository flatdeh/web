package com.vlad.sockets.readwrite;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        try (Scanner in = new Scanner(System.in);
             Socket client = new Socket("localhost", 3000);
             BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()))) {

            while(true){
                String message = in.nextLine();
                writer.write(message+"\n");
                writer.flush();
                System.out.println(reader.readLine());
            }
        }

    }
}
