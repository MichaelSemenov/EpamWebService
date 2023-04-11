import PhoneTransfer.Phone;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
    public static void main(String[] args)
    {
        try(
            Phone phone = new Phone("127.0.0.1", 8000);) {
            System.out.println("Connected to server!");
            String request = "Visaginas";
            phone.writeLine(request);
            System.out.println("Request: " + request);
            String response = String.valueOf(Math.random()*30 -10);
            System.out.println("Response: " + response);
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
