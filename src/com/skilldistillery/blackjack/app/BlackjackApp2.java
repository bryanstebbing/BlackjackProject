package com.skilldistillery.blackjack.app;

public class BlackjackApp2 {

	import java.util.Scanner;

import com.skilldistillery.blackjack.entities.Deck;
import com.skilldistillery.blackjack.entities.Player;

	public class BlackjackApp {
	    private Deck deck;
	    private Player player;
	    private Player dealer;
	    private Scanner scanner;

	    public BlackjackApp() {
	        deck = new Deck();
	        player = new Player("Player");
	        dealer = new Player("Dealer");
	        scanner = new Scanner(System.in);
	    }

	    public void run() {
	        while (true) {
	            deck.shuffle();
	            player.getHand().clear();
	            dealer.getHand().clear();

	            // Deal initial cards (2 for player and 2 for dealer)
	            player.hit(deck);
	            player.hit(deck);
	            dealer.hit(deck);
	            dealer.hit(deck);

	            // Player's turn
	            while (true) {
	                displayTable();
	                System.out.println("1 - Hit, 2 - Stand");
	                int choice = scanner.nextInt();

	                if (choice == 1) {
	                    player.hit(deck);
	                    if (player.getHandValue() > 21) {
	                        displayTable();
	                        System.out.println("Busted! You lose.");
	                        break;
	                    }
	                } else if (choice == 2) {
	                    break;
	                }
	            }

	            // Dealer's turn
	            while (dealer.getHandValue() < 17) {
	                dealer.hit(deck);
	            }

	            // Determine the winner
	            displayTable();
	            determineWinner();

	            if (!playAgain()) {
	                System.out.println("Thank you for playing!");
	                break;
	            }
	        }
	    }

	    private void displayTable() {
	        System.out.println("Player's Hand: " + player.getHand());
	        System.out.println("Player's Total Points: " + player.getHandValue());
	        System.out.println("Dealer's Hand: " + dealer.getHand());
	    }

	    private void determineWinner() {
	        int playerValue = player.getHandValue();
	        int dealerValue = dealer.getHandValue();

	        if (playerValue > 21) {
	            System.out.println("Player busts! Dealer wins.");
	        } else if (dealerValue > 21 || playerValue > dealerValue) {
	            System.out.println("Player wins!");
	        } else if (dealerValue > playerValue) {
	            System.out.println("Dealer wins.");
	        } else {
	            System.out.println("It's a tie!");
	        }
	    }

	    private boolean playAgain() {
	        System.out.println("Play again? (1 - Yes, 2 - No)");
	        int choice = scanner.nextInt();
	        return choice == 1;
	    }

	    public static void main(String[] args) {
	        BlackjackApp app = new BlackjackApp();
	        app.run();
	    }
	}

