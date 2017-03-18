/**
 * PerKind is a viable strategy for the game prisoner's dilemma. The player
 * follows the decision chain cooperate -> cooperate -> betray periodically.
 * 
 * @author cw585968
 *
 */
public class PerKind implements GefStrategie {

	private int period = 0;

	@Override
	public boolean getNextDecision() {
		int i = this.period % 3;
		if (i == 2) {
			period++;
			return false;
		} else {
			period++;
			return true;
		}
	}

	@Override
	public void setOpponentsLastDecision(boolean decision) {
	}

}
