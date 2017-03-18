import java.util.ArrayList;

public class Geldautomat {

	public static void geldautomatV1(int betrag) {
		betrag = betrag - (betrag % 5);
		if (betrag >= 500) {
			System.out.println("500EUR");
		} else if (betrag >= 200) {
			System.out.println("200EUR");
		} else if (betrag >= 100) {
			System.out.println("100EUR");
		} else if (betrag >= 50) {
			System.out.println("50EUR");
		} else if (betrag >= 20) {
			System.out.println("20EUR");
		} else if (betrag >= 10) {
			System.out.println("10EUR");
		} else if (betrag >= 5) {
			System.out.println("5EUR");
		} else {
			System.out.println("Zu kleiner Betrag.");
		}
	}

	public static ArrayList<Integer> geldautomatV2(int betrag) {
		betrag = betrag - (betrag % 5);
		if (betrag >= 500) {
			betrag -= 500;
			ArrayList<Integer> recursiveList = geldautomatV2(betrag);
			recursiveList.add(new Integer(500));
			return recursiveList;
		} else if (betrag >= 200) {
			betrag -= 200;
			ArrayList<Integer> recursiveList = geldautomatV2(betrag);
			recursiveList.add(new Integer(200));
			return recursiveList;
		} else if (betrag >= 100) {
			betrag -= 100;
			ArrayList<Integer> recursiveList = geldautomatV2(betrag);
			recursiveList.add(new Integer(100));
			return recursiveList;
		} else if (betrag >= 50) {
			betrag -= 50;
			ArrayList<Integer> recursiveList = geldautomatV2(betrag);
			recursiveList.add(new Integer(50));
			return recursiveList;
		} else if (betrag >= 20) {
			betrag -= 20;
			ArrayList<Integer> recursiveList = geldautomatV2(betrag);
			recursiveList.add(new Integer(20));
			return recursiveList;
		} else if (betrag >= 10) {
			betrag -= 10;
			ArrayList<Integer> recursiveList = geldautomatV2(betrag);
			recursiveList.add(new Integer(10));
			return recursiveList;
		} else if (betrag >= 5) {
			betrag -= 5;
			ArrayList<Integer> recursiveList = geldautomatV2(betrag);
			recursiveList.add(new Integer(5));
			return recursiveList;
		} else {
			return new ArrayList<Integer>();
		}
	}

	public static int[] geldautomatV3(int betrag) {
		betrag = betrag - (betrag % 5);
		if (betrag >= 500) {
			betrag -= 500;
			int[] scheine = geldautomatV3(betrag);
			scheine[0] += 1;
			return scheine;
		} else if (betrag >= 200) {
			betrag -= 200;
			int[] scheine = geldautomatV3(betrag);
			scheine[1] += 1;
			return scheine;
		} else if (betrag >= 100) {
			betrag -= 100;
			int[] scheine = geldautomatV3(betrag);
			scheine[2] += 1;
			return scheine;
		} else if (betrag >= 50) {
			betrag -= 50;
			int[] scheine = geldautomatV3(betrag);
			scheine[3] += 1;
			return scheine;
		} else if (betrag >= 20) {
			betrag -= 20;
			int[] scheine = geldautomatV3(betrag);
			scheine[4] += 1;
			return scheine;
		} else if (betrag >= 10) {
			betrag -= 10;
			int[] scheine = geldautomatV3(betrag);
			scheine[5] += 1;
			return scheine;
		} else if (betrag >= 5) {
			betrag -= 5;
			int[] scheine = geldautomatV3(betrag);
			scheine[6] += 1;
			return scheine;
		} else {
			return new int[7];
		}
	}

}
