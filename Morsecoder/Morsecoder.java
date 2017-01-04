import javax.swing.JOptionPane;

public class Morsecoder {

	Vertex root;
	
	public Morsecoder() {
		Vertex leftleftSide = new Vertex("I", new Vertex("S", new Vertex("H"), new Vertex("V")), new Vertex("U", new Vertex("F"), new Vertex("Ü")));
		Vertex leftrightSide = new Vertex("A", new Vertex("R", new Vertex("L"), new Vertex("Ä")), new Vertex("W", new Vertex("P"), new Vertex("J")));
		Vertex leftSide = new Vertex("E", leftleftSide, leftrightSide);
		Vertex rightleftSide = new Vertex("N", new Vertex("D", new Vertex("B"), new Vertex("X")), new Vertex("K", new Vertex("C"), new Vertex("Y")));
		Vertex rightrightSide = new Vertex("M", new Vertex("G", new Vertex("Q"), new Vertex("Z")), new Vertex("O", new Vertex("Ö"), new Vertex("ß")));
		Vertex rightSide = new Vertex("T", rightleftSide, rightrightSide);
		this.root = new Vertex("", leftSide, rightSide);
	}
	
	public String encrypt(String text) {
		text = text.trim().toUpperCase();
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
	}
	
	private String codeOneLetter(Vertex current, char letter, String progress) {
		if(current.getContent().equals("" + letter)) {
			return progress;
		} else if (!current.isLeaf()) {
			return codeOneLetter(current.getLeftChild(), letter, progress + ".") + codeOneLetter(current.getRightChild(), letter, progress + "-");
		} else {
			return "";
		}
	}
	
	public static void main(String args[]) {
		Morsecoder coder = new Morsecoder();
		String input = JOptionPane.showInputDialog("Enter your text:");
		System.out.println(coder.encrypt(input));
	}
	
}
