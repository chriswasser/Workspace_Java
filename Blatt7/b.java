
public class b implements Funktion {

	@Override
	public double getY(double x) {
		return Math.log(Math.abs(x + 1)) - Math.sin(2 * x) - 0.5;
	}

	@Override
	public String toString() {
		return "Funktion:  f(x) := ln|x+1|-sin(2x)-0.5";
	}

}
