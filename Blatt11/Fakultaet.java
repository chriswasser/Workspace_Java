
public class Fakultaet {

	public static long fakultaet(int n) {
		return n == 0 ? 1 : n * fakultaet(n - 1);
	}

}
