
public class Vertex {

	private Vertex leftChild;
	private Vertex rightChild;
	private boolean isRoot;
	private Object content;
	
	boolean isRoot() {
		return this.isRoot;
	}
	
	boolean isLeaf() {
		return this.leftChild==null && this.rightChild==null;
	}

	public Vertex getLeftChild() {
		return leftChild;
	}

	public void setLeftChild(Vertex leftChild) {
		this.leftChild = leftChild;
	}

	public Vertex getRightChild() {
		return rightChild;
	}

	public void setRightChild(Vertex rightChild) {
		this.rightChild = rightChild;
	}

	public Object getContent() {
		return content;
	}

	public void setContent(Object content) {
		this.content = content;
	}
	
	public Vertex(Object content) {
		this.content = content;
		this.leftChild = null;
		this.rightChild = null;
	}
	
	public Vertex(Object content, Vertex leftChild, Vertex rightChild) {
		this.content = content;
		this.leftChild = leftChild;
		this.rightChild = rightChild;
	}
	
}
