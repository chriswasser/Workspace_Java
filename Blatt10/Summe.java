
public class Summe implements Funktion {

	private Funktion f;
	private Funktion g;

	@Override
	public double getY(double d) {
		return f.getY(d) + g.getY(d);
	}

	@Override
	public Funktion getAbleitung() {
		return get(f.getAbleitung(), g.getAbleitung());
	}

	private Summe(Funktion f, Funktion g) {
		this.f = f;
		this.g = g;
	}

	public static Funktion get(Funktion f, Funktion g) {
		if (f == Null.get()) {
			return new Summe(Null.get(), g);
		} else if (g == Null.get()) {
			return new Summe(f, Null.get());
		} else {
			return new Summe(f, g);
		}
	}

	public String toString() {
		if (f == Null.get()) {
			return g.toString();
		} else if (g == Null.get()) {
			return f.toString();
		} else {
			return f.toString() + "+" + g.toString();
		}
	}

}
