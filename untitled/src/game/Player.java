package game;

import game.Deck;

public class Player {
    private Deck hand = new Deck();
    private int chips;
    private String name;

    public Player(String name) {
        this.chips = 1000;
        this.name = name;
    }


    public int takeChips(int num) {
        this.chips -= chips;
        return num;
    }
    public Deck getHand() {
        return hand;
    }

    public void setHand(Deck hand) {
        this.hand = hand;
    }

    public int getChips() {
        return chips;
    }

    public void setChips(int chips) {
        this.chips = chips;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
