package Massage.massage;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

public class ServerMain {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(12345);
        System.out.println("Server Started...");
        System.out.println(InetAddress.getLocalHost());
        HashMap<String, Information> clientList = new HashMap<String, Information>();

        while (true) {
            Socket socket = serverSocket.accept();
            NetworkConnection nc = new NetworkConnection(socket);

            new Thread(new CreateConnection(clientList, nc)).start();

        }

    }
}