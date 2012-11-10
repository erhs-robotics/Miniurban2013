package program.mapping;

import java.util.ArrayList;

public class Mapper {

	ArrayList<Road> path = new ArrayList<Road>();
	ArrayList<Road> open = new ArrayList<Road>(); // The nodes that need to be expanded
	ArrayList<Road> closed = new ArrayList<Road>(); // The nodes that have already been expanded
	
	int pathIndex = 0;

	public Mapper() {
		// Initialize Roads here!!
		
		//sample map, a square
		Road top = new Road(0, "top");
		Road bottom = new Road(0, "bottom");
		Road left = new Road(0, "left");
		Road right = new Road(0, "right");		
		
		top.setRightChild(right);
		right.setRightChild(bottom);
		bottom.setRightChild(left);
		left.setRightChild(top);
	}

	public void findPath(Road current, Road dest) { // Runs the A* search, puts
													// result in path
		
		

	}
	
	private void expand() {		
		
		
	}

	public Road getNextRoad() { // returns the next road, Road will include
								// directions to the next.
		// pathIndex++;
		return path.get(pathIndex++); // MIGHT WORK
	}
}
