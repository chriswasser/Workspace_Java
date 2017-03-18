
import java.util.ArrayList;

/**
 * abstract class Chessman represents the general idea of a chess figure it can
 * move, return its position, or a whole list of possible positions this list of
 * possible Positions has to be implemented by the 'real' figures, like rook,
 * knight, king, queen etc. for an example implementation have a look at Rook
 * and Knight
 * 
 * @author Tom Althoefer
 *
 */
public abstract class Chessman {
	private Position pos;

	/**
	 * constructs a new Chessman, with and sets the attribute Position. Because
	 * Position has final attributes we dont need a clone of it and just use the
	 * pointer
	 * 
	 * @param p
	 *            the Position of the Chessman
	 * @throws RuntimeException
	 *             if the position is not on the board
	 */
	public Chessman(Position p) throws RuntimeException {
		if (p.isValid()) {
			this.pos = p;
		} else {
			throw new RuntimeException("Invalid Position!");
		}
	}

	/**
	 * Again, Position has final Attributes and cannot be changed in any way, so
	 * we just use the actual Object and do not have to clone it
	 * 
	 * @return returns the Position of the chessman
	 */
	public Position getPosition() {
		return this.pos;
	}

	/**
	 * sets a new Position for the figure, if it is a Position, the figure can
	 * move to
	 * 
	 * @param pos
	 *            new Position for the Chessman
	 * @throws RuntimeExcpetion
	 *             if the position cannot be reached within one move
	 */
	public void moveTo(Position pos) throws RuntimeException {
		if (this.canMoveTo(pos)) {
			this.pos = pos;
		} else {
			throw new RuntimeException("Position cannot be reached within one move!");
		}
	}

	/**
	 * checks, if the given Position pos can be reached by the chessman in one
	 * move
	 * 
	 * @param pos
	 *            Position to be tested
	 * @return true, if it is a reachable position false, if not
	 */
	public boolean canMoveTo(Position pos) {
		ArrayList<Position> moves = this.getMoveList();
		for (Position position : moves) {
			if (position.getX() == pos.getX() && position.getY() == pos.getY()) {
				return true;
			}
		}
		return false;
	}

	/**
	 * returns a ArrayList of all possible reachable Positions for the chess
	 * figure; ignores other figures; method has to be implemented by the actual
	 * chess figures
	 * 
	 * @return returns a ArrayList of all possible reachable Positions for the
	 *         chess figure
	 */
	public abstract ArrayList<Position> getMoveList();
}
