
public class Test {

	public static void main(String[] args) {
		System.out.println(Fakultaet.fakultaet(10));
		System.out.println(Fibonacci.fibonacci(20));
		System.out.println(Summe.summe(15, 20));
		System.out.println(Euklid.ggt(960, 30));
		System.out.println(Pascal.getPascalWert(5, 2));
		Ausgabe.rekursiveAusgabe(12345);
		System.out.println(Reverse.umkehren("Nie fragt sie: Ist gefegt? Sie ist gar fein."));
		Geldautomat.geldautomatV1(463);
		for (Integer i : Geldautomat.geldautomatV2(463)) {
			System.out.println(i);
		}
		for (int i : Geldautomat.geldautomatV3(463)) {
			System.out.println(i);
		}
	}

}
