
public class DreizeilenFormat implements BruchFormat {

	@Override
	public String bruchToString(int zaehler, int nenner) {
		int maxLength = ("" + Integer.max(zaehler, nenner)).length();
		String s = String.format(("%" + maxLength + "d\n"), zaehler);
		for (int i = 0; i < maxLength; i++) {
			s += "-";
		}
		s += String.format(("\n%" + maxLength + "d"), nenner);
		return s;
	}
	
}
