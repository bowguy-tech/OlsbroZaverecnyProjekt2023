package game;

import java.util.ArrayList;
import java.util.Collections;
public class Deck {
    ArrayList<Card> cards = new ArrayList<Card>();
    @Override
    public String toString() {
        String output = "";
        for (Card c : cards) {
            output += c.toString() + " ";
        }
        return output;
    }
    public void generate() {
        for (Card.Suit s : Card.Suit.values()) {
            for (int i = 2; i < 14; i++) {
                cards.add(new Card(s,i));
            }
        }
    }
    public void shuffle() {
        Collections.shuffle(cards);
    }
    public void sort() {
        //sorts cards
        Collections.sort(this.cards);
    }
    public Card getCard(int i) {
        return cards.get(i);
    }
    public Card takeCard() {
        return this.cards.remove(0);
    }
    public void addCard(Deck d) {
        while (d.size() > 0) {
            this.addCard(d.takeCard());
        }
    }
    public void addCard(Card c) {

        this.cards.add(this.cards.size(),c);
    }
    public int size() {
        return this.cards.size();
    }


}
