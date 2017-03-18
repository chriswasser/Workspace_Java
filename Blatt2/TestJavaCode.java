import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.JFileChooser;

public class TestJavaCode {

	public static void main(String[] args) throws FileNotFoundException {
		File file = null;
		JFileChooser fc = new JFileChooser(new File(System.getProperty("user.dir")));
		int state = fc.showOpenDialog(null);
		if (state == JFileChooser.APPROVE_OPTION) {
			file = fc.getSelectedFile();
		} else {
			System.out.println("Auswahl abgebrochen");
		}
		JavaCode J = new JavaCode();
		Scanner sc = new Scanner(file);
		PrintWriter pw = new PrintWriter(file.getName() + ".out");
		J.ladeCode(sc);
		J.entferneKommentare();
		J.schreibeCode(pw);
		sc.close();
		pw.close();
	}

}
