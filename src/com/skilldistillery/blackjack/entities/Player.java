package com.skilldistillery.blackjack.entities;

import java.util.Scanner;

import com.skilldistillery.blackjack.app.BlackjackApp;

public class Player {
	protected Scanner blackjackScanner = new Scanner(System.in);
	protected ConcreteHand hand;
	private String name;
	protected Dealer dealer;
	protected BlackjackApp main;

	public Player() {
		this.setHand(new ConcreteHand());
	}

	public Player(String name, Dealer dealer) {
		this.name = name;
		this.dealer = dealer;
		this.setHand(new ConcreteHand());

	}

	public void addCard(Card card) {
		if (card != null) {
			dealer.dealCards(hand);
		} else {
			System.out.println("No more cards in the deck!");
		}
	}

	public void showPlayersHand() {
		System.out.println("You have: ");
		for (Card card : getHand().getCards()) {
			System.out.println(card);
		}
		System.out.println("The amount of points you have is: " + getHand().valueInHand() + "\n");
	}

	public void playersTurn() {
		if(getHand().getHandValue() == 21 && dealer.getHand().getHandValue() != 21) {
			System.out.println("Blackjack!!! You win!!!");
			playAgain();
		} else if (dealer.getHand().getHandValue() == 21 && getHand().getHandValue() != 21) {
			System.out.println("Dealer got Blackjack!!! You lose!!!");
			playAgain();
		}
		
		System.out.println("Please type 1 to hit or 2 to stay");

		while (true) {
			int playersChoice = blackjackScanner.nextInt();

			if (playersChoice == 1) {
				dealer.dealCards(hand);
				showPlayersHand();
				if (getHand().getHandValue() > 21) {
					System.out.println("You have busted!!!");
					playAgain();
					break;
				}
				System.out.println("Please type 1 to hit or 2 to stay");
			} else if (playersChoice == 2) {
				System.out.println("The amount of points you have is: " + getHand().valueInHand());
				break;
			}

			if (getHand().getHandValue() > 21) {
				System.out.println("You have busted!!!!");
				playAgain();
				break;
			}
		}
		dealersTurn();
	}

	public void dealersTurn() {

		while (dealer.getHand().getHandValue() < 17) {
			dealer.dealCards(hand);
			if (dealer.getHand().getHandValue() > 21) {
				System.out.println("You Win!!!");
				break;
			}
		}
		
		System.out.println("The Dealer has: ");
		for (Card card : dealer.getHand().getCards()) {
			System.out.println(card);
		}
		System.out.println("Dealers total points = " + dealer.getHand().getHandValue());
		compareHands();
	}

	public void compareHands() {
		if (getHand().getHandValue() > 21) {
			System.out.println("You Win!!!");
		} else if (dealer.getHand().getHandValue() > 21) {
			System.out.println("You Win!!!");
		} else if (getHand().getHandValue() > dealer.getHand().getHandValue()) {
			System.out.println("You Win!!!");
		} else if (getHand().getHandValue() < dealer.getHand().getHandValue()) {
			System.out.println("The House Wins!!!");
		} else {
			System.out.println("It's a tie!");
		}
		playAgain();
	}

	public void playAgain() {
		System.out.println("Would you like to play again? Type 1 for yes and 2 for no.");
		int replay = blackjackScanner.nextInt();
		if (replay == 1) {
			main.main(null);
		} else if (replay == 2) {
			System.out.println("Thank you for playing!! Have a nice day!");
			System.exit(0);
		} else {
			System.out.println("Please choose 1 or 2");
		}

	}

	public Hand getHand() {
		return hand;
	}

	public void setHand(Hand hand) {
		this.hand = (ConcreteHand) hand;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Dealer getDealer() {
		return dealer;
	}

	public void setDealer(Dealer dealer) {
		this.dealer = dealer;
	}

	public void setHand(ConcreteHand hand) {
		this.hand = hand;
	}

}
