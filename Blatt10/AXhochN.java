
public class AXhochN implements Funktion {

	private double a;
	private double n;

	@Override
	public double getY(double d) {
		double y = this.a;
		for (int i = 0; i < this.n; i++) {
			y *= d;
		}
		return y;
	}

	@Override
	public Funktion getAbleitung() {
		return get(this.a * this.n, this.n - 1);
	}

	private AXhochN(double a, double n) {
		this.a = a;
		this.n = n;
	}

	public static Funktion get(double a, double n) {
		if (a == 0) {
			return Null.get();
		}
		return new AXhochN(a, n);
	}

	public String toString() {
		if (this.a == 1 && this.n == 1) {
			return "x";
		} else if (this.a == 1) {
			return "x^" + this.n;
		} else if (this.n == 0) {
			return this.a + "";
		} else if (this.n == 1) {
			return this.a + "x";
		} else {
			return this.a + "x^" + this.n;
		}
	}

}
