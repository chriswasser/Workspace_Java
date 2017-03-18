/**
 * Test-class of the prisoner's dilemma game
 * 
 * @author cw585968
 *
 */
public class DasSpiel {

	public static void main(String[] args) {
		// Neues Objekt vom Typ GefDilemma mit 2 Spielern
		GefDilemma gd = new GefDilemma(new TitForTat(), new PerKind());
		// 100 mal spielen
		gd.spiele(100);
		// expected result: tie with 233 points each.
	}

}
