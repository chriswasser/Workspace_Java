
/**
 * Test class for Schiebepuzzle and its solving algorithms
 * 
 * @author cw585968
 *
 */
public class TestPuzzle {

	public static void main(String[] args) {
		Schiebepuzzle puzzle = new Schiebepuzzle();
		System.out.println(puzzle);
		// Mischen nicht vergessen, ansonsten hat der Spieler sehr schnell
		// gewonnen
		puzzle.mische();
		System.out.println(puzzle);
		// Testen des Loesungsalgorithmus
		// -> zufaellig schieben
		SchiebAlg1 alg1 = new SchiebAlg1();
		alg1.loese(puzzle);
		System.out.println(puzzle);
	}

}
