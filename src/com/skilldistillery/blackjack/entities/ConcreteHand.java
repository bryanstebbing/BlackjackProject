package com.skilldistillery.blackjack.entities;

import java.util.Objects;

public class ConcreteHand extends Hand {
    public ConcreteHand() {
        super();
    }

    public int valueInHand() {
        int value = 0;
        int ifDealtAces = 0;

        for (Card card : cards) {
            if (card.getRank() == Rank.ACE) {
                ifDealtAces++;
            } else if (card.getRank() == Rank.KING || card.getRank() == Rank.QUEEN || card.getRank() == Rank.JACK) {
                value += 10;
            } else {
                value += card.getValue();
            }
        }

        while (ifDealtAces > 0) {
            if (value + 11 <= 21) {
                value += 11;
            } else {
                value += 1;
            }
            ifDealtAces--;
        }
        return value;
    }

    @Override
    public int getHandValue() {
        return valueInHand();
    }

    @Override
    public int hashCode() {
        return Objects.hash(cards);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Hand other = (Hand) obj;
        return Objects.equals(cards, other.cards);
    }
}
