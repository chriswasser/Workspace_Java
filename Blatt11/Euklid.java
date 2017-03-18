
public class Euklid {

	public static long ggt(long a, long b) {
		if (a == b) {
			return a;
		}
		return (a > b) ? ggt(a - b, b) : ggt(a, b - a);
	}

}
