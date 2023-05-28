package network;

import java.net.*;
import java.io.*;

public class ClientHandler extends Thread{

    Socket socket;
    private PrintWriter out;
    private BufferedReader in;
    private String message = "";
    private String name = "name";

    public ClientHandler(Socket socket) {
        this.socket = socket;
    }
    @Override
    public void run(){
        try {
            out = new PrintWriter(socket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                if (inputLine.charAt(0) == '/') {
                    if (inputLine.split("-")[0].equals("/n")) {name = inputLine.split("-")[1];}
                } else {
                    message = inputLine;
                }

            }

            System.out.println("client disconnected");
            out.println("disconnect");
            in.close();
            out.close();
            socket.close();
        } catch (Exception e) {

        }
    }

    public void disconnect() {
        out.println("/d");
    }
    public void sendMessage(String message) {
        out.println(message);
    }

    public String getPlayerName() {
        return name;
    }

    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
}
