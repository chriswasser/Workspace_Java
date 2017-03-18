import java.io.FileNotFoundException;

/**
 * Testklasse fuer Klasse GoldTagespreis und GoldPreis
 * 
 * @author cw585968
 *
 */
public class TestGold {

	public static void main(String[] args) {
		try {
			GoldPreis test = new GoldPreis("gold.txt");
			System.out.println(test.getPreis("2009-10-20"));
			System.out.println(test.getPreis("2009-02-07"));
			test.printMinMax();
		} catch (FileNotFoundException e) {
			System.out.println("Datei nicht gefunden");
		}
	}

}
