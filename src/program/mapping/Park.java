package program.mapping;

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
		System.out.println("Park " + direction.toString() + " on Road " + road.getName() + " in space " + parkingSpace);
	}

}
