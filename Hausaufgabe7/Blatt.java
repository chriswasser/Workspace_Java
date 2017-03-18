import java.util.Arrays;
/**
 * class Blatt
 * represents a player's hand with 3 cards in the game Heads Up
 * 
 */
public class Blatt {
	private int[] blatt;

	/**
	 * one and only constuctor for this class.
	 * 
	 * @param newBlatt
	 *            Array which contains the 3 cards of the player
	 * @throws IllegalArgumentException
	 *             if there are more or less than 3 cards in the player's hand
	 *             or if the cards do not contain valid values
	 */
	public Blatt(int[] newBlatt) throws IllegalArgumentException {
		// blatt has to have the length 3
		if (newBlatt.length != 3) {
			throw new IllegalArgumentException("Blatt zu gross/klein!");
		}
		// checks if all values in the field are valid (between 2 and 14)
		// throws an IllegalArgumentException if this is not the case
		for (int i = 0; i < 3; i++) {
			if (newBlatt[i] >= 2 && newBlatt[i] <= 14) {

			} else {
				throw new IllegalArgumentException("zahlen im Blatt zu gross/klein!");
			}
		}
		this.blatt = newBlatt.clone();
	}

	/**
	 * @return returns the values of the player's hand
	 */
	public String toString() {
		String ret = Arrays.toString(blatt);
		// trims the normal Arrays.toString() method and removes the []
		return ret.substring(1, ret.length() - 1);
	}

	/**
	 *
	 * @return returns the player's hand
	 */
	public int[] getBlatt() {
		return blatt.clone();
	}
}
