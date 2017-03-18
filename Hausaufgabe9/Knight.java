
import java.util.ArrayList;

/**
 * extends the abstract class Chessman represents a knight and implements the
 * getMoveList() method in an according way
 * 
 * @author Tom Althoefer
 *
 */
public class Knight extends Chessman {

	/**
	 * constructs a new Knight, uses the constructor of the super class
	 * 
	 * @param p
	 *            Position of the Knight
	 */
	public Knight(Position p) {
		super(p);
	}

	/**
	 * @return ArrayList with all possible Positions, the Knight can move to
	 */
	@Override
	public ArrayList<Position> getMoveList() {
		// temporary save the Position to avoid some method calls
		int x = this.getPosition().getX();
		int y = this.getPosition().getY();
		ArrayList<Position> moveList = new ArrayList<Position>();

		// add all possible Positions to the moveList
		// Positions are not checked yet
		moveList.add(new Position(x + 2, y + 1));
		moveList.add(new Position(x + 2, y - 1));
		moveList.add(new Position(x - 2, y + 1));
		moveList.add(new Position(x - 2, y - 1));
		moveList.add(new Position(x + 1, y + 2));
		moveList.add(new Position(x + 1, y - 2));
		moveList.add(new Position(x - 1, y + 2));
		moveList.add(new Position(x - 1, y - 2));

		// go through the list and check all Positions
		// delete if !isValid()
		for (int i = 0; i < moveList.size(); i++) {
			if (moveList.get(i).isValid()) {
				// everything allright
			} else {
				moveList.remove(i);
				// else we might skip a element the list, because the element at
				// i ist replaced by a new one
				i--;
			}
		}
		return moveList;
	}

	/**
	 * @return Position of the Knight "Springer: (x/y)"
	 */
	public String toString() {
		return "Springer: (" + this.getPosition().toString() + ")";
	}
}
