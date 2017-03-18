/**
 * Strategy interface
 * 
 * @author cw585968
 *
 */
public interface GefStrategie {

	/**
	 * Returns the decision for the next move of the player.
	 * 
	 * @return boolean whether the player cooperates or does not cooperate
	 */
	public boolean getNextDecision();

	/**
	 * The player receives the opponents last decision.
	 * 
	 * @param decision
	 *            which was made by his opponent
	 */
	public void setOpponentsLastDecision(boolean decision);

}
