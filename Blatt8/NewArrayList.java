import java.util.ArrayList;

public class NewArrayList extends ArrayList<Object> {

	public void add(String x) {
		try {
			int i = Integer.parseInt(x);
			this.add(i);
		} catch (NumberFormatException e) {
			try {
				double d = Double.parseDouble(x);
				this.add(d);
			} catch (NumberFormatException f) {
				super.add(x);
			}
		}
	}

	public void add(int x) {
		Integer i = new Integer(x);
		this.add(i);
	}

	public void add(double x) {
		Double d = new Double(x);
		this.add(d);
	}

	public ArrayList<Integer> getIntegers() {
		ArrayList<Integer> result = new ArrayList<Integer>();
		for (Object element : this) {
			if (element instanceof Integer) {
				result.add((Integer) element);
			}
		}
		return result;
	}

	public ArrayList<Double> getDoubles() {
		ArrayList<Double> result = new ArrayList<Double>();
		for (Object element : this) {
			if (element instanceof Double) {
				result.add((Double) element);
			}
		}
		return result;
	}

	public ArrayList<String> getStrings() {
		ArrayList<String> result = new ArrayList<String>();
		for (Object element : this) {
			if (element instanceof Double || element instanceof Integer || element instanceof String) {
				result.add(element.toString());
			} else {
				throw new WrongElementException(this.indexOf(element));
			}
		}
		return result;
	}

	public NewArrayList() {
		super();
	}

}
