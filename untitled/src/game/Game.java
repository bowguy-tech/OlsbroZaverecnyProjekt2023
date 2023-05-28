package game;

import game.*;
import java.util.ArrayList;
import java.util.Collections;

public class Game {

    Deck deck;
    Deck table = new Deck();
    ArrayList<Player> players = new ArrayList<Player>();
    ArrayList<Player> playersInGame = new ArrayList<Player>();
    int index;

    final int SMALL_BLIND = 30;
    int highestBid = 0;

    //plays the entire game of poker
    public void start() {
        setup();
        boolean playing = true;
        while (playing) {
            playing = next();
        }
        end();
    }

    //setup of round of poker
    private void setup() {

        //generates deck
        deck = new Deck();
        deck.generate();
        deck.shuffle();

        //sets players
        for (Player p: players) {
            playersInGame.add(p);
        }


        //gives all players cards
        for(Player p : playersInGame) {
            Deck cards = new Deck();
            cards.addCard(deck.takeCard());
            cards.addCard(deck.takeCard());
            p.setHand(cards);
        }

        // taking small and big blinds
        index = 0;
        playersInGame.get(index).bet(SMALL_BLIND);
        index++;
        playersInGame.get(index).bet(SMALL_BLIND * 2);
        index++;

        highestBid = SMALL_BLIND * 2;

        sendMessageAll("game has started");
    }

    /*
    *next round of poker
    * returns a boolean if game has ended
     */
    private boolean next() {

        //checks if all players have had a chance to play
        int played = 0;

            //next player's move
            while (((playersInGame.get(index).getChipsInPlay() != highestBid) || (played < playersInGame.size())) && (playersInGame.size() > 1)) {
                Player p = playersInGame.get(index);
                String[] move = p.getNextMove(this.highestBid, this.table);

                switch (move[0]) {
                    case "check":
                        p.bet(highestBid - p.getChipsInPlay());
                        sendMessageAll(p.getName() + " has checked");
                        break;

                    case "raise":
                        p.bet(highestBid - p.getChipsInPlay() + Integer.parseInt(move[1]));
                        highestBid += Integer.parseInt(move[1]);
                        sendMessageAll(p.getName() + " has raised by " + Integer.parseInt(move[1]));
                        break;

                    case "fold":
                        removePlayer(p.getName());
                        index--;
                        played--;
                        sendMessageAll(p.getName() + " folded");
                        break;


                }

                if (index > playersInGame.size()-2) {
                    index = 0;
                } else {
                    index++;
                }

                played++;
            }

        //checks if game has ended
        if (table.size() == 5)  {
            return false;
        }

        //adds next card to table
        if (table.size() == 0) {
            //draws the flop (3 cards)
            for (int i=0;i<3;i++) {
                table.addCard(deck.takeCard());
            }
        } else {
            //draws one card
            table.addCard(deck.takeCard());
        }
        sendMessageAll("new card(s) added to Table");
        sendMessageAll(table.toString());

        return true;
    }

    /*
    *gives the winner chips
    * returns a list of players kicked doe to not enough chips
     */
    private void end() {
        ArrayList<String> names = new ArrayList<String>();
        int pot = 0;

        for (Player p : playersInGame) {
            pot += p.getChipsInPlay();
            p.setChipsInPlay(0);
        }

        //finds winner
        ArrayList<Comparison> comparisons = new ArrayList<Comparison>();
        for (Player p : playersInGame) {
            Deck h = new Deck();
            h.addCard(p.getHand());
            for (int i = 0; i < 5; i++) {
                h.addCard(table.getCard(i));
            }
            Comparison c = new Comparison(h,p);
            comparisons.add(c);
            sendMessageAll(c.display());
        }
        Collections.sort(comparisons);
        comparisons.get(0).getPlayer().setChips(comparisons.get(0).getPlayer().getChips() + pot);
        sendMessageAll(comparisons.get(0).getPlayer().getName() + " is the winner! and won " + pot);

        sendMessageAll("game has ended");
    }

    /*
    * adds player to game
    * (must be done before game starts)
     */
    public void addPlayer(Player p) {
        sendMessageAll(p.getName() + " has joined");
        players.add(p);
    }

    /*
    * removes a player based on  name
    * return true/false if player was found and removed
     */
    public boolean removePlayer(String name) {
        for (Player p: playersInGame) {
            if (p.getName().equals(name)) {
                playersInGame.remove(p);
                return true;
            }
        }
        return false;
    }

    private void sendMessageAll(String message) {
        for (Player p: players) {
            p.sendMessage(message);
        }
    }

}
