package Tests;

import game.Card;
import game.Comparison;
import game.Deck;
import game.Player;

import static org.junit.jupiter.api.Assertions.*;

//nemam hodne veci co testovat tak
class ComparisonTest {

    @org.junit.jupiter.api.Test
    void compareTo1() {
        //setup
        Deck d1 = new Deck();
        Deck d2 = new Deck();

        d1.addCard(new Card(Card.Suit.CLUBS,8));
        d1.addCard(new Card(Card.Suit.CLUBS,11));
        d1.addCard(new Card(Card.Suit.DIAMONDS,12));
        d1.addCard(new Card(Card.Suit.CLUBS,9));
        d1.addCard(new Card(Card.Suit.CLUBS,7));
        d1.addCard(new Card(Card.Suit.CLUBS,10));
        d1.addCard(new Card(Card.Suit.CLUBS,7));

        d2.addCard(new Card(Card.Suit.HEARTS,7));
        d2.addCard(new Card(Card.Suit.SPADES,4));
        d2.addCard(new Card(Card.Suit.HEARTS,4));
        d2.addCard(new Card(Card.Suit.CLUBS,7));
        d2.addCard(new Card(Card.Suit.SPADES,7));
        d2.addCard(new Card(Card.Suit.DIAMONDS,8));
        d2.addCard(new Card(Card.Suit.DIAMONDS,7));

        Comparison c1 = new Comparison(d1,new Player("tom"));
        Comparison c2 = new Comparison(d2,new Player("joe"));

        //test
        int result = c1.compareTo(c2);

        //result
        assertEquals(-1, result);
    }

    @org.junit.jupiter.api.Test
    void compareTo2() {
        //setup
        Deck d1 = new Deck();
        Deck d2 = new Deck();

        d1.addCard(new Card(Card.Suit.CLUBS,5));
        d1.addCard(new Card(Card.Suit.CLUBS,11));
        d1.addCard(new Card(Card.Suit.DIAMONDS,12));
        d1.addCard(new Card(Card.Suit.CLUBS,6));
        d1.addCard(new Card(Card.Suit.DIAMONDS,6));
        d1.addCard(new Card(Card.Suit.CLUBS,10));
        d1.addCard(new Card(Card.Suit.HEARTS,4));

        d2.addCard(new Card(Card.Suit.HEARTS,7));
        d2.addCard(new Card(Card.Suit.SPADES,6));
        d2.addCard(new Card(Card.Suit.HEARTS,4));
        d2.addCard(new Card(Card.Suit.CLUBS,6));
        d2.addCard(new Card(Card.Suit.SPADES,7));
        d2.addCard(new Card(Card.Suit.SPADES,12));
        d2.addCard(new Card(Card.Suit.DIAMONDS,8));

        Comparison c1 = new Comparison(d1,new Player("tom"));
        Comparison c2 = new Comparison(d2,new Player("joe"));

        //test
        int result = c1.compareTo(c2);

        //result
        assertEquals(1, result);
    }

    @org.junit.jupiter.api.Test
    void compareTo3() {
        //setup
        Deck d1 = new Deck();
        Deck d2 = new Deck();

        d1.addCard(new Card(Card.Suit.CLUBS,5));
        d1.addCard(new Card(Card.Suit.CLUBS,11));
        d1.addCard(new Card(Card.Suit.CLUBS,12));
        d1.addCard(new Card(Card.Suit.CLUBS,6));
        d1.addCard(new Card(Card.Suit.CLUBS,6));
        d1.addCard(new Card(Card.Suit.CLUBS,10));
        d1.addCard(new Card(Card.Suit.CLUBS,4));

        d2.addCard(new Card(Card.Suit.HEARTS,7));
        d2.addCard(new Card(Card.Suit.HEARTS,6));
        d2.addCard(new Card(Card.Suit.HEARTS,4));
        d2.addCard(new Card(Card.Suit.HEARTS,6));
            d2.addCard(new Card(Card.Suit.HEARTS,7));
        d2.addCard(new Card(Card.Suit.HEARTS,12));
        d2.addCard(new Card(Card.Suit.HEARTS,8));

        Comparison c1 = new Comparison(d1,new Player("tom"));
        Comparison c2 = new Comparison(d2,new Player("joe"));

        //test
        int result = c1.compareTo(c2);

        //result
        assertEquals(-1, result);
    }
    @org.junit.jupiter.api.Test
    void compareTo4() {
        //setup
        Deck d1 = new Deck();
        Deck d2 = new Deck();

        d1.addCard(new Card(Card.Suit.HEARTS,5));
        d1.addCard(new Card(Card.Suit.SPADES,9));
        d1.addCard(new Card(Card.Suit.HEARTS,12));
        d1.addCard(new Card(Card.Suit.CLUBS,8));
        d1.addCard(new Card(Card.Suit.CLUBS,8));
        d1.addCard(new Card(Card.Suit.HEARTS,9));
        d1.addCard(new Card(Card.Suit.CLUBS,4));

        d2.addCard(new Card(Card.Suit.DIAMONDS,7));
        d2.addCard(new Card(Card.Suit.HEARTS,10));
        d2.addCard(new Card(Card.Suit.SPADES,10));
        d2.addCard(new Card(Card.Suit.DIAMONDS,6));
        d2.addCard(new Card(Card.Suit.DIAMONDS,7));
        d2.addCard(new Card(Card.Suit.DIAMONDS,10));
        d2.addCard(new Card(Card.Suit.HEARTS,10));

        Comparison c1 = new Comparison(d1,new Player("tom"));
        Comparison c2 = new Comparison(d2,new Player("joe"));

        //test
        int result = c1.compareTo(c2);

        //result
        assertEquals(1, result);
    }

    @org.junit.jupiter.api.Test
    void compareTo5() {
        //setup
        Deck d1 = new Deck();
        Deck d2 = new Deck();

        d1.addCard(new Card(Card.Suit.HEARTS,5));
        d1.addCard(new Card(Card.Suit.SPADES,7));
        d1.addCard(new Card(Card.Suit.HEARTS,4));
        d1.addCard(new Card(Card.Suit.HEARTS,8));
        d1.addCard(new Card(Card.Suit.DIAMONDS,8));
        d1.addCard(new Card(Card.Suit.HEARTS,6));
        d1.addCard(new Card(Card.Suit.DIAMONDS,6));

        d2.addCard(new Card(Card.Suit.DIAMONDS,7));
        d2.addCard(new Card(Card.Suit.HEARTS,10));
        d2.addCard(new Card(Card.Suit.SPADES,10));
        d2.addCard(new Card(Card.Suit.DIAMONDS,6));
        d2.addCard(new Card(Card.Suit.DIAMONDS,7));
        d2.addCard(new Card(Card.Suit.DIAMONDS,9));
        d2.addCard(new Card(Card.Suit.HEARTS,4));

        Comparison c1 = new Comparison(d1,new Player("tom"));
        Comparison c2 = new Comparison(d2,new Player("joe"));

        //test
        int result = c1.compareTo(c2);

        //result
        assertEquals(-1, result);
    }

    @org.junit.jupiter.api.Test
    void compareTo6() {
        //setup
        Deck d1 = new Deck();
        Deck d2 = new Deck();

        d1.addCard(new Card(Card.Suit.HEARTS,5));
        d1.addCard(new Card(Card.Suit.SPADES,7));
        d1.addCard(new Card(Card.Suit.HEARTS,4));
        d1.addCard(new Card(Card.Suit.HEARTS,8));
        d1.addCard(new Card(Card.Suit.DIAMONDS,8));
        d1.addCard(new Card(Card.Suit.HEARTS,6));
        d1.addCard(new Card(Card.Suit.DIAMONDS,6));

        d2.addCard(new Card(Card.Suit.HEARTS,5));
        d2.addCard(new Card(Card.Suit.SPADES,7));
        d2.addCard(new Card(Card.Suit.HEARTS,4));
        d2.addCard(new Card(Card.Suit.HEARTS,8));
        d2.addCard(new Card(Card.Suit.DIAMONDS,8));
        d2.addCard(new Card(Card.Suit.HEARTS,6));
        d2.addCard(new Card(Card.Suit.DIAMONDS,6));

        Comparison c1 = new Comparison(d1,new Player("tom"));
        Comparison c2 = new Comparison(d2,new Player("joe"));

        //test
        int result = c1.compareTo(c2);

        //result
        assertEquals(0, result);
    }

    @org.junit.jupiter.api.Test
    void compareTo7() {
        //setup
        Deck d1 = new Deck();
        Deck d2 = new Deck();

        d1.addCard(new Card(Card.Suit.HEARTS,2));
        d1.addCard(new Card(Card.Suit.SPADES,4));
        d1.addCard(new Card(Card.Suit.HEARTS,6));
        d1.addCard(new Card(Card.Suit.HEARTS,8));
        d1.addCard(new Card(Card.Suit.DIAMONDS,10));
        d1.addCard(new Card(Card.Suit.HEARTS,12));
        d1.addCard(new Card(Card.Suit.DIAMONDS,7));

        d2.addCard(new Card(Card.Suit.HEARTS,13));
        d2.addCard(new Card(Card.Suit.SPADES,12));
        d2.addCard(new Card(Card.Suit.HEARTS,11));
        d2.addCard(new Card(Card.Suit.HEARTS,10));
        d2.addCard(new Card(Card.Suit.DIAMONDS,8));
        d2.addCard(new Card(Card.Suit.HEARTS,6));
        d2.addCard(new Card(Card.Suit.DIAMONDS,4));

        Comparison c1 = new Comparison(d1,new Player("tom"));
        Comparison c2 = new Comparison(d2,new Player("joe"));

        //test
        int result = c1.compareTo(c2);

        //result
        assertEquals(1, result);
    }

    @org.junit.jupiter.api.Test
    void compareTo8() {
        //setup
        Deck d1 = new Deck();
        Deck d2 = new Deck();

        d1.addCard(new Card(Card.Suit.HEARTS,2));
        d1.addCard(new Card(Card.Suit.SPADES,3));
        d1.addCard(new Card(Card.Suit.SPADES,3));
        d1.addCard(new Card(Card.Suit.DIAMONDS,8));
        d1.addCard(new Card(Card.Suit.DIAMONDS,10));
        d1.addCard(new Card(Card.Suit.HEARTS,12));
        d1.addCard(new Card(Card.Suit.DIAMONDS,12));

        d2.addCard(new Card(Card.Suit.HEARTS,13));
        d2.addCard(new Card(Card.Suit.SPADES,12));
        d2.addCard(new Card(Card.Suit.HEARTS,12));
        d2.addCard(new Card(Card.Suit.HEARTS,10));
        d2.addCard(new Card(Card.Suit.DIAMONDS,8));
        d2.addCard(new Card(Card.Suit.HEARTS,6));
        d2.addCard(new Card(Card.Suit.DIAMONDS,10));

        Comparison c1 = new Comparison(d1,new Player("tom"));
        Comparison c2 = new Comparison(d2,new Player("joe"));

        //test
        int result = c1.compareTo(c2);

        //result
        assertEquals(1, result);
    }
}