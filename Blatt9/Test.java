import java.awt.Point;

public class Test {
	public static void main(String[] args) { 
		Grafik g = new Grafik(300, 300); // Groesse der Grafik
/*
		// Linie von (10/10) nach (200/100)
		// Der Koordinatenursprung ist links oben
		Linie l = new Linie(new Point(10, 10), new Point(200, 100));
		g.add(l);
		g.aktualisiere(0);
*/
		Rechteck r1 = new Rechteck(new Point(100, 100), new Point(200, 200));
		g.add(r1);
		g.aktualisiere(0);
		r1.skaliere(1.5);
		g.aktualisiere(1000);
		Rechteck r2 = new Rechteck(new Point(50, 50), new Point(100, 100));
		g.add(r2);
		g.aktualisiere(1000);
		Rechteck r3 = r1.vereinige(r2);
		g.add(r3);
		g.aktualisiere(1000);
		System.out.println(r3);
	  }
}
