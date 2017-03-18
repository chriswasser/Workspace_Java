
/**
 * Solving algorithm for a Schiebepuzzle. Moves the tiles randomly until the
 * tile with the number 1 is in the top left corner of the puzzle
 * 
 * @author cw585968
 *
 */
public class SchiebAlg1 implements Loesungsalgorithmus {

	@Override
	public void loese(Schiebepuzzle puzzle) {
		while (puzzle.getPuzzle()[0][0] != 1) {
			int number = -1;
			while (true) {
				number = (int) (Math.random() * 16);
				if (puzzle.istVerschiebbar(number)) {
					puzzle.schiebe(number);
					break;
				}
			}

		}
	}

}
