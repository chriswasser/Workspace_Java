/**
 * Spite is a viable strategy for the game prisoner's dilemma. The player
 * cooperates as long as the opponent does not betray. But if the opponent
 * betrays once, the player will always betray in the future himself.
 * 
 * @author cw585968
 *
 */
public class Spite implements GefStrategie {

	private boolean opponentsLastDecision = true;
	private boolean trigger = false;

	@Override
	public boolean getNextDecision() {
		if (!trigger && this.opponentsLastDecision) {
			return true;
		} else {
			trigger = true;
			return false;
		}
	}

	@Override
	public void setOpponentsLastDecision(boolean decision) {
		this.opponentsLastDecision = decision;
	}

}
