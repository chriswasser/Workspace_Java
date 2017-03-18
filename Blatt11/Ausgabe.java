
public class Ausgabe {
	public static void rekursiveAusgabe(int n) {
		if (n > 9) {
			// rekursiveAusgabe(n/10);
			System.out.println(n % 10);
			rekursiveAusgabe(n / 10);
		} else {
			System.out.println(n);
		}
	}
}
