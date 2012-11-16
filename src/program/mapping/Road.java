package program.mapping;

public class Road {

	static final int RIGHT = 0, LEFT = 1, STRAIGHT = 0;

	private Road rightChild = null, leftChild = null, straightChild = null;
	private Road rightParent = null, leftParent = null, straightParent = null;
	private String name;
	private int g_value = -1; //the number of steps it takes to get to this road
	                          // -1 means not expanded

	private int length;
	int pDirection;
	
	boolean park = false; // Is it a parking space??
	boolean circle = false;

	public Road(int pDir, String name) { // use this constructor if it is a parking area
		pDirection = pDir;
		park = true; // We assume if it has no children, it is a parking space.
		this.name = name;
	}
	
	// use this one for a normal road
	public Road(int l, int dir, String name) { 
		length = l;
		this.name = name;
	}

	public void setCircle(boolean c) { // Make it a circle
		circle = c;
	}

	public boolean isCircle() { // Is it a circle???
		return circle;
	}

	public Road getChildRight() {
		return rightChild;
	}

	public Road getChildLeft() {
		return leftChild;
	}

	public Road getChildStraight() {
		return straightChild;
	}
	
	public void setLeftChild(Road leftChild) {
		this.leftChild = leftChild;
		leftChild.setRightParent(this);
	}
	
	public void setRightChild(Road rightChild) {
		this.rightChild = rightChild;
		rightChild.setLeftParent(this);
	}
	
	public void setStraightChild(Road straightChild) {
		this.straightChild = straightChild;
		straightChild.setStraightParent(this);
	}
	
	public void setLeftParent(Road leftParent) {
		this.leftParent = leftParent;
	}
	
	public void setRightParent(Road rightParent) {
		this.rightParent = rightParent;
	}
	
	public void setStraightParent(Road straightParent) {
		this.straightParent = straightParent;
	}
	
	public Road getLeftParent() {
		return leftParent;
	}
	
	public Road getRightParent() {
		return rightParent;
	}
	
	public Road getStraightParent() {
		return straightParent;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getG_value() {
		return g_value;
	}
	
	public void setG_value(int g_value) {
		this.g_value = g_value;
	}
	
	public int getLength() {
		return length;
	}
}
