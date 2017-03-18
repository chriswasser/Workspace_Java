import java.io.*;
import java.util.*;

/**
 * Class Huffman gives the ability to decode a Huffman-coded text; requirement is
 * a viable input file (information can be found in the decode function)
 * 
 * @author C.Wassermann
 *
 */
public class Huffman {

	// Array contains all codes of each letter and space
	private static String[] alphabet = new String[27];

	/**
	 * Decodes the content of file f and returns the text, which is coded in it
	 * 
	 * @param f
	 *            file, which meets certain requirements:
	 *            - first line is the coded text
	 *            - line 2-27 are the coded letters A-Z
	 *            - line 28 is the code for a space " "
	 * @return the decoded text as a String
	 * @throws IllegalArgumentException
	 *             if file f does not meet the above named requirements
	 * @throws FileNotFoundException
	 *             if file f cannot be found
	 */
	// does not check if every letter in the input file is used
	// does not check if every letter in the input file is unique
	// was checking those conditions part of the exercise or not?
	public static String decode(File f) throws IllegalArgumentException, FileNotFoundException {
		String code = Huffman.readFile(f); // coded text
		String text = ""; // decoded text
		String letter = ""; // each letter in the code
		int foo = 1;
		// builds return string
		for (int i = 0; i < code.length(); i += foo) {
			letter = "";
			foo = 1; // coded length of the letter
			// searches the fitting letter
			for (int j = i + 1; j < code.length() + 1; ++j) {
				int place = Huffman.contains(code.substring(i, j));
				if (place != -1) {
					if (place != 26) { // letter
						letter = "" + (char) (place + 'A');
						break;
					} else { // space
						letter = " ";
						break;
					}
				}
				++foo;
			}
			// the remaining code piece does not match with a letter
			if (letter.equals("")) {
				throw new IllegalArgumentException("Unallowed Fileformat!");
			}
			text += letter;
		}
		return text;
	}

	// checks if the given substring is a viable letter contained in the array
	// alphabet
	private static int contains(String substring) {
		for (int i = 0; i < Huffman.alphabet.length; ++i) {
			if (alphabet[i].equals(substring)) {
				return i;
			}
		}
		return -1;
	}

	// manages the file input, returns the coded text
	private static String readFile(File f) throws IllegalArgumentException, FileNotFoundException {
		Scanner sc = new Scanner(f);
		String code = "";
		// first line is the coded text
		if (sc.hasNextLine()) {
			code = sc.nextLine();
		} else {
			sc.close();
			throw new IllegalArgumentException("Unallowed Fileformat!");
		}
		int i = 0;
		// read each letter and save it in the array alphabet
		while (sc.hasNextLine()) {
			if (i >= 27) {
				// file has more than 28 lines
				sc.close();
				throw new IllegalArgumentException("Unallowed Fileformat!");
			}
			Huffman.alphabet[i] = sc.nextLine();
			++i;
		}
		// file has less than 28 lines
		if (i < 27) {
			sc.close();
			throw new IllegalArgumentException("Unallowed Fileformat!");
		}
		sc.close();
		return code;
	}

	// example files for testing
	public static void main(String[] args) {
		try {
			File f1 = new File("message.txt");
			System.out.println(Huffman.decode(f1));
			File f2 = new File("mississippi.txt");
			System.out.println(Huffman.decode(f2));
		} catch (FileNotFoundException e) {
			System.out.println("File cannot be found!");
		}
	}

}
