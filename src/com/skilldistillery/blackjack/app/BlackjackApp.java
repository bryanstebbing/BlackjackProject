package com.skilldistillery.blackjack.app;

import java.util.Objects;
import java.util.Scanner;

import com.skilldistillery.blackjack.entities.ConcreteHand;
import com.skilldistillery.blackjack.entities.Dealer;
import com.skilldistillery.blackjack.entities.Deck;
import com.skilldistillery.blackjack.entities.Player;

public class BlackjackApp {
	protected Scanner blackjackScanner = new Scanner(System.in);
	protected ConcreteHand hand;
	protected Player player;
	protected Dealer dealer;
	private Deck deck;

	public BlackjackApp() {
		deck = new Deck();
		deck.shuffle();

		dealer = new Dealer("Dealer", deck);
		player = new Player("Player", dealer);

		hand = new ConcreteHand();
		
		player.setHand(new ConcreteHand());
		dealer.setHand(new ConcreteHand());
	}

	public static void main(String[] args) {
		BlackjackApp app = new BlackjackApp();
		app.run();
	}

	public void run() {
		player.addCard(dealer.dealCards(hand));

		dealer.addCard(dealer.dealCards(hand));
		dealer.showDealersHand();

		player.addCard(dealer.dealCards(hand));
		player.showPlayersHand();

		dealer.addCard(dealer.dealCards(hand));

		player.playersTurn();
		
	}


	@Override
	public int hashCode() {
		return Objects.hash(blackjackScanner, hand);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BlackjackApp other = (BlackjackApp) obj;
		return Objects.equals(blackjackScanner, other.blackjackScanner) && Objects.equals(hand, other.hand);
	}

	public Deck getDeck() {
		return deck;
	}

	public void setDeck(Deck deck) {
		this.deck = deck;
	}
}
