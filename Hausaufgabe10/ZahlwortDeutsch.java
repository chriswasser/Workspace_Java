
/**
 * class ZahlwortDeutsch has the functionality to return a number from 0 to 9999
 * as text in the German language
 * 
 * @author C.Wassermann
 *
 */
public class ZahlwortDeutsch extends Zahlwort {

	// the different hard coded word pieces, which are combined to form whole
	// numbers
	final String[] einer = new String[] { "", "ein", "zwei", "drei", "vier", "fuenf", "sechs", "sieben", "acht", "neun" };
	final String[] zehner = new String[] { "", "zehn", "zwanzig", "dreissig", "vierzig", "fuenfzig", "sechzig", "siebzig", "achtzig", "neunzig" };
	final String[] zehnerpotenzen = new String[] { "hundert", "tausend" };
	final String[] spezialfaelle = new String[] { "null", "eins", "elf", "zwoelf", "sechzehn", "siebzehn" };

	/**
	 * constructor of ZahlwortDeutsch
	 * 
	 * @param x
	 *            the number to be represented; x has to be between 1 and 9999
	 */
	public ZahlwortDeutsch(int x) {
		super(x);
	}

	/**
	 * getter for the number as text
	 * 
	 * @return the number as text in the German language
	 */
	@Override
	public String getWortString() {
		String out = ""; // result string which is build during the whole method
		// special case 0
		if (x == 0) {
			return spezialfaelle[0];
		}
		// building the string by beginning at the left most (existing) digit
		// thousands
		if (x >= 1000) {
			out += einer[x / 1000] + zehnerpotenzen[1];
			x = x % 1000;
		}
		// hundreds
		if (x >= 100) {
			out += einer[x / 100] + zehnerpotenzen[0];
			x = x % 100;
		}
		// all special cases are below 20
		if (x > 20) { // greater than 20
			if (x % 10 == 0) {
				out += this.zehner[x / 10];
			} else {
				out += this.einer[x % 10] + "und" + this.zehner[x / 10];
			}
		} else { // less than or equal to 20
			switch (x) {
			case 0:
				break;
			case 1:
				out += this.spezialfaelle[1];
				break;
			case 11:
				out += this.spezialfaelle[2];
				break;
			case 12:
				out += this.spezialfaelle[3];
				break;
			case 16:
				out += this.spezialfaelle[4];
				break;
			case 17:
				out += this.spezialfaelle[5];
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
		return "Deutsch";
	}

	/**
	 * main for testing purposes
	 */
	public static void main(String[] args) {
		int[] testtabelle = { 1, 10, 11, 12, 16, 17, 20, 38, 69, 70, 131, 195, 2345 };
		for (int zahl : testtabelle) {
			try {
				ZahlwortDeutsch zahlwort = new ZahlwortDeutsch(zahl);
				System.out.println(zahlwort);
			} catch (NumberFormatException ex) {
				System.out.println(ex);
			}
		}
	}

}