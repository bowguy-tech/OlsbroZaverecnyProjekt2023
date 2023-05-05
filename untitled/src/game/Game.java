package game;

import game.Deck;
import java.util.ArrayList;

public class Game {
    private ArrayList<Player> players;
    private int[] bets;
    private Deck deck = new Deck();
    private Deck table = new Deck();
    private int smallblind;
    private int index = 0;

    public Game(int smallBlind) {
        this.smallblind = smallBlind;

        this.deck.generate();
        this.deck.shuffle();
    }

    void start() {

        bets = new int[players.size()];
        for (int i = 0; i < players.size(); i++){ bets[i] = 0;}
        for (int i = 0; i < 3; i++) {table.addCard(deck.takeCard());}

        bets[index] += smallblind;
        index++;
        bets[index] += smallblind * 2;
        index++;

    }

    void next() {
    }

    void end() {

        for(int i = 0; i < players.size(); i++) {
            if (this.players.get(i).getChips() < 2 * this.smallblind){
                players.remove(i);
                System.out.println(players.get(i).getName() + " removed due to not enough chips");
            }
        }

    }

    public void addPlayer(Player p) {
        players.add(p);
    }

    void removePlayer(int index) {
        players.remove(index);
    }



}
