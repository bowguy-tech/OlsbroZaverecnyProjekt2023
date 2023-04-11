import java.util.ArrayList;
import java.util.Collections;
public class Deck {
    ArrayList<Card> cards = new ArrayList<Card>();

    public Deck() {
        for (Card.Suit s : Card.Suit.values()) {
            for (int i = 1; i < 14; i++) {
                cards.add(new Card(s,i));
            }
        }
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public Card getCard(int i) {
        return cards.get(i);
    }

}
