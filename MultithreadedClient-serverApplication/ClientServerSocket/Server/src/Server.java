import PhoneTransfer.Phone;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketOption;

public class Server {
    public static void main(String[] args) {
        while(true)
            try (
                ServerSocket server = new ServerSocket(8000);
                Phone phone = new Phone(server);
        ) {
            String request = phone.readLine();
            System.out.println("Request: " +  request +" , LENGTH: " + request.length());
            System.out.println("Server started");
            System.out.println("Client connected");
            phone.writeLine("HELLO FROM SERVER: " + request.length());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}