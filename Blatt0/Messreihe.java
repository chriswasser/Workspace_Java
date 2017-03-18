import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Locale;
import java.util.Scanner;

public class Messreihe {

	private double[] liste;

	public Messreihe(double[] liste) {
		this.liste = new double[liste.length];
		for (int i = 0; i < liste.length; i++) {
			this.liste[i] = liste[i];
		}
	}

	public Messreihe(String dateiname) throws FileNotFoundException {
		File f = new File(dateiname);
		Scanner sc = new Scanner(f);
		while (sc.hasNextLine()) {
			String zeile = sc.nextLine();
			if ((!zeile.isEmpty()) && (zeile.charAt(0) != '%')) {
				this.liste = new double[Integer.parseInt(zeile)];
				break;
			}
		}
		int i = 0;
		while (sc.hasNextLine()) {
			String zeile = sc.nextLine();
			if ((!zeile.isEmpty()) && (zeile.charAt(0) != '%')) {
				try {
					this.liste[i] = Double.parseDouble(zeile);
				} catch (NumberFormatException e) {
					throw new IllegalArgumentException("Datenzeile hat falsches Datenformat!");
				}
				i++;
			}
		}
		if (i != this.liste.length) {
			throw new ArithmeticException(
					"Anzahl der uebergebenen Messwerte stimmt nicht mir Ihrer Angabe ueberein!");
		}
		sc.close();
	}

	public double getMax() {
		double max = this.liste[0];
		for (int i = 0; i < this.liste.length; i++) {
			if (max < this.liste[i]) {
				max = this.liste[i];
			}
		}
		return max;
	}

	public double getMin() {
		double min = this.liste[0];
		for (int i = 0; i < this.liste.length; i++) {
			if (min > this.liste[i]) {
				min = this.liste[i];
			}
		}
		return min;
	}

	public boolean isEinheitlich() {
		double gleich = this.liste[0];
		for (int i = 0; i < this.liste.length; i++) {
			if (gleich != this.liste[i]) {
				return false;
			}
		}
		return true;
	}

	public int zaehleGroessere(int lim) {
		int groesser = 0;
		for (int i = 0; i < this.liste.length; i++) {
			if (lim < this.liste[i]) {
				groesser = groesser + 1;
			}
		}
		return groesser;
	}

	public int getMaxIndex() {
		int max = 0;
		for (int i = 0; i < this.liste.length; i++) {
			if (this.liste[max] < this.liste[i]) {
				max = i;
			}
		}
		return max;
	}

	public double[] getBereich() {
		double[] feld = new double[2];
		feld[0] = this.getMin();
		feld[1] = this.getMax();
		return feld;
	}

	public int getAnzahl() {
		return (this.liste.length);
	}

	private double getMittelwert() {
		double mittel = 0;
		double summe = 0;
		for (int i = 0; i < this.liste.length; i++) {
			summe = summe + this.liste[i];
			mittel = summe / this.liste.length;
		}
		return mittel;
	}

	public void speichereInfo(String dateiname) throws FileNotFoundException {
		PrintWriter pw = new PrintWriter(dateiname + ".out");
		pw.printf(Locale.US, "Dateiname: " + dateiname + "\n");
		pw.printf(Locale.US, "Anzahl der Daten: " + this.getAnzahl() + "\n");
		pw.printf(Locale.US, "Mittelwert: " + this.getMittelwert() + "\n");
		pw.printf(Locale.US, "Datenbereich: " + this.getBereich()[0] + " - " + this.getBereich()[1] + "\n");
		for (int i = 0; i < this.liste.length; i++) {
			pw.printf(Locale.US, this.liste[i] + "\n");
		}
		pw.close();
	}

}
