/**
 * Klasse PositiveNumber, die eine positive Zahl speichert und die Moeglichkeit
 * bietet sie in andere Zahlensysteme (2,10,16) umzuwandeln
 * 
 * @author cw585968
 *
 */
public class PositiveNumber {

	private int value;

	/**
	 * Speichert den zur uebergebenen Dezimalzahl gehoerenden Wert ab
	 * 
	 * @param s
	 *            Dezimalzahl des Wertes, der gespeichert werden soll
	 * @throws NumberFormatException
	 *             falls ein unerlaubtes Zeichen uebergeben wird
	 * @throws ArithmeticException
	 *             falls eine negative oder zu grosse Zahl uebergeben wird
	 */
	public void setDecimal(String s) throws NumberFormatException, ArithmeticException {
		long prod = 0;
		long zahl = 0;
		// Schleife, um den String von hinten nach vorne abzugehen
		for (int i = s.length() - 1; i >= 0; i--) {
			// Bei Dezimalzahlen nur Ziffern von 0 bis 9
			if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
				prod = s.charAt(i) - '0';
				// Potenzen anhand der Stelle errechnen (bei den anderen
				// Funktionen analog)
				prod = prod * ((long) Math.pow(10, s.length() - i - 1));
				zahl = zahl + prod;
				// Ueberpruefung, ob Integer Ueberlauf passiert wäre (bei den
				// anderen Funktionen analog)
				if (prod > Integer.MAX_VALUE || zahl > Integer.MAX_VALUE) {
					throw new ArithmeticException("Zu grosse Zahl!");
				}
				// Ueberpruefung, ob minus vorne am String steht, damit richtige
				// Exception geworfen wird (bei den anderen Funktionen analog)
			} else if (s.charAt(i) == '-') {
				throw new ArithmeticException("Zu kleine Zahl!");
			} else {
				throw new NumberFormatException("Unerlaubtes Zeichen!");
			}
		}
		this.value = (int) zahl;
	}

	/**
	 * Speichert den zur uebergebenen Hexadezimalzahl gehoerenden Wert ab
	 * 
	 * @param s
	 *            Hexadezimalzahl des Wertes, der gespeichert werden soll
	 * @throws NumberFormatException
	 *             falls ein unerlaubtes Zeichen uebergeben wird
	 * @throws ArithmeticException
	 *             falls eine negative oder zu grosse Zahl uebergeben wird
	 */
	public void setHexadecimal(String s) throws NumberFormatException, ArithmeticException {
		long prod = 0;
		long zahl = 0;
		// Schleife, um den String von hinten nach vorne abzugehen
		for (int i = s.length() - 1; i >= 0; i--) {
			// Bei Hexadezimalzahlen Ziffern von 0 bis 9 ...
			if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
				prod = s.charAt(i) - '0';
				prod = prod * ((long) Math.pow(16, s.length() - i - 1));
				zahl = zahl + prod;
				if (prod > Integer.MAX_VALUE || zahl > Integer.MAX_VALUE) {
					throw new ArithmeticException("Zu grosse Zahl!");
				}
				// und a bis f (erwartet "Buchstaben"-Ziffern als
				// Kleinbuchstaben)
			} else if (s.charAt(i) >= 'a' && s.charAt(i) <= 'f') {
				// vom char 87 abziehen, um auf den richtigen Wert zu kommen
				prod = s.charAt(i) - 87;
				for (int j = 1; j < s.length() - i; j++) {
					prod = prod * 16;
				}
				zahl = zahl + prod;
				if (prod > Integer.MAX_VALUE || zahl > Integer.MAX_VALUE) {
					throw new ArithmeticException("Zu grosse Zahl!");
				}
			} else if (s.charAt(i) == '-') {
				throw new ArithmeticException("Zu kleine Zahl!");
			} else {
				throw new NumberFormatException("Unerlaubtes Zeichen!");
			}
		}
		this.value = (int) zahl;
	}

	/**
	 * Speichert den zur uebergebenen Binaerzahl gehoerenden Wert ab
	 * 
	 * @param s
	 *            Binaerzahl des Wertes, der gespeichert werden soll
	 * @throws NumberFormatException
	 *             falls ein unerlaubtes Zeichen uebergeben wird
	 * @throws ArithmeticException
	 *             falls eine negative oder zu grosse Zahl uebergeben wird
	 */
	public void setBinary(String s) throws NumberFormatException, ArithmeticException {
		long prod = 0;
		long zahl = 0;
		// Schleife, um den String von hinten nach vorne abzugehen
		for (int i = s.length() - 1; i >= 0; i--) {
			// Bei Binaerzahlen nur Ziffern von 0 bis 1 erlaubt
			if (s.charAt(i) >= '0' && s.charAt(i) <= '1') {
				prod = s.charAt(i) - '0';
				prod = prod * ((long) Math.pow(2, s.length() - i - 1));
				zahl = zahl + prod;
				if (prod > Integer.MAX_VALUE || zahl > Integer.MAX_VALUE) {
					throw new ArithmeticException("Zu grosse Zahl!");
				}
			} else if (s.charAt(i) == '-') {
				throw new ArithmeticException("Zu kleine Zahl!");
			} else {
				throw new NumberFormatException("Unerlaubtes Zeichen!");
			}
		}
		this.value = (int) zahl;
	}

	/**
	 * Gibt den Wert als Dezimalzahl zurueck
	 * 
	 * @return String der gespeicherte Wert als Dezimalzahl
	 */
	public String getDecimal() {
		String s = "" + this.value;
		return s;
	}

	/**
	 * Gibt den Wert als Hexadezimalzahl zurueck
	 * 
	 * @return String der gespeicherte Wert als Hexadezimalzahl
	 */
	public String getHexadecimal() {
		String result = "";
		int zahl = this.value;
		char cbit = '0';
		// euklidischer Algorithmus
		do {
			int bit = zahl % 16;
			if (bit > 9) {
				// Ziffern groesser als 9 werden als grosse Buchstaben
				// dargestellt
				cbit = (char) (bit + 55);
				result = result + cbit;
				zahl = (int) zahl / 16;
			} else {
				result = result + bit;
				zahl = (int) zahl / 16;
			}
		} while (zahl > 0);
		// umgekehrte Reihenfolge der Stellen
		StringBuilder s = new StringBuilder(result);
		s = s.reverse();
		result = s.toString();
		// Ende Algorithmus
		return result;
	}

	/**
	 * Gibt den Wert als Binaerzahl zurueck
	 * 
	 * @return String der gespeicherte Wert als Binaerzahl
	 */
	public String getBinary() {
		String result = "";
		int zahl = this.value;
		// euklidischer Algorithmus
		do {
			int bit = zahl % 2;
			result = result + bit;
			zahl = (int) zahl / 2;
		} while (zahl > 0);
		// umgekehrte Reihenfolge der Stellen
		StringBuilder s = new StringBuilder(result);
		s = s.reverse();
		result = s.toString();
		// Ende Algorithmus
		return result;
	}

}
