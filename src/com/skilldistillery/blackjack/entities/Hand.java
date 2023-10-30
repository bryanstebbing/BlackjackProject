package com.skilldistillery.blackjack.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class Hand {
	protected List<Card> cards = new ArrayList<>();
	
	public abstract int getHandValue();
	
	public void addCardDealt(Card card) {
		cards.add(card);
	}
	
	public int valueInHand() {
		int value = 0;
		int ifDealtAces = 0;
		
		for (Card card : cards) {
			if (card.rank.equals("Ace")) {
				ifDealtAces++;
			} else if(card.rank.equals("King") || card.rank.equals("Queen") ||card.rank.equals("Jack")) {
				value += 10;
			} else { 
				value += card.rank.getValue();
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
	
	public List<Card> getCards(){
		return cards;
	}

	public void setCards(List<Card> cards) {
		this.cards = cards;
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
