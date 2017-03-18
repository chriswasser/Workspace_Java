import java.io.FileNotFoundException;

public class TestBundesliga {

	public static void main(String[] args) {
		try {
			Bundesliga Test = new Bundesliga("bundesliga1314.txt");
			System.out.println(Test.getResultat("FC Bayern München", "Bayer 04 Leverkusen"));
			System.out.println(Test.getResultat("VfB Stuttgart", "Werder Bremen"));			
		} catch (FileNotFoundException e) {
			System.out.println("Fehler");
		}
	}

}
