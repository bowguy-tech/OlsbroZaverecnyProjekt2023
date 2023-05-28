package network;

import game.Game;
import game.Player;

import java.net.*;
import java.io.*;
import java.util.*;

public class Server {

    ArrayList<ClientHandler> clients = new ArrayList<ClientHandler>();
    private ServerSocket serverSocket;
    private Game game = new Game();
    private Thread checkConnection;
    private boolean playing = false;
    Scanner sc = new Scanner(System.in);

    //starts the server
    public void start(int port) throws IOException {
        serverSocket = new ServerSocket(port);

        checkConnection = new Thread(() -> {while(true) {
            try {
                ClientHandler ch = new ClientHandler(serverSocket.accept());
                    ch.start();
                    clients.add(ch);
                    Player newPlayer = new Player(ch);
                    while (true) {
                        if (newPlayer.getName().equals("name")) {
                            newPlayer = new Player(ch);
                        } else {
                            break;
                        }
                    }
                    game.addPlayer(newPlayer);

                    System.out.println(newPlayer.getName() + " has joined");

            } catch (Exception e) {

            }
        }});
        checkConnection.start();

        while(true) {
            System.out.print("");//IDK why but this won't work without this here
            if ((clients.size() >= 3)){
                System.out.println("enough players have joined you can start the game (type \"start\"):");
                if (sc.next().equals("start")) {
                    startGame();
                    playing = true;

                }
            }
        }

    }

    //starts the game
    public void startGame() {
        System.out.println("game has started");
       game.start();
    }

    public void stop() throws IOException {
        checkConnection.interrupt();
        serverSocket.close();
    }

}

