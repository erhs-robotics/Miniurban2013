package program.mapping;

import lejos.nxt.comm.RConsole;

public class Turn extends Step {
	
	public Turn(Road road, Direction direction) {
		this.road = road;
		this.direction = direction;
	}
	
	@Override
	public void print() {
		 RConsole.println("Turn " + direction.toString() + " on Road " + road.getName());
	}
	
}
