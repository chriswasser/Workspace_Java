
public class Reverse {

	public static String umkehren(String s) {
		return s.equals("") ? "" : umkehren(s.substring(1)) + s.charAt(0);
	}

}
