package network;
import java.net.*;
import java.io.*;

public class Client {

    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;

    public void connect(String ip, int port) throws IOException {
        clientSocket = new Socket(ip, port);

        out = new PrintWriter(clientSocket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

    }

    public void disconnect() throws IOException {
        out.println("disconect");
        clientSocket.close();
        in.close();
        out.close();
    }

    public String sendMove(String move) throws IOException {
        out.println(move);
        String responce = in.readLine();
        return responce;
    }
}
