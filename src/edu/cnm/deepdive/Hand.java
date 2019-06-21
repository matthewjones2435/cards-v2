package edu.cnm.deepdive;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public abstract class Hand {

  private List<Card> cards;

  protected Hand() {
    cards = new LinkedList<>();
  }
  protected List<Card> getCards() {
    return cards;
  }

  protected void setCards(List<Card> cards) {
    this.cards = cards;
  }



  public List<Card> showCards() {
    return Collections.unmodifiableList(cards);
  }

  public void add(Card card) {
    cards.add(card);
  }

  public void reset() {
    cards.clear();
  }
}
