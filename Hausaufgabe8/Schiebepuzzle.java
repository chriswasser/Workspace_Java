
/**
 * class Schiebepuzzle is a puzzle with 15 numbers in a 4x4 frame. The tiles can
 * be moved by horizontal and vertical shifts. The aim is to get the tiles set
 * up in order by performing a number of shifts.
 * 
 * @author cw585968
 *
 */
public class Schiebepuzzle {

	private int[][] puzzle = new int[4][4];

	/**
	 * Constructor of Schiebepuzzle, which initializes the puzzle in ordered
	 * configuration
	 */
	public Schiebepuzzle() {
		for (int i = 0; i < this.puzzle.length; ++i) {
			for (int j = 0; j < this.puzzle[i].length; ++j) {
				if (i == 3 && j == 3) {
					this.puzzle[i][j] = 0;
				} else {
					this.puzzle[i][j] = i * 4 + j + 1;
				}
			}
		}
	}

	/**
	 * Shifts a tile with the number i to the empty spot
	 * 
	 * @param i
	 *            the tile which is requested to be moved
	 * @throws WrongNumberException
	 *             if i is not a number appearing in the puzzle
	 * @throws WrongMoveException
	 *             if the tile with number i cannot be moved
	 */
	public void schiebe(int i) throws WrongNumberException, WrongMoveException {
		// variables for the indexes of the empty place
		int emptyX = -1;
		int emptyY = -1;
		// variables for the indexes of the number i
		int numberX = -1;
		int numberY = -1;
		if (i >= 1 && i <= 15) {
			for (int z = 0; z < this.puzzle.length; ++z) {
				for (int j = 0; j < this.puzzle[z].length; ++j) {
					// search the indexes of the empty place
					if (this.puzzle[z][j] == 0) {
						emptyX = z;
						emptyY = j;
					}
					// search the indexes of the number i
					if (this.puzzle[z][j] == i) {
						numberX = z;
						numberY = j;
					}
					// if both are found break the loop
					if (emptyX != -1 && numberX != -1) {
						break;
					}
				}
			}
			if (this.istVerschiebbar(i)) {
				// change the two tiles
				this.puzzle[emptyX][emptyY] = i;
				this.puzzle[numberX][numberY] = 0;
			} else {
				throw new WrongMoveException("Given Number cannot be moved!");
			}
		} else {
			throw new WrongNumberException("Invalid Number given!");
		}
	}

	/**
	 * Tests if the tile with the number i can be shifted
	 * 
	 * @param i
	 *            the number of the tile of which is requested to know if it can
	 *            be moved or not
	 * @return if the tile i is able to be shifted or not
	 */
	public boolean istVerschiebbar(int i) {
		// variables for the indexes of the empty place
		int emptyX = -1;
		int emptyY = -1;
		// variables for the indexes of the number i
		int numberX = -1;
		int numberY = -1;
		if (i >= 1 && i <= 15) {
			for (int z = 0; z < this.puzzle.length; ++z) {
				for (int j = 0; j < this.puzzle[z].length; ++j) {
					// search the indexes of the empty place
					if (this.puzzle[z][j] == 0) {
						emptyX = z;
						emptyY = j;
					}
					// search the indexes of the number i
					if (this.puzzle[z][j] == i) {
						numberX = z;
						numberY = j;
					}
					// if both are found break the loop
					if (emptyX != -1 && numberX != -1) {
						break;
					}
				}
			}
			// condition for possibility of swapping
			if ((emptyX + 1 == numberX && emptyY == numberY) || (emptyX - 1 == numberX && emptyY == numberY)
					|| (emptyX == numberX && emptyY - 1 == numberY) || (emptyX == numberX && emptyY + 1 == numberY)) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	/**
	 * Scrambles the puzzle randomly with 100 moves
	 */
	public void mische() {
		int number = -1;
		for (int i = 0; i < 100; ++i) {
			while (true) {
				number = (int) (Math.random() * 15 + 1);
				if (this.istVerschiebbar(number)) {
					this.schiebe(number);
					break;
				}
			}
		}
	}

	/**
	 * Returns a formated String of the current state of the puzzle
	 */
	public String toString() {
		String s = "";
		int number = 0;
		for (int i = 0; i < this.puzzle.length; ++i) {
			for (int j = 0; j < this.puzzle[i].length; ++j) {
				number = this.puzzle[i][j];
				if (number == 0) {
					s += "|  ";
				} else {
					s += String.format("|%2d", number);
				}
			}
			s += "|\n";
			s += "-------------\n";
		}
		return s;
	}

	/**
	 * Gives the current state of the puzzle as an integer array
	 * 
	 * @return the current state of the puzzle
	 */
	public int[][] getPuzzle() {
		int[][] result = new int[this.puzzle.length][this.puzzle[0].length];
		for (int i = 0; i < this.puzzle.length; ++i) {
			for (int j = 0; j < this.puzzle[i].length; ++j) {
				result[i][j] = this.puzzle[i][j];
			}
		}
		return result;
	}

}
