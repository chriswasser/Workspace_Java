import java.util.Arrays;

import javax.swing.JOptionPane;

public class Mastermind {

	// the 8 allowed colours
	private static final String[] allowedColours = new String[] { "WHITE", "YELLOW", "ORANGE", "RED", "GREEN", "BLUE",
			"BEIGE", "BLACK" };

	// the random evaluation configurations
	private static final int[][] eval = new int[][] {
		{0,1,2,3}, // one
		{0,1,3,2},
		{0,2,1,3},
		{0,2,3,1},
		{0,3,1,2}, // five
		{0,3,2,1},
		{1,0,2,3},
		{1,0,3,2},
		{1,2,0,3},
		{1,2,3,0}, // ten
		{1,3,0,2},
		{1,3,2,0},
		{2,0,1,3},
		{2,0,3,1},
		{2,1,0,3}, // fifteen
		{2,1,3,0},
		{2,3,0,1},
		{2,3,1,0},
		{3,0,1,2},
		{3,0,2,1}, // twenty
		{3,1,0,2},
		{3,1,2,0},
		{3,2,0,1},
		{3,2,1,0}, // twenty-four
	};
	
	// removes spaces and sets the String to all capital letters in the given
	// StringArray
	private static String[] cleanArray(String[] s) {
		String[] result = s;
		for (int i = 0; i < result.length; ++i) {
			result[i] = result[i].trim().toUpperCase();
		}
		return result;
	}

	// tests if the given StringArrays have the same content
	private static boolean areSame(String[] array1, String[] array2) {
		for (int i = 0; i < array1.length; ++i) {
			if (!array1[i].equals(array2[i])) {
				return false;
			}
		}
		return true;
	}

	// checks if only allowed colours are entered
	private static boolean allowedColours(String[] array) {
		for (String s : array) {
			boolean isAllowed = false;
			for (String allowed : Mastermind.allowedColours) {
				if (s.equals(allowed)) {
					isAllowed = true;
				}
			}
			if (!isAllowed) {
				return false;
			}
		}
		return true;
	}

	// checks if every colour appears just once
	private static boolean onlyOnce(String[] array) {
		for (int i = 0; i < array.length; ++i) {
			for (int j = 0; j < array.length; ++j) {
				if (array[i].equals(array[j]) && i != j) {
					return false;
				}
			}
		}
		return true;
	}

	// checks if conditions for a StringArray with 4 allowed colours are given
	private static boolean allowedArray(String[] array) {
		if (array.length != 4) {
			System.out.println("Enter exactly 4 colours");
		} else if (!Mastermind.allowedColours(array)) {
			System.out.println("Only use allowed colours");
		} else if (!Mastermind.onlyOnce(array)) {
			System.out.println("Do not enter a colour multiple times");
		} else {
			return true;
		}
		return false;
	}

	// evaluates how good the guess of player2 was
	private static boolean evaluateGuess(String[] colours, String[] guessedColours, int i) {
		// checks if the entered guess is correct
		if (Mastermind.areSame(colours, guessedColours)) {
			System.out.printf("Congratulations!!! Your guess was correct u win after %d guesses\n", (i + 1));
			return true;
		}
		
		// takes a random configuration to evaluate how good the guess was
		int config = (int) (Math.random()*24);
		
		// returns a black pin for every correct colour and correct position
		// returns a white pin for every correct colour on the wrong position
		for (int m = 0; m < guessedColours.length; ++m) {
			for (int n = 0; n < colours.length; ++n) {
				if (guessedColours[Mastermind.eval[config][m]].equals(colours[n])) {
					if (Mastermind.eval[config][m] == n) {
						System.out.printf("black pin ");
					} else {
						System.out.printf("white pin ");
					}
				}
			}
		}
		System.out.println("");
		return false;
	}

	// gets the solution colour configuration from player1
	private static String[] getSolution() {
		while (true) {
			String[] colours = null;
			try {
				colours = JOptionPane.showInputDialog("Player1, enter your desired colour configuration:").split(",");
			} catch (Exception e) {
				System.out.println("Thank you for playing!");
				System.exit(0);
			}
			colours = Mastermind.cleanArray(colours);

			// multiple error checks for right input
			if (Mastermind.allowedArray(colours)) {
				return colours;
			}
		}
	}

	// gets the guess colour configuration from player2
	private static String[] getGuess(int i) {
		while (true) {
			String[] guessedColours = null;
			try {
				guessedColours = JOptionPane.showInputDialog("Player2, enter your next guess:").split(",");
			} catch (Exception e) {
				System.out.println("Thank you for playing!");
				System.exit(0);
			}
			guessedColours = Mastermind.cleanArray(guessedColours);

			// multiple error checks for right input
			if (Mastermind.allowedArray(guessedColours)) {
				System.out.printf("Guess %d:", (i + 1));
				System.out.println(Arrays.deepToString(guessedColours));
				return guessedColours;
			}
		}
	}

	// where the game is played
	public static void main(String[] args) {

		// start sequence
		System.out.println("Welcome to Mastermind!");
		System.out.println("Available colours are:");
		System.out.println(Arrays.deepToString(Mastermind.allowedColours));

		// getting the solution from player1
		String[] colours = Mastermind.getSolution();

		// player2 has 20 guesses to get the right solution
		for (int i = 0; i < 20; ++i) {

			// get the guess
			String[] guessedColours = Mastermind.getGuess(i);

			// evaluates how good the guess was
			if (Mastermind.evaluateGuess(colours, guessedColours, i)) {
				break;
			}

		} // end for loop of the number of guesses

	} // end main

}
