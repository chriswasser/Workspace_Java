import java.util.regex.Pattern;

public class IEEE {

	// Wandelt float-Zahl in IEEE754-Darstellung
	// Form des Rueckgabewerts:
	// Bsp: 1.0f ergibt
	// 0/01111111/00000000000000000000000
	public static String FloattoIEEE(float eingabe) {
		
		// Vorzeichen
		String vorzeichen;
		if(eingabe >= 0) {
			vorzeichen = "0";
		} else {
			vorzeichen = "1";
		}
		eingabe = Math.abs(eingabe);
		
		// Exponent
		int expo = Math.getExponent(eingabe) + 127;
		String exponent = IEEE.toBinary(expo);
		StringBuilder sb1 = new StringBuilder(exponent);
		sb1.delete(exponent.indexOf(','),exponent.indexOf(',')+2);
		while(sb1.length() < 8) {
			sb1.insert(0, "0");
		}
		exponent = sb1.toString();

		// Mantisse
		String binary = IEEE.toBinary(eingabe); //XXX
		StringBuilder sb2 = new StringBuilder(binary);
		sb2.deleteCharAt(binary.indexOf(','));
		sb2.deleteCharAt(0);
		while(sb2.length() < 23) {
			sb2.append("0");
		}
		String mantisse = sb2.toString();
		
		return vorzeichen + "/" + exponent + "/" + mantisse;
	}
	
	
	// TODO
	// Wandelt IEEE-Zahl in float
	// Form des Eingabeparameters:
	// Bsp: 0/01111111/00000000000000000000000
	// ergibt 1.0f
	public static float IEEEToFloat(String eingabe) {
		
		// split
		String[] parts = eingabe.split(Pattern.quote("/"));
		
		// Vorzeichen
		String vorzeichen = parts[0];
		
		// Exponent
		String exponent = parts[1];
		int i = IEEE.toDecimal(exponent) - 127;
		
		// Mantisse
		String mantisse = parts[2];
		mantisse = "1," + mantisse;
		
		
		return 1;
	}
	
	private static int toDecimal(String exponent) {
		
		return 0;
	}

	private static String toBinary(float f) {
		String binary = "";
		int i = (int) f;
		
		// Vorkomma-Anteil
		do {
			int bit = i % 2;
			binary += bit;
			i /= 2;
		} while(i > 0);
		StringBuilder sb1 = new StringBuilder(binary);
		binary = sb1.reverse().toString();
		binary += ",";

		// Nachkomma-Anteil
		i = (int) f;
		float nachKomma = f - i;
		while(nachKomma > 0) {
			if(nachKomma*2 >= 1 ) {
				binary += "1";
				nachKomma = nachKomma * 2 - 1;
			} else {
				nachKomma *= 2;
				binary += "0";
			}
		}

		if(binary.indexOf(',')==binary.length()-1) {
			binary += "0";
		}
		return binary;
	}
	
	public static void main(String[] args) {
		float number = -1420.421f;
		System.out.println("Number: " + number);
		System.out.println("IEEE754: " + IEEE.FloattoIEEE(number));
		System.out.println("Number: " + IEEE.IEEEToFloat(IEEE.FloattoIEEE(number)));
	}
	
}
