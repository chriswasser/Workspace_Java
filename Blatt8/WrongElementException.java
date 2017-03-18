
public class WrongElementException extends RuntimeException {

	private int index;

	public WrongElementException(int index) {
		super("Wrong data element in " + index);
		this.index = index;
	}

	public int getIndex() {
		return this.index;
	}
}
