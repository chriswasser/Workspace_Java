import java.util.ArrayList;

public class Prime {

	public static ArrayList<Integer> primZahlTest(int n) {
		int schranke = (int) Math.sqrt(n);
		ArrayList<Integer> prime = new ArrayList<>();
		for(int i = 2; i <= n; ++i) {
			prime.add(i);
		}
		for(int i = 2; i <= schranke; ++i) {
			for(int m = 2; m <= (n/i); ++m) {
				prime.remove(new Integer(i*m));
			}
		}
		return prime;
	}
	
	public static void main(String[] args) {
		long time = System.currentTimeMillis();
		System.out.println(primZahlTest(100));
		time = System.currentTimeMillis() - time;
		double timed = time / 1000.;
		System.out.printf("Calculation took: %.3f sec\n", timed);
	}
	
}
