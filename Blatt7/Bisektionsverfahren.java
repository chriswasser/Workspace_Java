
public class Bisektionsverfahren implements Verfahren {

	@Override
	public double getNullstelle(Funktion f, double xMin, double xMax) {
		if (xMin >= xMax || f.getY(xMin) * f.getY(xMax) >= 0) {
			throw new ArithmeticException("Kein Nullstellenverfahren fuer diese Parameter!");
		}
		double x1 = xMin;
		double x2 = xMax;
		double xm = (x1 + x2) / 2.;
		while ((x2 - x1) > 1e-10) {
			if (Math.abs(f.getY(xm)) < 1e-10) {
				return xm;
			}
			if (f.getY(x1) * f.getY(xm) < 0) {
				x2 = xm;
			} else if (f.getY(x2) * f.getY(xm) < 0) {
				x1 = xm;
			}
			xm = (x1 + x2) / 2.;
		}
		return xm;
	}

}
