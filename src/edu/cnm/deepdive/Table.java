package edu.cnm.deepdive;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Table {

  private PitBoss pitBoss;
  private Random rng;
  private List<Card> deck;
  // TODO define Player class.

  private Table() {}

  public void shuffle() {
    Collections.shuffle(deck, rng);
  }
  public static class Builder {

    private PitBoss pitBoss;
    private Random rng;
    private List<Card> deck;
    // TODO define Player class.

    public Builder() {
    }

    public Builder setPitBoss(PitBoss pitBoss) {
      this.pitBoss = pitBoss;
      return this;
    }

    public Builder setRng(Random rng) {
      this.rng = rng;
      return this;
    }

    public Builder setDeck(List<Card> deck) {
      this.deck = deck;
      return this;
    }

    public Table build() {
      // TODO add players.
//      if(players == null || players.isEmpty()) {
//        throw new IllegalStateException();
//      }
      Table table = new Table();
      table.rng = (rng != null ? rng : new Random());
      if (deck == null) {
        var defaultDeck = new ArrayList<Card>();
        for(Suit suit : Suit.values()) {
          for (Rank rank : Rank.values()) {
            defaultDeck.add(new Card(rank, suit));
          }
        }
        table.deck = defaultDeck;
      } else {
        table.deck = new ArrayList<>(deck);
      }
      return table;
    }

  }

}
