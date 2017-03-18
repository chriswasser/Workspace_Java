/**
 * Klasse MyArrayList um eine eigen modellierte mitwachsende Liste zu erstellen
 * 
 * @author cw585968
 *
 */
public class MyArrayList {
	private int[] arr = new int[10];
	private int size = 0;

	/**
	 * Haengt das ein Element an die Liste an
	 * 
	 * @param i
	 *            Wert des Elements, welches hinten an die Liste angehaengt wird
	 */
	public void add(int i) {
		// muss das Array vergroessert werden?
		if (size == arr.length) {
			int[] help = arr.clone();
			arr = new int[help.length * 2];
			// arr[] wird in ein doppelt so grosses Array kopiert
			System.arraycopy(help, 0, arr, 0, help.length);
		}
		this.arr[size] = i;
		size++;
	}

	/**
	 * Gibt das Element an der angegebenen Stelle zurueck
	 * 
	 * @param pos
	 *            gewuenschte Stelle im Array
	 * @return int Wert der gewuenschten Stelle
	 * @throws IllegalArgumentException
	 *             falls gewuenschte Position nicht in der Arraygroesse liegt
	 */
	public int get(int pos) throws ArrayIndexOutOfBoundsException {
		// ist pos eine gueltige Position?
		if (pos >= 0 && pos < size) {
			return this.arr[pos];
		} else {
			throw new ArrayIndexOutOfBoundsException("Position nicht vorhanden!");
		}
	}

	/**
	 * Gibt die Liste als String zurueck in der Form [1,2,3,4,...,n]
	 */
	public String toString() {
		String ret = "[";
		// wenn die Liste leer ist wird "[]" zurueck gegeben
		if (this.size == 0) {
			return "[]";
		}
		// setzt alle elemente in den String ein, mit einem "," getrennt
		for (int i = 0; i < this.size; i++) {
			ret += this.arr[i] + ",";
		}
		// entfernt das letzte ","
		ret = ret.substring(0, ret.length() - 1);
		ret += "]";
		return ret;
	}

	/**
	 * Leert die Liste komplett (als ware sie neu erstellt worden)
	 */
	public void clear() {
		this.arr = new int[10];
		size = 0;
	}

	/**
	 * Gibt die Anzahl der aufgenommenen Elemente zurueck
	 * 
	 * @return int Anzahl der aufgenommenen Elemente zurueck
	 */
	public int size() {
		return this.size;
	}

	/**
	 * Gibt die Groesse der Liste an also belegte Elemente und freie Elemente
	 * 
	 * @return int Groesse der Liste (belegte und freie Elemente)
	 */
	public int capacity() {
		return this.arr.length;
	}

	/**
	 * Gibt einen Klon des this-Objekts zurueck die Datenkapselung wird dabei
	 * beachtet!
	 */
	public MyArrayList clone() {
		MyArrayList list = new MyArrayList();
		// setzt die Attribute in der neuen MyArrayList auf Klone der Attribute
		// des this-Objekts
		list.arr = this.arr.clone();
		list.size = this.size;
		return list;
	}

	/**
	 * Fuegt ein Element an der Stelle pos ein und verschiebt alle folgenden
	 * Elemente eine Position nach hinten.
	 * 
	 * @param i
	 *            Wert, den das eingefuegte Elemente erhaelt
	 * @param pos
	 *            Position, an der das Element eingefuegt werden soll
	 * @throws ArrayIndexOutOfBoundsException
	 *             falls pos keine gueltige Position ist
	 */
	public void add(int i, int pos) throws ArrayIndexOutOfBoundsException {
		// ist pos eine gueltige Position in der Liste?
		if (pos >= 0 && pos < size) {
			// muss das Array verlaengert werden?
			if (size == arr.length) {
				int[] help = arr.clone();
				arr = new int[help.length * 2];
				System.arraycopy(help, 0, arr, 0, help.length);
			}
			// alle Elemente hinter pos(inklusive) werden einen nach hinten
			// kopiert
			System.arraycopy(arr, pos, arr, pos + 1, arr.length - pos - 1);
			// an arr[pos] wird das neue Element eingesetzt
			this.arr[pos] = i;
			size++;
		} else {
			throw new ArrayIndexOutOfBoundsException("Position nicht vorhanden!");
		}
	}

	/**
	 * Entfernt das Element an der Stelle pos und verschiebt alle Folgeelemente
	 * eine Position nach vorne wenn arr[] dannach dreimal so gross ist wie
	 * size, wird die laenge von arr[] halbiert
	 * 
	 * @param pos
	 * @throws ArrayIndexOutOfBoundsException
	 */
	public void delete(int pos) throws ArrayIndexOutOfBoundsException {
		// ist post eine gueltige Position?
		if (pos >= 0 && pos < size) {
			// kann das Array verkleinert werden?
			if (size - 1. <= arr.length / 3.) {
				// Array wird in ein halb so grosses Array kopiert
				int[] help = arr.clone();
				double d = help.length / 2.;
				int i = help.length / 2;
				if (d == i) { // wenn division glatt aufgeht
					arr = new int[help.length / 2];
				} else { // aufrunden bei division
					arr = new int[(help.length / 2) + 1];
				}
				System.arraycopy(help, 0, arr, 0, size);
			}
			// kopiert alle Elemente hinter pos einen nach vorne
			// pos "verschwindet" dadurch
			System.arraycopy(arr, pos + 1, arr, pos, arr.length - pos - 1);
			size--;
		} else {
			throw new ArrayIndexOutOfBoundsException("Position nicht vorhanden!");
		}
	}

	public static void main(String[] args) {
		MyArrayList myArrayList = new MyArrayList();
		// fuege die Zahlen 0-9 zur Liste hinzu
		for (int i = 0; i < 10; i++) {
			myArrayList.add(i);
		}
		System.out.println(myArrayList);// [0,1,2,3,4,5,6,7,8,9]
		// die Liste hat nun 10 Elemente
		System.out.println(myArrayList.size()); // 10
		// fuege die Zahl 5 an der Position 2 der Liste hinzu
		myArrayList.add(5, 2);
		System.out.println(myArrayList);// [0,1,5,2,3,4,5,6,7,8,9]
		// entferne die Elemente 1-6
		for (int i = 6; i > 0; i--) {
			myArrayList.delete(i);
			System.out.print(myArrayList.capacity() + "/");
			System.out.println(myArrayList.size());
		}
		System.out.println(myArrayList);// [0,6,7,8,9]
		// gebe das Element an der Position 2 aus
		System.out.println(myArrayList.get(2));// 7 //erzeugt einen Klon der
												// Liste
		MyArrayList myArrayList2 = myArrayList.clone(); // Loesche die Liste
		myArrayList.clear();
		System.out.println(myArrayList);// []
		System.out.println(myArrayList2);// [0,6,7,8,9]

	}
}