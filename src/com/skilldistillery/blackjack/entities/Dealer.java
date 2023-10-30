package com.skilldistillery.blackjack.entities;

public class Dealer extends Player {
	private Deck deck;
	private String name;
	private Player player;

	public Dealer(String name, Deck deck) {
		super(name, null);
		this.name = name;
		this.deck = deck;
	}

	public Card dealCards(ConcreteHand hand) {
		Card card = deck.dealCard();
		if (card != null) {
			hand.addCardDealt(card);
		}
		return card;
	}

	public void checkSizeOfDeck() {
		deck.checkDeckSize();
	}

	public void addCard(Card card) {
		if (card != null) {
			getHand().addCardDealt(card);
		} else {
			System.out.println("No more cards in the deck!");
		}
	}

	public void showDealersHand() {
		System.out.println(name + " has showing: ");
		for (Card card : getHand().getCards()) {
			System.out.println(card);
		}
		System.out.println("The amount of points the Dealer has showing is: " + getHand().valueInHand() + "\n");
	}

	public Hand getHand() {
		return hand;
	}

	public void setHand(Hand hand) {
		this.hand = (ConcreteHand) hand;
	}

	public Deck getDeck() {
		return deck;
	}

	public void setDeck(Deck deck) {
		this.deck = deck;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setHand(ConcreteHand hand) {
		this.hand = hand;
	}

}
