import java.util.Comparator;

public class BlattVergleich implements Comparator<Blatt> {

	@Override
	/**
	 * compares 2 objects of type Blatt.
	 * triple > pair > sum
	 * if pairs are the same, the pair with the bigger components wins
	 * if the pairs have the same value, the last card decides who wins
	 *
	 * @return
	 * 		1 if the first argument wins
	 * 		0 if its a draw
	 * 		-1 if the second argument wins
	 */
	public int compare(Blatt o1, Blatt o2) {
		/*
		 * if					triple
		 * 		if				  pair
		 * 			if			    sum
		 * 			else if		    sum
		 * 			else		    sum
		 * 		else if			  pair
		 * 		else			  pair
		 * else if				triple
		 * else					triple
		 */
		// if players have the same triple, pair and sum will be the same too
		// if players both dont have a triple, check pairs and sum
		if (triple(o1) == triple(o2)) {
			if (pair(o1) == pair(o2)) {
				// both players have pairs with the same value or no pairs. sum decides
				if (sum(o1) > sum(o2)) {
					return 1;
				} else if (sum(o1) < sum(o2)) {
					return -1;
				} else {
					return 0;
				}
			}
			// pair 1 wins over pair 2
			else if (pair(o1) > pair(o2)) {
				return 1;
			}
			// pair 2 must be bigger than 1 and wins
			else {
				return -1;
			}
		}
		// triple 1 wins over triple 2
		else if(triple(o1) > triple(o2)){
			return 1;
		}
		// triple 2 must be bigger than triple 1
		else{
			return -1;
		}
	}

	/**
	 *
	 * @param b
	 * @return
	 * 		if b has a pair, it returns its value, else -1
	 */
	public int pair(Blatt b) {
		int[] blatt = b.getBlatt();
		//card 0 and 1 pair
		if (blatt[0] == blatt[1] && blatt[0] != blatt[2]) {
			return blatt[0];
		}
		//card 0 and 2 pair
		else if (blatt[0] == blatt[2] && blatt[0] != blatt[1]) {
			return blatt[0];
		}
		//card 1 and 2 pair
		else if (blatt[1] == blatt[2] && blatt[1] != blatt[0]) {
			return blatt[1];
		}
		return -1;
	}

	/**
	 *
	 * @param b the player's hand
	 * @return
	 * 		if b has a triple it returns its value, else -1
	 */
	public int triple(Blatt b) {
		int[] blatt = b.getBlatt();
		if (blatt[0] == blatt[1] && blatt[1] == blatt[2]) {
			return blatt[0];
		} else {
			return -1;
		}
	}

	/**
	 *
	 * @param b the player's hand
	 * @return
	 * 		sum of all cards in the given deck
	 */
	public int sum(Blatt b) {
		int[] blatt = b.getBlatt();
		return (blatt[0] + blatt[1] + blatt[2]);
	}

}
