/**
 * implements the interface Rechenoperation
 */
public class Addition implements Rechenoperation {
	// first value of the Addition
	private double value;

	/**
	 * sets the attribute value
	 * 
	 * @param value
	 */
	public Addition(double value) {
		this.value = value;
	}

	/**
	 * returns the result of parameter x + value of the Addition
	 */
	public double berechne(double x) {
		return this.value + x;
	}

}
