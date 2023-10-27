package com.skilldistillery.blackjack.entities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {

	private List<Card> deck = new ArrayList<>(52);
	

	public Deck() {
		for (Suit suit : Suit.values()) {
			for (Rank rank : Rank.values()) {
				deck.add(new Card(suit, rank));

			}
		}
	}

	public int checkDeckSize() {
		return deck.size();
	}

	public Card dealCard() {
		if (deck.isEmpty()) {
			return null;
		}
		return deck.remove(deck.size() - 1);
	}

	public void shuffle() {
		Collections.shuffle(deck);
	}

}
