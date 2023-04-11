public class Card {
    public enum Suit {
        SPADES, CLUBS, HEARTS, DIAMONDS;
    }

    Suit suit;
    int value;

    public Card(Suit s,int v) {
        this.suit = s;
        this.value = v;
    }

    public Suit getSuit(){
        return this.suit;
    }

    public int getValue() {
        return this.value;
    }

    @Override
    public String toString() {
        String output = "";

        String[] values = {"1","2","3","4","5","6","7","8","9","10","J","Q","K","A"};
        output += values[this.value];

        output += switch (this.suit) {
            case HEARTS -> "♥";
            case DIAMONDS -> "♦";
            case SPADES -> "♠";
            case CLUBS -> "♣";
            default -> "";
        };

        return output;
    }
}
