import java.util.regex.Pattern;

import javax.swing.JOptionPane;

public class Morsecoder {

	private Vertex root;
	
	// creates the binary tree of the morse alphabet
	public Morsecoder() {
		Vertex leftleftSide = new Vertex("I", new Vertex("S", new Vertex("H"), new Vertex("V")), new Vertex("U", new Vertex("F"), new Vertex("")));
		Vertex leftrightSide = new Vertex("A", new Vertex("R", new Vertex("L"), new Vertex("")), new Vertex("W", new Vertex("P"), new Vertex("J")));
		Vertex leftSide = new Vertex("E", leftleftSide, leftrightSide);
		Vertex rightleftSide = new Vertex("N", new Vertex("D", new Vertex("B"), new Vertex("X")), new Vertex("K", new Vertex("C"), new Vertex("Y")));
		Vertex rightrightSide = new Vertex("M", new Vertex("G", new Vertex("Q"), new Vertex("Z")), new Vertex("O", new Vertex(""), new Vertex("")));
		Vertex rightSide = new Vertex("T", rightleftSide, rightrightSide);
		this.root = new Vertex("", leftSide, rightSide);
	}
	
	// codes the text into morsecode
	public String encrypt(String text) throws NumberFormatException {
		text = text.trim().toUpperCase();
		if(viableText(text)) {
			String code = "";
			for(int i = 0; i < text.length(); ++i) {
				if(text.charAt(i) == ' ') {
					code += " ";
				} else {
					code += codeOneLetter(this.root, text.charAt(i), "");
				}
				code += "|";
			}
			return code;
		} else {
			throw new NumberFormatException("Unallowed character");
		}
	}

	// checks if the given text is viable for coding
	private boolean viableText(String text) {
		for(int i = 0; i < text.length(); ++i) {
			if(!((text.charAt(i) >= 65 && text.charAt(i) <= 90) || text.charAt(i) == 32)) {
				return false;
			}
		}
		return true;
	}
	
	// only codes one letter from text into morsecode
	private String codeOneLetter(Vertex current, char letter, String progress) {
		if(current.getContent().equals("" + letter)) {
			return progress;
		} else if (!current.isLeaf()) {
			return codeOneLetter(current.getLeftChild(), letter, progress + ".") + codeOneLetter(current.getRightChild(), letter, progress + "-");
		} else {
			return "";
		}
	}

	// decodes morsecode into text
	public String decrypt(String morsecode) {
		String text = "";
		String[] letters = morsecode.split(Pattern.quote("|"));
		if(viableCode(letters)) {
			for(int i = 0; i < letters.length; ++i) {
				if(letters[i].equals(" ")) {
					text += " ";
				} else {
					text += decodeOneLetter(this.root, letters[i]);
				}
			}
			return text;
		} else {
			throw new NumberFormatException("Unallowed Code");
		}
	}
	
	// checks if the given morsecode is viable for decoding
	private boolean viableCode(String[] code) {
		for(int i = 0; i < code.length; ++i) {
			if(code[i].length() > 4) {
				return false;
			}
			for(int j = 0; j < code[i].length(); ++j) {
				if(!(code[i].charAt(j) == '.' || code[i].charAt(j) == '-' || code[i].charAt(j) == ' ' || code[i].charAt(j) == '|')) {
					return false;
				}
			}
		}
		return true;
	}
	
	// only decodes one Letter in morsecode to text
	private String decodeOneLetter(Vertex current, String code) {
		if(code.equals("")) {
			return (String) current.getContent();				
		} else if(code.charAt(0) == '.') {
			return decodeOneLetter(current.getLeftChild(), code.substring(1));
		} else {
			return decodeOneLetter(current.getRightChild(), code.substring(1));
		}
	}
		
	public static void main(String args[]) {
		Morsecoder coder = new Morsecoder();
		System.out.println("Welcome to the Morsecoder! Code and decode your text in morsecode:");
		while(true) {
			try  {
				String input = JOptionPane.showInputDialog("Enter your text:");
				System.out.println("Input: " + input);
				System.out.println("Morsecode: " + coder.encrypt(input));
				System.out.println("Text: " + coder.decrypt(coder.encrypt(input)));
				break;
			} catch(Exception e) {
				System.out.println("Please try again, no special characters allowed!");
			}
		}
	}
	
}
