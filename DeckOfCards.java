package DeckOfCards;

import java.util.Arrays;
import java.util.Random;

public class DeckOfCards {
	static Random rand = new Random();
	final static int cards = 52;

	/*
	 * Array
	 */
	static String[] deck = new String[cards];
	static String[] suits = { "Spades", "Hearts", "Diamonds", "Clubs" };
	static String[] ranks = { "Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King" };
	// Declares, initialize 2D array
	static String[][] cardArray = new String[4][9];

	/*
	 * distributeCards
	 */
	public void distributeCards() {
		// initialize deck
		for (int i = 0; i < ranks.length; i++) {
			for (int j = 0; j < suits.length; j++) {
				deck[suits.length * i + j] = ranks[i] + " of " + suits[j];
			}
		}
	}

	/*
	 * Shuffle the cards
	 */
	public void shuffleCard() {
		// shuffle
		for (int i = 0; i < cards; i++) {
			int r = i + (int) (Math.random() * (cards - i));
			String temp = deck[r];
			deck[r] = deck[i];
			deck[i] = temp;
		}
		for (int i = 0; i < 4; i++) {
			for (int i1 = 0; i1 < cardArray.length; i1++) {
				for (int j = 0; j < cardArray[i1].length; j++) {
					cardArray[i1][j] = deck[i1 + j * 4];
				}
			}
		}
	}

// Displaying data in 2D array
	public void print2D(String[][] cardArray2) {
		// Loop through all rows
		for (String[] row : cardArray2)
			// converting each row as string
			// and then printing in a separate line
			System.out.println(Arrays.toString(row));
	}

	/**
	 * DeckOfCards main
	 */
	public static void main(String[] args) {
		DeckOfCards card = new DeckOfCards();
		card.distributeCards();
		card.shuffleCard();
		card.print2D(cardArray);

	}

}
