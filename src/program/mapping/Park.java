package program.mapping;

import lejos.nxt.comm.RConsole;

public class Park extends Step {
	private int parkingSpace;
	
	public Park(Road road, Direction direction, int parkingSpace) {
		this.road = road;
		this.direction = direction;
		this.parkingSpace = parkingSpace;
	}
	
	public int getParkingSpace() {
		return parkingSpace;
	}
	
	@Override
	public void print() {
		 RConsole.println("Park " + direction.toString() + " on Road " + road.getName() + " in space " + parkingSpace);
	}

}
