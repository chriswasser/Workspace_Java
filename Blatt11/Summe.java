
public class Summe {

	public static int summe(int anfang, int ende) {
		return (anfang > ende) ? 0 : summe(anfang, ende - 1) + ende;
	}

}
