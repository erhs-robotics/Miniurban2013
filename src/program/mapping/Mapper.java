package program.mapping;

import java.util.ArrayList;

public class Mapper {

	ArrayList<Road> path = new ArrayList<Road>();
	int pathIndex = 0;

	public Mapper() {
		// Initialize Roads here!!
	}

	public void findPath(Road current, Road dest) { // Runs the A* search, puts
													// result in path

	}

	public Road getNextRoad() { // returns the next road, Road will include
								// directions to the next.
		// pathIndex++;
		return path.get(pathIndex++); // MIGHT WORK
	}
}
