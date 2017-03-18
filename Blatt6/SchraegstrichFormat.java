
public class SchraegstrichFormat implements BruchFormat {

	@Override
	public String bruchToString(int zaehler, int nenner) {
		String s = "" + zaehler + "/" + nenner;
		return s;
	}
	
}
