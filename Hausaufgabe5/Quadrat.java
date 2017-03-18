/**
 * implements the interface Rechenoperatio
 */
public class Quadrat implements Rechenoperation {

	/**
	 * returns the square of parameter x
	 */
	@Override
	public double berechne(double x) {
		return x * x;
	}

}
