import java.util.ArrayList;
import java.util.Arrays;

public class Rechenoperationsliste {

	private ArrayList<Rechenoperation> operations;

	/**
	 * default constructor: initializes the List of operations
	 */
	public Rechenoperationsliste() {
		this.operations = new ArrayList<Rechenoperation>();
	}

	/**
	 * queues up a new operation in the list of existing ones
	 * 
	 * @param operation
	 *            operation to be added to the list
	 */
	public void add(Rechenoperation operation) {
		this.operations.add(operation);
	}

	/**
	 * transforms a field of doubles; uses the list of operations and executes
	 * them in order on every element in the field
	 * 
	 * @param feld
	 *            the field to use the operations on
	 * @return the transformed field
	 */
	public double[] transform(double[] feld) {
		double[] temp = feld.clone();
		for (int i = 0; i < temp.length; i++) {
			for (int j = 0; j < operations.size(); j++) {
				temp[i] = operations.get(j).berechne(temp[i]);
			}
		}
		return temp;
	}

	public static void main(String[] args) {
		double[] ausgangsfeld = { 1, 3, 5, 6 };
		Rechenoperationsliste r = new Rechenoperationsliste();
		// Berechnet die Funktion (x^2)+2
		r.add(new Quadrat());
		r.add(new Addition(2));
		// Berechnung und Ausgabe
		double[] test1 = r.transform(ausgangsfeld);
		// ergibt {3,11,27,38}
		System.out.println(Arrays.toString(test1));
		// fuegt der Rechenoperationsliste eine weitere Rechenoperation hinzu
		// berechnet Math.sqrt((x^2)+2)
		r.add(new Quadratwurzel());
		// Berechnung und Ausgabe
		double[] test2 = r.transform(ausgangsfeld);
		// ergibt { 1.7320508075688772,
		// 3.3166247903554,
		// 5.196152422706632,
		// 6.164414002968976}
		System.out.println(Arrays.toString(test2));
	}

}
