
/**
 * class ZahlwortEnglisch has the functionality to return a number from 0 to
 * 9999 as text in the English language
 * 
 * @author C.Wassermann
 *
 */
public class ZahlwortEnglisch extends Zahlwort {

	// the different hard coded word pieces, which are combined to form whole
	// numbers
	private final String[] einer = new String[] { "", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };
	private final String[] zehner = new String[] { "", "teen", "twenty", "thirty", "fourty", "fifty", "sixty", "seventy", "eighty", "ninety" };
	private final String[] zehnerpotenzen = new String[] { "hundred", "thousand" };
	private final String[] spezialfaelle = new String[] { "zero", "ten", "eleven", "twelve", "thir", "fif", "eigh" };

	/**
	 * constructor of ZahlwortEnglisch
	 * 
	 * @param x
	 *            the number to be represented; x has to be between 1 and 9999
	 */
	public ZahlwortEnglisch(int x) {
		super(x);
	}

	/**
	 * getter for the number as text
	 * 
	 * @return the number as text in the English language
	 */
	@Override
	public String getWortString() {
		String out = ""; // result string which is build during the whole method
		// special case 0
		if (x == 0) {
			return this.spezialfaelle[0];
		}
		// building the string by beginning at the left most (existing) digit
		// thousands
		if (x >= 1000) {
			out += this.einer[x / 1000] + " " + this.zehnerpotenzen[1];
			x = x % 1000;
			if (x > 0) {
				out += " ";
			}
		}
		// hundreds
		if (x >= 100) {
			out += this.einer[x / 100] + " " + this.zehnerpotenzen[0];
			x = x % 100;
			if (x > 0) {
				out += " ";
			}
		}
		// special for the English language
		if (x > 0 && out != "") {
			out += "and ";
		}
		// all special cases are below 20
		if (x > 20) { // greater than 20
			if (x % 10 == 0) {
				out += this.zehner[x / 10];
			} else {
				out += this.zehner[x / 10] + "-" + this.einer[x % 10];
			}
		} else { // less than or equal to 20
			switch (x) {
			case 0:
				break;
			case 10:
				out += this.spezialfaelle[1];
				break;
			case 11:
				out += this.spezialfaelle[2];
				break;
			case 12:
				out += this.spezialfaelle[3];
				break;
			case 13:
				out += this.spezialfaelle[4] + this.zehner[1];
				break;
			case 15:
				out += this.spezialfaelle[5] + this.zehner[1];
				break;
			case 18:
				out += this.spezialfaelle[6] + this.zehner[1];
				break;
			default:
				out += this.einer[x % 10] + this.zehner[x % 100 / 10];
			}
		}
		return out;
	}

	/**
	 * getter for the language
	 * 
	 * @return the language of the number
	 */
	@Override
	public String getSprache() {
		return "Englisch";
	}

	/**
	 * main for testing purposes
	 */
	public static void main(String[] args) {
		int[] testtabelle = { 10, 11, 12, 13, 15, 18, 20, 35, 51, 80, 103, 1067 };
		for (int zahl : testtabelle) {
			try {
				ZahlwortEnglisch zahlwort = new ZahlwortEnglisch(zahl);
				System.out.println(zahlwort);
			} catch (NumberFormatException ex) {
				System.out.println(ex);
			}
		}
	}

}
