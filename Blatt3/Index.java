import java.util.HashMap;

public class Index {

	private HashMap<String, String> ind;

	public Index() {
		this.ind = new HashMap<>();
	}

	public Index(Index index) {
		for (String s : index.ind.keySet()) {
			this.ind.put(s, ind.get(s));
		}
	}

	public void begriffHinzufuegen(String s, int i) {

	}

}
