package program.mapping;

import java.util.ArrayList;

public class Mapper {

	ArrayList<Road> path = new ArrayList<Road>();	
	
	int pathIndex = 0;

	public Mapper() {
		
	}

	public void findPath(Road current, Road goal) { // Runs the A* search, puts result in path
		ArrayList<Road> open = new ArrayList<Road>(); // The nodes that need to be expanded
		ArrayList<Road> closed = new ArrayList<Road>(); // The nodes that have already been expanded
		boolean goalhit = false;
		current.setG_value(0);
		while(!goalhit) {
			goalhit = expand(current, open, closed, goal);// Expand from the current node to the surrounding nodes
			if(!goalhit) current = getBestNode(open);// Picks the next current node that will most likely lead to the goal		
		}

	}
	
	// returns the node in open with the smallest gvalue + h(x) where h(x) is the heuristic
	public Road getBestNode(ArrayList<Road> open) { 
		Road best = open.get(0);
		for(int i=0;i<open.size();i++) {
			Road road = open.get(i);
			if(road.getG_value() < best.getG_value()) {
				best = road;
			}
		}
		return best;
		
	}
	
	//expands open into the nodes surrounding current and checks if we've hit the goal
	private boolean expand(Road current, ArrayList<Road> open, ArrayList<Road> closed, Road goal) {		
		//getChild returns null if no child
		Road right    = current.getChildRight();
		Road left     = current.getChildLeft();
		Road straight = current.getChildStraight();
		
		
		//if child exists and we have not expanded it yet
		if(right != null && !closed.contains(right)) {			
			right.setG_value(current.getG_value() + right.getLength());//record the cost of getting here
			if(right.getName() == goal.getName()) return true;//check if we made it to the goal
			open.add(right);//add road to the open list so it can be expanded in the future
		}
		
		if(left != null && !closed.contains(left)) {			
			left.setG_value(current.getG_value() + left.getLength());
			if(left.getName() == goal.getName()) return true;
			open.add(left);
		}
		
		if(straight != null && !closed.contains(straight)) {			
			straight.setG_value(current.getG_value() + straight.getLength());
			if(straight.getName() == goal.getName()) return true;
			open.add(straight);
		}
		
		closed.add(current);//make sure we don't expand current again
		open.remove(current);
		
		
		return false;//false because we did not find the goal yet
	}

	public Road getNextRoad() { // returns the next road, Road will include
								// directions to the next.
		// pathIndex++;
		return path.get(pathIndex++); // MIGHT WORK
	}
}
