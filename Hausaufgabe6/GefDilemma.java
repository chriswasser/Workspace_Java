
/**
 * class GefDilemma is the class for the implementation of a turn-based game
 * called "Gefangenendilemma" for two players. In each round the players have
 * the choice between cooperating or betray. Depending on the choice of both
 * players each player gets a different count of penalty points. The goal is to
 * get as least penalty points as possible.
 * 
 * @author cw585968
 *
 */
public class GefDilemma {

	// strategies for player1 and player2
	private GefStrategie player1;
	private GefStrategie player2;
	// penalty point count for player1 and player2
	private long pointsP1;
	private long pointsP2;

	/**
	 * Constructor of GefDilemma; sets the two strategies each player follows
	 * and sets the start values of the penalty points to zero.
	 * 
	 * @param player1
	 *            strategy of player1
	 * @param player2
	 *            strategy of player2
	 */
	public GefDilemma(GefStrategie player1, GefStrategie player2) {
		this.player1 = player1;
		this.player2 = player2;
		this.pointsP1 = 0;
		this.pointsP2 = 0;
	}

	/**
	 * Performs the game n turns.
	 * 
	 * @param n
	 *            number of turns of the game
	 */
	public void spiele(int n) {
		for (int i = 0; i < n; i++) {
			// get the players' next decisions
			boolean player1 = this.player1.getNextDecision();
			boolean player2 = this.player2.getNextDecision();
			// distribute points according to the decision
			if (player1 && player2) {
				this.pointsP1 += 2;
				this.pointsP2 += 2;
			} else if (!player1 && !player2) {
				this.pointsP1 += 4;
				this.pointsP2 += 4;
			} else if (!player1 && player2) {
				this.pointsP2 += 5;
			} else {
				this.pointsP1 += 5;
			}
			// inform the players about their opponents last decision
			this.player1.setOpponentsLastDecision(player2);
			this.player2.setOpponentsLastDecision(player1);
		}
		// show the results on screen
		if (this.pointsP1 > this.pointsP2) {
			System.out.printf("Ergebnis: Spieler2 gewinnt mit %d Punkten zu %d Punkten.", this.pointsP2, this.pointsP1);
		} else if (this.pointsP1 < this.pointsP2) {
			System.out.printf("Ergebnis: Spieler1 gewinnt mit %d Punkten zu %d Punkten.", this.pointsP1, this.pointsP2);
		} else {
			System.out.printf("Ergebnis: Gleichstand mit jeweils %d Punkten.", this.pointsP1);
		}
	}

}
