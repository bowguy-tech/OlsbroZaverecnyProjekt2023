package network;
import java.net.*;
import java.io.*;
import java.util.Scanner;

public class Client {

    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;
    private Thread incomming;
    private String message = "";
    private String name;
    Scanner cs = new Scanner(System.in);

    public void connect(String ip, int port) throws IOException {
        clientSocket = new Socket(ip, port);

        out = new PrintWriter(clientSocket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        out.println("/n-" + name);
        incomming = new Thread(() -> {try {
            String inputLine;
            while ((inputLine = in.readLine()) != null) {

                if (inputLine.charAt(0) == '/' && inputLine != "/d") {
                    if (inputLine.equals("/i")) {
                        //requesting input command
                            System.out.println("next move:");
                            String command;
                            while(true) {
                                command = cs.next();
                                boolean chosen = false;

                                switch(command.split("-")[0]) {
                                    case "check":
                                        chosen = true;
                                        break;

                                    case "raise":
                                        try {
                                            if (Integer.valueOf(command.split("-")[1]) > 0) {
                                                chosen = true;
                                            }
                                        } catch (Exception e) {
                                            System.out.println("value must be an integer larger than 0");
                                        }

                                        break;

                                    case "fold":
                                        chosen = true;
                                        break;
                                }
                                if (chosen) {
                                    break;
                                }
                                System.out.println("unknown command(instead of spaces use \"-\")");
                            }
                            out.println(command);
                            break;
                    }
                } else {
                    System.out.println(inputLine);
                }

                //disconnect command

            }
        } catch (IOException e) {
            e.printStackTrace();
        }});
        incomming.start();
    }

    public void sendMessage(String message) throws IOException {

        out.println(message);
    }
    public String getMessage() {
        return message;
    }
    public void setName(String name){this.name = name;}

}
