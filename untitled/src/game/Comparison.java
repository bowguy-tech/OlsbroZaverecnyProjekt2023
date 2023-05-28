package game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
/*
* this part of the code was copied from
* https://www.codeproject.com/Articles/38821/Make-a-poker-hand-evalutator-in-Java
 */
public class Comparison implements Comparable<Comparison> {
    private Card[] cards;
    private int[] value;

    private Player player;

    public Comparison (Deck d,Player p)
    {
        player = p;
        d.sort();
        value = new int[8];
        cards = new Card[7];
        for (int x=0; x<7; x++)
        {
            cards[x] = d.getCard(x);
        }

        int[] ranks = new int[14];
        //miscellaneous cards that are not otherwise significant
        int[] orderedRanks = new int[7];
        boolean flush=false, straight=false, straightFlush=false;
        int sameCards=1,sameCards2=1;
        int largeGroupRank=0,smallGroupRank=0;
        int index=0;
        int topStraightValue=0;

        for (int x=0; x<14; x++)
        {
            ranks[x]=0;
        }
        for (int x=0; x<7; x++)
        {
            ranks[ cards[x].getValue() ]++;
        }



        for (int x=13; x>=1; x--)
        {
            if (ranks[x] > sameCards)
            {
                if (sameCards != 1)
                //if sameCards was not the default value
                {
                    sameCards2 = sameCards;
                    smallGroupRank = largeGroupRank;
                }

                sameCards = ranks[x];
                largeGroupRank = x;

            } else if (ranks[x] > sameCards2)
            {
                sameCards2 = ranks[x];
                smallGroupRank = x;
            }
        }


        for (int x=13; x>=1; x--)
        {
            if (ranks[x]==1)
            {
                orderedRanks[index]=x;
                index++;
            }
        }



        //straight
        int lastNum = cards[0].getValue();
        int numberInARow = 1;
        for (int x=0; x<7; x++) {
            if (cards[x].getValue() == lastNum + 1){
                numberInARow++;
                lastNum = cards[x].getValue();
            } else if (cards[x].getValue() == lastNum) {
                lastNum = cards[x].getValue();
            } else {
                lastNum = cards[x].getValue();
                numberInARow = 1;
            }

            if (numberInARow > 4) {
                straight = true;
                topStraightValue = cards[x].getValue();
            }
        }

        //flush
        Card.Suit color = null;
        int[] suitNum = new int[4];
        for (int x=0; x<7; x++) {
            switch (cards[x].suit){
                case SPADES -> suitNum[0]++;
                case CLUBS -> suitNum[1]++;
                case HEARTS -> suitNum[2]++;
                case DIAMONDS -> suitNum[3]++;
            }
        }
        for (int x =0; x < 4; x++) {
            if (suitNum[x] > 4) {
                flush = true;
                Card.Suit[] colors = {Card.Suit.SPADES,Card.Suit.CLUBS,Card.Suit.HEARTS,Card.Suit.DIAMONDS};
                color = colors[x];
            }
        }

        //straightflush(royal flush)
        if (straight && flush) {
            for (int x=0; x<7; x++) {
                if (cards[x].getSuit() == color) {
                    if (cards[x].getValue() == lastNum + 1) {
                        numberInARow++;
                        lastNum = cards[x].getValue();
                    } else if (cards[x].getValue() == lastNum) {
                        lastNum = cards[x].getValue();
                    } else {
                        lastNum = cards[x].getValue();
                        numberInARow = 1;
                    }

                    if (numberInARow > 4) {
                        straightFlush = true;
                        topStraightValue = cards[x].getValue();
                    }
                }
            }
        }

        //start hand evaluation
        if ( sameCards==1 ) {
            value[0]=1;
            value[1]=orderedRanks[0];
            value[2]=orderedRanks[1];
            value[3]=orderedRanks[2];
            value[4]=orderedRanks[3];
            value[5]=orderedRanks[4];
            value[6]=orderedRanks[5];
            value[7]=orderedRanks[6];
        }

        if (sameCards==2 && sameCards2==1)
        {
            value[0]=2;
            value[1]=largeGroupRank; //rank of pair
            value[2]=orderedRanks[0];
            value[3]=orderedRanks[1];
            value[4]=orderedRanks[2];
            value[5]=orderedRanks[4];
            value[6]=orderedRanks[5];

        }

        if (sameCards==2 && sameCards2==2) //two pair
        {
            value[0]=3;
            //rank of greater pair
            value[1]= Math.max(largeGroupRank, smallGroupRank);
            value[2]= Math.min(largeGroupRank, smallGroupRank);
            value[3]=orderedRanks[0];
            value[4]=orderedRanks[1];
            value[5]=orderedRanks[2];
        }

        if (sameCards==3 && sameCards2!=2)
        {
            value[0]=4;
            value[1]= largeGroupRank;
            value[2]=orderedRanks[0];
            value[3]=orderedRanks[1];
            value[4]=orderedRanks[2];
            value[5]=orderedRanks[3];
        }

        if (straight) {
            value[0] = 6;
            value[1] = orderedRanks[0]; //tie determined by ranks of cards
            value[2] = orderedRanks[1];
            value[3] = orderedRanks[2];
            value[4] = orderedRanks[3];
            value[5] = orderedRanks[4];
            value[6] = orderedRanks[5];
            value[7] = orderedRanks[6];
        }

        if (flush) {
            value[0]=5;
            value[1]=topStraightValue;
            value[2]=orderedRanks[1];
            value[3]=orderedRanks[2];
            value[4]=orderedRanks[3];
            value[5]=orderedRanks[4];
            value[6]=orderedRanks[5];
            value[7]=orderedRanks[6];

        }

        if (sameCards==3 && sameCards2==2)
        {
            value[0]=7;
            value[1]=largeGroupRank;
            value[2]=smallGroupRank;
            value[3]=orderedRanks[0];
            value[4]=orderedRanks[1];
        }

        if (sameCards==4)
        {
            value[0]=8;
            value[1]=largeGroupRank;
            value[2]=orderedRanks[0];
            value[3]=orderedRanks[1];
            value[4]=orderedRanks[2];
        }

        if (straightFlush)
        {
            value[0]=9;
            value[1]=topStraightValue;
            value[2]=orderedRanks[0];
            value[3]=orderedRanks[1];
            value[4]=orderedRanks[2];
            value[5]=orderedRanks[3];
            value[6]=orderedRanks[4];
            value[7]=orderedRanks[5];
        }

    }

    public String display()
    {
        String s;
        switch( value[0] )
        {

            case 1:
                s="high card";
                break;
            case 2:
                s="pair of " + Card.valueToString(value[1]) + "\'s";
                break;
            case 3:
                s="two pair " + Card.valueToString(value[1]) + " " +
                        Card.valueToString(value[2]);
                break;
            case 4:
                s="three of a kind " + Card.valueToString(value[1]) + "\'s";
                break;
            case 5:
                s=Card.valueToString(value[1]) + " high straight";
                break;
            case 6:
                s="flush";
                break;
            case 7:
                s="full house " + Card.valueToString(value[1]) + " over " +
                        Card.valueToString(value[2]);
                break;
            case 8:
                s="four of a kind " + Card.valueToString(value[1]);
                break;
            case 9:
                s="straight flush " + Card.valueToString(value[1]) + " high";
                break;
            default:
                s="error in Hand.display: value[0] contains invalid value";
        }
        return s;
    }

    void displayAll()
    {
        for (int x=0; x<5; x++)
            System.out.println(cards[x].toString());
    }

    @Override
    public int compareTo(Comparison that)
    {
        for (int x=0; x<6; x++)
        {
            if (this.value[x]>that.value[x])
                return -1;
            else if (this.value[x]<that.value[x])
                return 1;
        }
        return 0; //if hands are equal
    }

    public Player getPlayer() {
        return player;
    }
}