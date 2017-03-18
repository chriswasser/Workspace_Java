/**
 * Testklasse fuer Klasse PositiveNumber
 * 
 * @author cw585968
 *
 */
public class TestPositiveNumber {

	public static void main(String[] args) {
		PositiveNumber zs = new PositiveNumber();
		zs.setDecimal("144");
		System.out.println("Binaer: " + zs.getBinary());
		zs.setHexadecimal("affe");
		System.out.println("Dezimal: " + zs.getDecimal());
		zs.setBinary("1000101011");
		System.out.println("Hexadezimal: " + zs.getHexadecimal());
	}

}
