package program.mapping;

public class Turn extends Step {
	
	public Turn(Road road, Direction direction) {
		this.road = road;
		this.direction = direction;
	}
	
	@Override
	public void print() {
		System.out.println("Turn " + direction.toString() + " on Road " + road.getName());
	}
	
	

}
