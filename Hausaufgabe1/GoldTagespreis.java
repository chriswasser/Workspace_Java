/**
 * Enthaelt ein Datum mit dem dazugehoerigen Goldpreis des Tages
 * 
 * @author cw585968
 *
 */
public class GoldTagespreis {

	/**
	 * Datum des entsprechenden Goldpreises
	 */

	public String datum;
	/**
	 * Preis des angegebenen Datums
	 */

	public double preis;

	/**
	 * Konstruktor der Klasse GoldTagespreis. Erzeugt ein neues Objekt der
	 * Klasse Goldtagespreis mit datum und preis.
	 * 
	 * @param datum
	 *            Datum des dazugehoerigen Goldpreises
	 * @param preis
	 *            Preis des dazugehoerigen Datums
	 */

	public GoldTagespreis(String datum, double preis) {
		this.datum = datum;
		this.preis = preis;
	}

	/**
	 * Gibt einen formatierten String mit Information ueber Datum und Goldpreis
	 * aus.
	 * 
	 * @return String
	 */

	public String toString() {
		String result = "Der Goldpreis am " + this.datum + " war " + this.preis;
		return result;
	}

}
