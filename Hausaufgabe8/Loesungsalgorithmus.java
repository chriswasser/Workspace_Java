
/**
 * Interface for different solving algorithms for a Schiebepuzzle
 * 
 * @author cw585968
 *
 */
public interface Loesungsalgorithmus {
	/**
	 * Solves a Schiebepuzzle, which means bringing it to its ordered
	 * configuration
	 * 
	 * @param puzzle
	 *            which needs to be solved
	 */
	public void loese(Schiebepuzzle puzzle);

}
