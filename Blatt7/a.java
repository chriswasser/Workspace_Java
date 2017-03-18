
public class a implements Funktion {

	@Override
	public double getY(double x) {
		return Math.exp(x) - 4;
	}

	@Override
	public String toString() {
		return "Funktion:  f(x) := exp(x)-4";
	}
}
