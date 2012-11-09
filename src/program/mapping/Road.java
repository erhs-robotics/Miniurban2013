package program.mapping;

public class Road {

	static final int RIGHT = 0, LEFT = 1, STRAIGHT = 0;

	Road rightChild = null, leftChild = null, straightChild = null;

	int length;
	int pDirection;
	boolean park = false; // Is it a parking space??
	boolean circle = false;

	public Road(int pDir) { // use this constructor if it is a parking area
		pDirection = pDir;
		park = true; // We assume if it has no children, it is a parking space.
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
}
