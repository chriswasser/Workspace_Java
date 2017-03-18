/**
 * Random is a viable strategy for the game prisoner's dilemma. The player
 * chooses by pure chance to cooperate or betray.
 * 
 * @author cw585968
 *
 */
public class Random implements GefStrategie {

	@Override
	public boolean getNextDecision() {
		int i = (int) (Math.random() * 2);
		return i == 0;
	}

	@Override
	public void setOpponentsLastDecision(boolean decision) {
	}

}
