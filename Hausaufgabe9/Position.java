
/**
 * Represents a Position on a chessfield the final attributes can be set, but
 * never changed
 * 
 * @author Tom Althoefer
 *
 */
public class Position {
	// final attributes for the position
	private final int x;
	private final int y;

	/**
	 * sets the coordinates for the Position
	 * 
	 * @param xPos
	 * @param yPos
	 */
	public Position(int xPos, int yPos) throws RuntimeException {
		this.x = xPos;
		this.y = yPos;
	}

	/**
	 * getter-method for the x-coordinate
	 * 
	 * @return x-coordinate of the Position
	 */
	public int getX() {
		return this.x;
	}

	/**
	 * getter-method for the y-coordinate
	 * 
	 * @return x-coordinate of the Positio n
	 */
	public int getY() {
		return this.y;
	}

	/**
	 * checks, if two Positions are the same
	 * 
	 * @param p
	 *            Position, to be compared with this
	 * @return true, if the Positions are equal false, if this is not the case
	 */
	public boolean equals(Position p) {
		return (p.getX() == this.x && p.getY() == this.y) ? true : false;
	}

	/**
	 * checks, if the Position is on the chess board, both coordinates have to
	 * be between 1 and 8 (inclusive)
	 * 
	 * @return true, if it is a valid position false, if the Position is not on
	 *         the chess board
	 */
	public boolean isValid() {
		return (this.x > 0 && this.x < 9 && this.y > 0 && this.y < 9) ? true : false;
	}

	/**
	 * @return x/y as a representation of the Position
	 */
	public String toString() {
		return this.x + "/" + this.y;
	}
}
