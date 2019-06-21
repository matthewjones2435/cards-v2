package edu.cnm.deepdive.blackjack;

import edu.cnm.deepdive.Card;
import edu.cnm.deepdive.Hand;
import edu.cnm.deepdive.Rank;
import java.util.LinkedList;

public class BlackjackHand extends Hand {

  private static final int SOFT_INCREMENT =10;
  private static final int[] VALUES = {
      1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10
  };
  private static final int LIMIT = 21;

  private int value;
  private boolean busted;
  private boolean blackjack;
  private boolean soft;


  @Override
  public void add (Card card) {
    if(busted || blackjack) {
      throw new IllegalStateException();
    }
    super.add(card);
    var cards = getCards();
    var rank  = card.getRank();
    value += VALUES[rank.ordinal()];
    if(rank == Rank.ACE && value + SOFT_INCREMENT >= LIMIT) {
      value += SOFT_INCREMENT;
      soft = true;
    } else if (value > LIMIT && soft) {
      value -= SOFT_INCREMENT;
      soft = false;
    }
    if (value == LIMIT && cards.size() == 2) {
      blackjack = true;
    } else if (value > LIMIT) {
      busted = true;
    }
  }

  public int getValue() {
    return value;
  }

  public boolean isBusted() {
    return busted;
  }

  public boolean isBlackjack() {
    return blackjack;
  }

  public boolean isSoft() {
    return soft;
  }
  @Override
  public void reset() {
    super.reset();
    value = 0;
    soft = false;
    busted = false;
    blackjack = false;

  }

}
