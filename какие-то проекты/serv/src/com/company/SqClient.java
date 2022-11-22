package com.company;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class SqClient {
    public static void main(String[] args) throws IOException {
        int fuf = 0;
        try(Socket socket = new Socket("LAPTOP-A5I4C8BV", 1020)){
            fuf++;
            OutputStream outputStream = socket.getOutputStream();
            outputStream.write(fuf);
            outputStream.flush();

            InputStream inputStream = socket.getInputStream();

            while(fuf < 10){
                int response = inputStream.read();
                System.out.println(response);
            }

        }
    }
}