package program.mapping;

public class Step {
	protected Road road;
	protected Direction direction;
	
	public Road getRoad() {
		return road;
	}
	
	public Direction getDirection() {
		return direction;
	}
	
	public void print() {
		System.out.println("Finish");	
	}

}
