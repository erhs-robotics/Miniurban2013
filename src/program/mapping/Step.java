package program.mapping;

import lejos.nxt.comm.RConsole;

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
		 RConsole.println("Finish");	
	}

}
