import java.awt.Point;

public class Test {

	public static void main(String[] args) {
		// Tests for XPoint
		XPoint point1 = new XPoint(5,10);
		System.out.println(point1.isOnLine(new Point(0,0), new Point(1,2)));
		XPoint point2 = new XPoint(1,1);
		System.out.println(point1);
		point1.swap(point2);
		System.out.println(point1);
		System.out.println(point1.getR());
		System.out.println(point1.getPhi());
		// Tests for NewArrayList
		NewArrayList array = new NewArrayList();
		array.add("Dies ist ein String");
		array.add(23.3223113);
		array.add(42412);
		array.add("21342.123");
		array.add("532");
		System.out.println(array.getDoubles());
		System.out.println(array.getIntegers());
		System.out.println(array.getStrings());
	}

}
