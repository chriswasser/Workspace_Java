import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Bundesliga {

	private String[][] results = new String[18][18];
	private String[] vereine = new String[18];

	public Bundesliga(String dateiname) throws FileNotFoundException {
		File f = new File("" + dateiname);
		Scanner sc = new Scanner(f, "UTF-8");
		int j=0;
		while (sc.hasNextLine()) {
			String line = sc.nextLine();
			String verein = "";
			for (int i = 0; i < 25; i++) {
				verein = verein + line.charAt(i);
			}
			verein=verein.trim();
			vereine[j] = verein;
			j=j+1;
		}
		sc.close();
		Scanner sc2 = new Scanner(f,"UTF-8");
		if(sc2.hasNextLine()) {
			for (int m = 0; m < vereine.length - 1; m++) {
				String zeile = sc2.nextLine();
				int z = 25;
				for (int n = 0; n < vereine.length; n++) {
					this.results[m][n] = "";
					this.results[m][n] = this.results[m][n] + zeile.charAt(z) + zeile.charAt(z+1)+zeile.charAt(z+2);
					z = z + 4;
				}
			}
		}
		sc2.close();
	}

	public String getResultat(String heim, String gast) {
		int i = 0;
		boolean existheim = false;
		boolean existgast = false;
		int indexheim = 0;
		int indexgast = 0;
		for (i = 0; i < this.vereine.length; i++) {
			if (this.vereine[i].equals(heim)) {
				existheim = true;
				indexheim = i;
			}
			if (this.vereine[i].equals(gast)) {
				existgast = true;
				indexgast = i;
			}
		}
		if (existgast && existheim) {
			return this.results[indexheim][indexgast];
		} else {
			throw new IllegalArgumentException("Unerlaubter Verein!");
		}
	}

}
