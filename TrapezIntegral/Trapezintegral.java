import javax.swing.JOptionPane;

public class Trapezintegral {

	public static void main(String[] args) {
		int flaechen;
		try {
			flaechen = Integer.parseInt(JOptionPane.showInputDialog("Anzahl Flächen:"));
		} catch (Exception e) {
			flaechen = 50;
		}
		int a = 1;
		int b = 2;
		double intervallGroesse = (b - a) / (double) flaechen;
		System.out.println("Funktion: 1/x");
		System.out.println("Intervall: [" + a + "," + b + "]");
		System.out.println("Anzahl Teilflaechen: " + flaechen);
		System.out.println("Intervallgroesse: " + intervallGroesse);
		double current = a;
		double integral = 0;
		for (int i = 0; i < flaechen; ++i) {
			double teilflaeche = intervallGroesse * (((1 / current) + (1 / (current + intervallGroesse))) / 2);
			integral += teilflaeche;
			current += intervallGroesse;
		}
		System.out.println("Numerische Loesung: " + integral);
		System.out.println("Correct Value: " + (Math.log(b) - Math.log(a)));
	}

}
