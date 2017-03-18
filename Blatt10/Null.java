
public class Null implements Funktion {

	private static final Null n = new Null();

	@Override
	public double getY(double d) {
		return 0;
	}

	@Override
	public Funktion getAbleitung() {
		return Null.n;
	}

	public String toString() {
		return "0";
	}

	private Null() {

	}

	public static Funktion get() {
		return Null.n;
	}

}
