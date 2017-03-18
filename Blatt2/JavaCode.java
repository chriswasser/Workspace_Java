import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class JavaCode {
	
	ArrayList<String> Code = new ArrayList<>();
	
	public void ladeCode(Scanner sc) {
		while (sc.hasNextLine()) {
			String s = sc.nextLine();
			this.Code.add(s);
		}
	}
	
	public void schreibeCode(PrintWriter pw) {
		for(String s : this.Code) {
			pw.println(s);
		}
	}
	
	public void entferneKommentare() {
		for(int e = 0; e < this.Code.size(); e++) {
			String s = this.Code.get(e);
			if (s.indexOf("//")!=-1) {
				if (s.substring(0, s.indexOf("//")).trim().equals("")) {
					this.Code.remove(e);
				} else {
					String help = "";
					for(int j = 0; j < s.indexOf("//"); j++) {
						help = help + s.charAt(j);
					}
					s = help;
					this.Code.set(e,s);
				}
			}
			if (s.indexOf("/*") != -1) {
				//XXX
				do {
					this.Code.remove(e);
					s = this.Code.get(e);
				} while(s.indexOf("*/") ==-1);
				this.Code.remove(e);
				e = e-1;
			}
		}
	}
}
