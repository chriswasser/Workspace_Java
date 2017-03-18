
public class Pascal {

	public static int getPascalWert(int i, int j) {
		return (j == 0 || j == i) ? 1 : getPascalWert(i-1, j) + getPascalWert(i-1,j-1);
	}
	
}
