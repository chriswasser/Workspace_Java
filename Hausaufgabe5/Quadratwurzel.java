/**
 * implements the interface Rechenoperation
 *
 */
public class Quadratwurzel implements Rechenoperation {

	/**
	 * returns the square root of parameter x
	 * 
	 * @throws ArithmeticException
	 *             if the given parameter is negative
	 */
	@Override
	public double berechne(double x) throws ArithmeticException {
		if (x < 0) {
			throw new ArithmeticException("Keine Wurzel aus einer negativen Zahl!");
		} else {
			return Math.sqrt(x);
		}
	}

}
