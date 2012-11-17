package program.mapping;

public class Road {

	private Road rightChild = null, leftChild = null, straightChild = null;
	private Road rightParent = null, leftParent = null, straightParent = null;
	private String name;
	private double g_value = -1; //the number of steps it takes to get to this road
	                               // -1 means not expanded
	
	
	private double length;	
	private double speed;
	
	boolean park = false; // Is it a parking space??
	boolean circle = false;

	// use this one for a normal road
	public Road(String name, int length) { 
		this.length = length;
		this.name = name;
		this.speed = 1;// normal speed
	}
	
	public Road(int length, String name, double speed) { 
		this.length = length;
		this.name = name;
		this.speed = speed;
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
	
	public double getG_value() {
		return g_value;
	}
	
	public void setG_value(double g_value) {
		this.g_value = g_value;
	}
	
	public double getLength() {
		return length;
	}
	
	public void erase() {
		g_value = -1;
		if(rightChild != null && rightChild.getG_value() != -1) rightChild.erase();
		if(leftChild != null && leftChild.getG_value() != -1) leftChild.erase();
		if(straightChild != null && straightChild.getG_value() != -1) straightChild.erase();
	}
}
