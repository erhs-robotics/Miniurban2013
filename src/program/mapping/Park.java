package program.mapping;

import program.localization.LinearColorMap;
import lejos.nxt.comm.RConsole;

public class Park extends Step {
	private int parkingSpace;
	private LinearColorMap parkMap;
	
	public Park(Road road, Direction direction, int parkingSpace, LinearColorMap parkMap) {
		this.road = road;
		this.direction = direction;
		this.parkingSpace = parkingSpace;
		this.parkMap = parkMap;
	}
	
	public int getParkingSpace() {
		return parkingSpace;
	}
	
	@Override
	public void print() {
		 RConsole.println("Park " + direction.toString() + " on Road " + road.getName() + " in space " + parkingSpace);
	}
	
	public LinearColorMap getParkMap() {
		return parkMap;
	}

}
