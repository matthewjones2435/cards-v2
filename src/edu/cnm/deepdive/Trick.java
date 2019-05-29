package edu.cnm.deepdive;

import edu.cnm.deepdive.Suit.Color;
import java.security.SecureRandom;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Trick {

  private List<Card> deck;
  private List<Card> redPile;
  private List<Card> blackPile;
  private Random rng;

  public Trick() {
    rng = new SecureRandom();
    deck = new LinkedList<>();
    for (Suit suit : Suit.values()) {
      for (Rank rank : Rank.values()) {
        Card card = new Card(rank, suit);
        deck.add(card);
      }
    }
    Collections.shuffle(deck, rng);
  }

  public void split() {
    redPile = new LinkedList<>();
    blackPile = new LinkedList<>();
    while (!deck.isEmpty()) {
      Card selector = deck.remove(0);
      Card next = deck.remove(0);
      if (selector.getSuit().getColor() == Color.RED) {
        redPile.add(next);
      } else {
        blackPile.add(next);
      }
    }
  }

  public void swap() {
    int swapCount = rng.nextInt(1 + Math.min(redPile.size(), blackPile.size()));
    for (int i = 0; i < swapCount; i++) {
      blackPile.add(redPile.remove(0));
      redPile.add(blackPile.remove(0));
    }
  }

  public void summarize() {
    Collections.sort(redPile);
    Collections.sort(blackPile);
    System.out.printf("Red Pile: %s%n", redPile);
    System.out.printf("Black Pile: %s%n", blackPile);
  }

  public static void main(String[] args) {
    Trick trick = new Trick();
    trick.split();
    trick.swap();
    trick.summarize();
  }

}
