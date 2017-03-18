import java.util.Locale;

public class BenutzerFormat implements BruchFormat {

	private String format = "%.3f";
	private Locale local = Locale.GERMAN;
	
	@Override
	public String bruchToString(int zaehler, int nenner) {
		double d = zaehler / (double) nenner;
		String s = String.format(this.local, this.format, d);
		return s;
	}
	
	public BenutzerFormat(String format) {
		this.format = format;
	}
	
	public BenutzerFormat(Locale local, String format) {
		this.format = format;
		this.local = local;
	}
	
}
