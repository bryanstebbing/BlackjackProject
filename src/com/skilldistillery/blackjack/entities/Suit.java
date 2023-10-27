package com.skilldistillery.blackjack.entities;

public enum Suit {

	HEARTS("Hearts"), SPADES("Spades"), CLUBS("Clubs"), DIAMONDS("Diamonds"),;


	private Suit(String name) {
		cardType = name;

	}
	final private String cardType;

	public String toString() {
		return cardType;
	}
	
	public String getCardType() {
		return cardType;
	}
}
