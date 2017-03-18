/**
 * TitForTat is a viable strategy for the game prisoner's dilemma. The player
 * cooperates in the first round. Every following round he copies the opponent's
 * decision.
 * 
 * @author cw585968
 *
 */
public class TitForTat implements GefStrategie {

	private boolean opponentsLastDecision = true;

	@Override
	public boolean getNextDecision() {
		return this.opponentsLastDecision;
	}

	@Override
	public void setOpponentsLastDecision(boolean decision) {
		this.opponentsLastDecision = decision;
	}

}
