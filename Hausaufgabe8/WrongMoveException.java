
/**
 * Exception to be thrown if a requested move cannot be performed in a given
 * Schiebepuzzle
 * 
 * @author cw585968
 *
 */
public class WrongMoveException extends RuntimeException {

	public WrongMoveException(String s) {
		super(s);
	}

}
