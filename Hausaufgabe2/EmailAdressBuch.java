import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Klasse EmailAdressBuch zur Verwaltung von Personennamen und E-Mail-Adressen
 * 
 * @author cw585968
 *
 */
public class EmailAdressBuch {

	private HashMap<String, String> adressBuch;

	/**
	 * Konstruktor der Klasse EmailAdressBuch
	 */
	public EmailAdressBuch() {
		adressBuch = new HashMap<>();
	}

	/**
	 * Fuegt eine neue Adresse hinzu
	 * 
	 * @param name
	 *            Name der Person
	 * @param adresse
	 *            E-Mail-Adresse der Person
	 */
	public void einfuegen(String name, String adresse) {
		adressBuch.put(name, adresse);
	}

	/**
	 * Gibt die adresse passend zum Namen zurueck
	 * 
	 * @param name
	 *            Name der gesuchten Person
	 * @return String E-Mail-Adresse der gesuchten Person
	 * @throws UnknownNameException
	 *             falls der Name nicht im adressBuch steht
	 */
	public String abfrage(String name) throws UnknownNameException {
		if (adressBuch.get(name) != null) {
			return adressBuch.get(name);
		}
		throw new UnknownNameException("Name nicht vorhanden!");
	}

	/**
	 * Gibt das adressBuch als String zurueck, in der Form {name1=adresse1,
	 * name2=adresse2, ....}
	 */
	public String toString() {
		ArrayList<String> names = new ArrayList<>(this.adressBuch.keySet());

		// durchlaeuft alle Namen aus der ArrayList names und damit auch das
		// adressBuch
		String ret = "{";
		for (int i = 0; i < names.size(); i++) {
			ret += names.get(i) + "=" + adressBuch.get(names.get(i)) + ", ";
		}
		// entfernt das letzte anfeguegte ", "
		ret = ret.substring(0, ret.length() - 3);
		ret += "}";

		return ret;
	}

	/*
	 * interne Methode um das adressBuch aus einem Scanner einzulesen
	 */
	private void einlesenScanner(Scanner scanner) {
		String line[];
		while (scanner.hasNextLine()) {
			line = scanner.nextLine().split(";");
			// line[0] ist der Name, line[1] die Adresse
			adressBuch.put(line[0], line[1]);
		}
	}

	/**
	 * Liest aus einer angegebenen Datein Personen und E-Mail-Adressen ein
	 * 
	 * @param dateiname
	 *            Dateiname in dem Personen mit ihren E-Mail-Adressen stehen
	 */
	public void einlesen(String dateiname) {
		File file = new File(dateiname);
		try {
			Scanner scanner = new Scanner(file);
			einlesenScanner(scanner);
			scanner.close();
		} catch (FileNotFoundException e) {
			System.out.println("Dateiname ungueltig");
		}
	}

	/**
	 * Liest aus einer angegebenen URL Personen und ihre E-Mail-Adressen ein
	 * 
	 * @param url
	 *            URL in der die Personen mit ihren E-Mail-Adressen stehen
	 */
	public void mitarbeiterEinlesen(URL url) {
		try {
			URLConnection connection = url.openConnection();
			Object content = connection.getContent();
			Scanner scanner = new Scanner((InputStream) content);
			einlesenScanner(scanner);
		} catch (IOException e) {
			System.out.println("Fehler!");
		}
	}
}