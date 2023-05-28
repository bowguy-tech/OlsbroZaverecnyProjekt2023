package game;

import game.Deck;
import network.ClientHandler;
import java.util.Scanner;

public class Player {
    private Deck hand = new Deck();
    private int chips;
    private int chipsInPlay;
    private String name;
    private ClientHandler ch;
    private String lastLine = "";

    private Scanner cs;//temporary

    public String[] getNextMove(int highestBid,Deck table) {
        //sends info to client
        ch.sendMessage("--------------------------------------");
        ch.sendMessage("your hand:");//temporary
        ch.sendMessage(hand.toString());//temporary
        ch.sendMessage("highest bid:");//temporary
        ch.sendMessage(String.valueOf(highestBid));//temporary
        ch.sendMessage("your bid:");//temporary
        ch.sendMessage(String.valueOf(chipsInPlay));//temporary
        ch.sendMessage("your turn:");//temporary

        ch.sendMessage("/i");

        String m;
        while (true) {
            m = ch.getMessage();
            // to teachers THIS line is useless but if I remove it the game doesn't work (I hae no idea why, but it just won't)
            System.out.print(m);
            if (!(m.equals(""))){
                ch.setMessage("");
                System.out.println(m);
                break;
            }
        }
        return (m.split("-"));
    } //temporary

    public void sendMessage(String message) {
        ch.sendMessage(message);//temporary
    }

    public Player (String name) {
        this.chips = 1000;
        this.name = name;

        this.cs = new Scanner(System.in);//temporary
    } //temporary

    public Player(ClientHandler ch) {
        this.ch = ch;
        this.chips = 1000;
        this.name = ch.getPlayerName();
    }

    public void bet(int amount) {
        this.chips -= amount;
        this.chipsInPlay += amount;
    }
    public Deck getHand() {
        return hand;
    }
    public void setHand(Deck hand) {this.hand = hand;}

    public int getChips() {
        return chips;
    }
    public void setChips(int chips) {
        this.chips = chips;
    }

    public int getChipsInPlay() {return chipsInPlay;}
    public void setChipsInPlay(int chipsInPlay) {this.chipsInPlay = chipsInPlay;}

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
