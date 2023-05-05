package network;

import java.net.*;
import java.io.*;
import java.util.*;
public class Server {

    private ServerSocket serverSocket;

    private ArrayList<ClientHandler> conections = new ArrayList<ClientHandler>();
    private int MAX_PLAYERS = 6;

    public Server() {

    }

    public void start(int port) throws IOException {

        /*
        * finds the public ip address
        * copied from: https://www.baeldung.com/java-get-ip-address
         */
        String ip;

        URL url = new URL("http://checkip.amazonaws.com/");
        try (BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()))) {
            ip = br.readLine();
        }

        serverSocket = new ServerSocket(port);
        /*
        * m
         */
        while (true) {

            ClientHandler ch = new ClientHandler(serverSocket.accept());

            if(this.conections.size() < this.MAX_PLAYERS) {
                System.out.println("player has conected");
                this.conections.add(ch);

                ch.start();
            } else {
                System.out.println("server is full");
            }
        }

    }

    public void stop() throws IOException {
        serverSocket.close();
    }
}
