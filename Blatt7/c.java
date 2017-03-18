
public class c implements Funktion {

	@Override
	public double getY(double x) {
		return x * x - Math.sin(x) - 1;
	}

	@Override
	public String toString() {
		return "Funktion:  f(x) := x^2-sin(x)-1";
	}

}
