
import java.util.ArrayList;

/**
 * extends the abstract class Chessman represents a rook and implements the
 * getMoveList() method in an according way
 * 
 * @author Tom Althoefer
 *
 */
public class Rook extends Chessman {

	/**
	 * constructs a new Rook, uses the constructor of the super class
	 * 
	 * @param p
	 *            Position of the Rook
	 */
	public Rook(Position p) {
		super(p);
	}

	/**
	 * @return ArrayList with all possbile Positions, the Rook can move to
	 */
	@Override
	public ArrayList<Position> getMoveList() {
		// temporary save the Position to avoid some methodcalls
		int x = this.getPosition().getX();
		int y = this.getPosition().getY();
		ArrayList<Position> moveList = new ArrayList<Position>();
		// add all Positions with the same x-coordinate
		for (int i = 1; i <= 8; i++) {
			if (i != y) {
				moveList.add(new Position(x, i));
			}
		}
		// add all Positions with the same y-coordinate
		for (int i = 1; i <= 8; i++) {
			if (i != x) {
				moveList.add(new Position(i, y));
			}
		}
		return moveList;
	}

	/**
	 * @return Position of the Knight "Springer: (x/y)"
	 */
	public String toString() {
		return "Turm: (" + this.getPosition().toString() + ")";
	}
}
