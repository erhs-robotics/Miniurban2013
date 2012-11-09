package program.mapping;

public class Road {

	static final int RIGHT = 0, LEFT = 1, STRAIGHT = 0;

	private Road rightChild = null, leftChild = null, straightChild = null;
	private String name;
	private int g_value; //the number of steps it takes to get to this road

	int length;
	int pDirection;
	
	boolean park = false; // Is it a parking space??
	boolean circle = false;

	public Road(int pDir, String name) { // use this constructor if it is a parking area
		pDirection = pDir;
		park = true; // We assume if it has no children, it is a parking space.
		this.name = name;
	}
	
	// use this one for a normal road
	public Road(int l, int dir, Road right, Road left, Road straight) { 
		length = l;
		pDirection = dir;
		rightChild = right;
		leftChild = left;
		straightChild = straight;
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
	}
	
	public void setRightChild(Road rightChild) {
		this.rightChild = rightChild;
	}
	
	public void setStraightChild(Road straightChild) {
		this.straightChild = straightChild;
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
}
