
/**
 * abstract class Zahlwort gives basic methods for a class which represents a
 * number from 0 to 9999 and can return its value as text
 * 
 * @author C.Wassermann
 *
 */
public abstract class Zahlwort {
	protected int x;

	/**
	 * constructor of Zahlwort
	 * 
	 * @param x
	 *            the number to be represented; x has to be between 1 and 9999
	 * @throws NumberFormatException
	 *             if x is not between 1 and 9999
	 */
	public Zahlwort(int x) throws NumberFormatException {
		if (x <= 0 || x >= 10000) {
			throw new NumberFormatException("Zahl nicht im " + " Bereich zwischen 1 und 9999");
		} else {
			this.x = x;
		}
	}

	/**
	 * get the number as a string
	 * 
	 * @return the number as a string (not as text)
	 */
	public String getZifferString() {
		return x + "";
	}

	/**
	 * getter for the number as text
	 * 
	 * @return the number as text
	 */
	public abstract String getWortString();

	/**
	 * getter for the language
	 * 
	 * @return the language of the number
	 */
	public abstract String getSprache();

	/**
	 * toString method
	 * 
	 * @return a formatted string
	 */
	public String toString() {
		return "Die Zahl " + x + " schreibt man auf " + getSprache() + ": " + getWortString() + ".";
	}
}