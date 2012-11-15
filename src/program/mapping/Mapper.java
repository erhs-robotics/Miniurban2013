package program.mapping;

import java.util.ArrayList;

public class Mapper {

	ArrayList<Road> path = new ArrayList<Road>();	
	
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

	public void findPath(Road current, Road goal) { // Runs the A* search, puts result in path
		ArrayList<Road> open = new ArrayList<Road>(); // The nodes that need to be expanded
		ArrayList<Road> closed = new ArrayList<Road>(); // The nodes that have already been expanded
		boolean goalhit = false;
		
		while(!goalhit) {
			goalhit = expand(current, open, closed);// Expand from the current node to the surrounding nodes
			if(!goalhit) current = getBestNode(open);// Picks the next current node that will most likely lead to the goal		
		}

	}
	
	// returns the node in open with the smallest gvalue + h(x) where h(x) is the heuristic
	public Road getBestNode(ArrayList<Road> open) { 
		return null;
	}
	
	//expands open into the nodes surrounding current and checks if we've hit the goal
	private boolean expand(Road current, ArrayList<Road> open, ArrayList<Road> closed) {		
		
		return false;
	}

	public Road getNextRoad() { // returns the next road, Road will include
								// directions to the next.
		// pathIndex++;
		return path.get(pathIndex++); // MIGHT WORK
	}
}
