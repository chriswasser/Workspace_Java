
/**
 * Exception to be thrown if a number is not contained in a Schiebepuzzle
 * 
 * @author cw585968
 *
 */
public class WrongNumberException extends RuntimeException {

	public WrongNumberException(String s) {
		super(s);
	}
}
