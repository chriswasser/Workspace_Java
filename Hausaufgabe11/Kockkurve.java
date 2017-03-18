
/**
 * class Kochkurve gives the ability to create the Kochkurve of each
 * iteration-step
 *
 */
public class Kockkurve {

	/**
	 * prints the points, which need to be connected, to get the rek th
	 * iteration of the Kochkurve
	 * 
	 * @param ax
	 *            x-Koordinate des Startpunktes
	 * @param ay
	 *            y-Koordinate des Startpunktes
	 * @param bx
	 *            x-Koordinate des Endpunktes
	 * @param by
	 *            y-Koordinate des Endpunktes
	 * @param rek
	 *            Tiefe der Rekursion
	 */
	public static void kochKurve(double ax, double ay, double bx, double by, double rek) {
		// wenn die Rekursionstiefe 0 beträgt, wird der Anfangspunkt ausgegeben
		if (((int) rek) == 0) {
			System.out.printf("(%.1f/%.1f)\n", ax, ay);
		} else {
			// Rekursionstiefe beim nächsten Aufruf um eins verringern
			rek--;
			// erster Punkt
			double x1 = ax + (bx - ax) / 3;
			double y1 = ay + (by - ay) / 3;
			// zweiter Punkt
			double x2 = ax + (bx - ax) / 2 + (Math.sqrt(3) / 2) * ((by - ay) / 3);
			double y2 = ay + (by - ay) / 2 - (Math.sqrt(3) / 2) * ((bx - ax) / 3);
			// dritter Punkt
			double x3 = bx - (bx - ax) / 3;
			double y3 = by - (by - ay) / 3;
			// rekursive Aufrufe
			kochKurve(ax, ay, x1, y1, rek);
			kochKurve(x1, y1, x2, y2, rek);
			kochKurve(x2, y2, x3, y3, rek);
			kochKurve(x3, y3, bx, by, rek);
		}
	}

	public static void main(String[] args) {
		for (int i = 0; i < 3; ++i) {
			System.out.printf("%d. Iteration der Koch-Kurve:\n", i);
			kochKurve(0, 500, 500, 500, i);
			// da immer nur die Anfangspunkte ausgegeben werden, muss am Ende
			// noch
			// der Endpunkt ausgegeben werden
			System.out.println("(500,0/500,0)");
		}
	}
}
