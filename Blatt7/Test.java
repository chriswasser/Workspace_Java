
public class Test {

	public static void main(String[] args) {
		double start = 0.0;
		double end = 10.0;
		Funktion[] feld = new Funktion[5];
		feld[0] = new a();
		feld[1] = new b();
		feld[2] = new c();
		feld[3] = new d();
		feld[4] = (double x) -> (x*x-2); // mit Lambda ist Ausgabe inkorrekt
		Verfahren bi = new Bisektionsverfahren();
		Verfahren se = new Sekantenverfahren();
		for (int i = 0; i < feld.length; i++) {
			System.out.println(feld[i].toString() + " in (" + start + "," + end + ")");
			System.out.println("  Nullstelle:        " + bi.getNullstelle(feld[i], start, end) + " (Bisektion)");
			System.out.println("  Nullstelle:        " + se.getNullstelle(feld[i], start, end) + " (Sekantenverfahren)");
			System.out.println("\n-------------------------------------------------------------------");
		}
	}

}
