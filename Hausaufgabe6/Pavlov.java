/**
 * Pavlov is a viable strategy for the game prisoner's dilemma. The player
 * cooperates in the first round. Afterwards he bases his decision on the
 * equality of the two players' decisions from last round. If they are equal,
 * the player will cooperate. Otherwise he will betray.
 * 
 * @author cw585968
 *
 */
public class Pavlov implements GefStrategie {

	private boolean opponentsLastDecision = true;
	private boolean myLastDecision = true;

	@Override
	public boolean getNextDecision() {
		if (this.myLastDecision == this.opponentsLastDecision) {
			this.myLastDecision = true;
			return true;
		} else {
			this.myLastDecision = false;
			return false;
		}
	}

	@Override
	public void setOpponentsLastDecision(boolean decision) {
		this.opponentsLastDecision = decision;
	}

}
