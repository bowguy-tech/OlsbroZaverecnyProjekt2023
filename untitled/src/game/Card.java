package game;

public class Card implements Comparable<Card> {
    @Override
    public int compareTo(Card that) {
        if (this.value > that.value) {
            return 1;
        } else if (this.value < that.value) {
            return -1;
        } else {
            return 0;
        }
    }

    public enum Suit {
        SPADES, CLUBS, HEARTS, DIAMONDS;
    }
    Suit suit;
    int value;
    static String[] values = {"0","1","2","3","4","5","6","7","8","9","10","J","Q","K","A"};

    public Card(Suit s,int v) {
        this.suit = s;
        this.value = v;
    }

    public static String valueToString(int v) {
        return values[v];
    }
    @Override
    public String toString() {
        String output = "";
        output += values[this.value];

        output += switch (this.suit) {
            case HEARTS -> "♥";
            case DIAMONDS -> "♦";
            case SPADES -> "♠";
            case CLUBS -> "♣";
        };

        return output;
    }
    public Suit getSuit(){
        return this.suit;
    }

    public int getValue() {
        return this.value;
    }
}
