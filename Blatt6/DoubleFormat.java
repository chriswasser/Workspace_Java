
public class DoubleFormat implements BruchFormat {

	@Override
	public String bruchToString(int zaehler, int nenner) {
		double d = zaehler / (double) nenner;
		return ("" + d);
	}
	
}
