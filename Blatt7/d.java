
public class d implements Funktion {

	@Override
	public double getY(double x) {
		return x * x * x * x + x * x * x - 5;
	}

	@Override
	public String toString() {
		return "Funktion:  f(x) := x^4+x^3-5";
	}

}
