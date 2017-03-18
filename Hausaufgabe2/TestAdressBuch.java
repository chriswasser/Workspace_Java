import java.net.MalformedURLException;
import java.net.URL;

public class TestAdressBuch {
	public static void main(String[] args) {
		EmailAdressBuch buch1 = new EmailAdressBuch();
		EmailAdressBuch buch2 = new EmailAdressBuch();
		try {
			URL url1 = new URL(
					"https://doc.itc.rwth-aachen.de/download/attachments/5800183/mitarbeiter_matse_intern.txt");
			URL url2 = new URL(
					"https://doc.itc.rwth-aachen.de/download/attachments/5800183/mitarbeiter_matse_extern.txt");
			buch1.mitarbeiterEinlesen(url1);
			buch2.mitarbeiterEinlesen(url2);
		} catch (MalformedURLException e) {
			System.out.println("URL ungueltig");
		}

		buch2.einlesen("emailadressbuch.txt");
		System.out.println(buch1.toString());
		System.out.println(buch2.toString());
	}
}
