import java.math.BigInteger;

public class Fakultaet {

	public static void main(String[] args) {
		Fakultaet.teste(1000);
		System.out.println(Fakultaet.getMaxIntFakultaet());
		System.out.println(Fakultaet.getMaxLongFakultaet());
	}

	public static int berechneFakultaetInteger(int n) {
		int f = 1;
		for (int i = n; i > 1; i--) {
			f = f * i;
		}
		return f;
	}

	public static long berechneFakultaetLong(int n) {
		long f = 1;
		for (int i = n; i > 1; i--) {
			f = f * i;
		}
		return f;
	}

	public static void teste(int n) {
		System.out.println("als int: " + n + "! = " + Fakultaet.berechneFakultaetInteger(n));
		System.out.println("als long: " + n + "! = " + Fakultaet.berechneFakultaetLong(n));
		System.out.println("als BigInteger: " + n + "! = " + Fakultaet.berechneFakultaetBigInteger(n));
	}

	public static int getMaxIntFakultaet() {
		Integer i = new Integer(0);
		i = Integer.MAX_VALUE;
		int n = 1;
		BigInteger f = new BigInteger("" + 1);
		BigInteger m = new BigInteger("" + 2);
		BigInteger l = new BigInteger("" + 1);
		for (; m.intValue() < i; m = m.add(l)) {
			f = f.multiply(m);
			n = n * m.intValue();
			if (!f.toString().equals("" + n)) {
				break;
			}
		}
		return (m.intValue() - 1);
	}

	public static int getMaxLongFakultaet() {
		Integer i = new Integer(0);
		i = Integer.MAX_VALUE;
		long n = 1;
		BigInteger f = new BigInteger("" + 1);
		BigInteger m = new BigInteger("" + 2);
		BigInteger l = new BigInteger("" + 1);
		for (; m.longValue() < i; m = m.add(l)) {
			f = f.multiply(m);
			n = n * m.longValue();
			if (!f.toString().equals("" + n)) {
				break;
			}
		}
		return (m.intValue() - 1);
	}

	public static BigInteger berechneFakultaetBigInteger(int n) {
		BigInteger f = new BigInteger("" + 1);
		BigInteger i = new BigInteger("" + n);
		BigInteger m = new BigInteger("" + 1);
		for (; i.intValue() > 1; i = i.subtract(m)) {
			f = f.multiply(i);
		}
		return f;
	}

}
