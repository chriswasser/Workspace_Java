import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 * Speichert eine Liste von GoldTagespreisen
 * 
 * @author cw585968
 *
 */

public class GoldPreis {

	private ArrayList<GoldTagespreis> list = new ArrayList<>();

	/**
	 * Konstruktor der Klasse GoldPreis: Erzeugt ein neues Objekt der Klasse
	 * GoldPreis. Erhaelt eine Datei mit Tagen und ihren jeweiligen Goldpreise.
	 * Anlegen von GoldTagespreis-Elementen fuer eine Liste.
	 * 
	 * @param dateiname
	 *            Dateiname, der die Werte von Tagen und ihrer Goldpreise
	 *            enthaelt
	 * @throws FileNotFoundException
	 *             falls Datei nicht gefunden wird
	 */

	public GoldPreis(String dateiname) throws FileNotFoundException {
		File f = new File(dateiname);
		try (Scanner sc = new Scanner(f)) { // ARM-Block
			while (sc.hasNextLine()) {
				String s = sc.nextLine();
				// split von Datum und Preis
				String[] feld = s.split("\t");
				String datum = feld[0];
				String help = "";
				// korrekte Formatierung von double-Preis
				for (int j = 0; j < feld[1].length(); j++) {
					if (feld[1].charAt(j) == '.') {
						continue;
					} else if (feld[1].charAt(j) == ',') {
						help = help + ".";
					} else {
						help = help + feld[1].charAt(j);
					}
				}
				feld[1] = help;
				double preis = 0;
				// kein Nachweis fuehrt zum preis -1
				if (feld[1].equals("kein Nachweis")) {
					preis = -1;
				} else {
					preis = Double.parseDouble(feld[1]);
				}
				// GoldTagespreis-Element mit ausgelesenem Datum und Preis wird
				// an list angehaengt
				GoldTagespreis g = new GoldTagespreis(datum, preis);
				list.add(g);
			}
		}
	}

	/**
	 * Sucht Tagespreis zum uebergebenen Datum heraus
	 * 
	 * @param datum
	 *            Tag des Goldpreises, der herausgefunden werden soll
	 * @return double TagesGoldpreis
	 */

	public double getPreis(String datum) {
		GoldTagespreis g = new GoldTagespreis(datum, 0);
		double price = 0;
		boolean exists = false; // Variable, um zu testen ob Datum existiert
		for (int i = 0; i < list.size(); i++) {
			if (g.datum.equals(list.get(i).datum)) {
				exists = true;
				price = list.get(i).preis;
				break;
			}
		}
		if (exists) {
			return price;
		} else {
			throw new NumberFormatException("Datum nicht gefunden!");
		}
	}

	/**
	 * Gibt maximalen und minimalen Goldpreis aus sowie die Tage an denen diese
	 * erreicht wurden
	 */

	public void printMinMax() {
		GoldTagespreis min = new GoldTagespreis("0", 0);
		// sucht erstes Element wo Preis einen korrekten Wert hat (nicht -1)
		for (int m = 0; m < list.size(); m++) {
			if (list.get(m).preis != -1) {
				min = new GoldTagespreis(list.get(0).datum, list.get(0).preis);
				break;
			}
		}
		// -1 Wert spielt bei maximum keine Rolle, da sofort ersetzt werden
		// wuerde
		GoldTagespreis max = new GoldTagespreis(list.get(0).datum, list.get(0).preis);
		String minlist = ""; // speichert alle Tage mit kleinsten Wert
		String maxlist = ""; // speichert alle Tage mit groesstem Wert
		for (int i = 0; i < list.size(); i++) {
			// ueberspringt unkorrekte (-1) Werte
			if (list.get(i).preis == -1) {
				continue;
			} else {
				if (list.get(i).preis < min.preis) {
					min = list.get(i);
					minlist = "";
				} else if (list.get(i).preis == min.preis) {
					if (list.get(i).datum.equals(min.datum)) {
					} else {
						minlist = minlist + " " + min.datum;
						min = list.get(i);
					}
				}
				if (list.get(i).preis > max.preis) {
					max = list.get(i);
					maxlist = "";
				} else if (list.get(i).preis == max.preis) {
					if (list.get(i).datum.equals(max.datum)) {
					} else {
						maxlist = maxlist + " " + max.datum;
						max = list.get(i);
					}
				}
			}
		}
		// korrekte Formatierung des Strings fuer die Ausgabe
		if (minlist.equals("")) {
			minlist = min.datum;
		} else {
			minlist = minlist + " " + min.datum;
		}
		if (maxlist.equals("")) {
			maxlist = max.datum;
		} else {
			maxlist = maxlist + " " + max.datum;
		}
		// Ausgabe
		System.out.println("Den niedrigsten Goldpreis von " + min.preis + " gab es an den folgenden Tagen:");
		System.out.println(minlist);
		System.out.println("Den hoechsten Goldpreis von " + max.preis + " gab es an den folgenden Tagen:");
		System.out.println(maxlist);
	}

}
