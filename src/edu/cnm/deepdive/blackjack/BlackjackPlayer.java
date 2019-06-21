package edu.cnm.deepdive.blackjack;

import edu.cnm.deepdive.Card;
import edu.cnm.deepdive.Player;

public abstract class BlackjackPlayer extends Player<BlackjackHand> {

  @Override
  public boolean canAccept() {
    return !getHand().isBusted() && !getHand().isBlackjack();
  }

}