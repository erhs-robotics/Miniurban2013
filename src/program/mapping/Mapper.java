package program.mapping;

import java.util.ArrayList;

public class Mapper {

	//ArrayList<Road> path = new ArrayList<Road>();	
	//ArrayList<String> path = new ArrayList<String>();//String just for now because it is simpler
	int pathIndex = 0;
	

	public Mapper() {
		
	}

	public ArrayList<String> findPath(Road current, ArrayList<Goal> goals) throws Exception { // Runs the A* search, puts result in path
		
		ArrayList<Road> open = new ArrayList<Road>(); // The nodes that need to be expanded
		ArrayList<Road> closed = new ArrayList<Road>(); // The nodes that have already been expanded
		Road goal = null;
		current.setG_value(0);
		while(goal == null) {
			goal = expand(current, open, closed, goals);// Expand from the current node to the surrounding nodes
			if(goal == null) current = getBestNode(open);// Picks the next current node that will most likely lead to the goal		
		}
		
		
		ArrayList<String> path = genPath(goal, goals);		
		
		if(goals.size() > 0) {			
			ArrayList<String> nextPath = findPath(goal, goals);
			for(int i=0;i<nextPath.size();i++) {
				path.add(nextPath.get(i));
			}
		}
		return path;
	}
	//takes the expanded map and works backward from goal to the start and generates the directions
	public ArrayList<String> genPath(Road goal, ArrayList<Goal> goals) throws Exception {		
		ArrayList<String> path = new ArrayList<String>();
		Goal goalInfo = Goal.getGoal(goals, goal);
		if(goals.size() > 1) path.add(0, "Park " + goalInfo.getDirection().toString() + " at " + goalInfo.getPark() );
		else path.add(0, "Finish");
		goals.remove(goalInfo);
		Road current = goal;
		while(current.getG_value() != 0) {
			Road right    = current.getRightParent();
			Road left     = current.getLeftParent();
			Road straight = current.getStraightParent();			
			
			ArrayList<Road> parents = new ArrayList<Road>();
			
			if(right != null) parents.add(right);
			if(left != null) parents.add(left);
			if(straight != null) parents.add(straight);
			
			if(parents.size() < 1) throw new Exception("Node has no parents!");
			
			Road best = getBestNode(parents);
			
			if(best == right) path.add(0, "Left"); 
			if(best == left) path.add(0, "Right"); 
			if(best == straight) path.add(0, "Straight"); 
			
			current = best;		
			
		}
		return path;
	}
	
	// returns the node in open with the smallest gvalue + h(x) where h(x) is the heuristic
	public Road getBestNode(ArrayList<Road> open) { 
		Road best = open.get(0);
		for(int i=0;i<open.size();i++) {
			Road road = open.get(i);
			if(road.getG_value() != -1 && road.getG_value() < best.getG_value()) {
				best = road;
			}
		}
		return best;
		
	}
	
	//expands open into the nodes surrounding current and checks if we've hit the goal
	private Road expand(Road current, ArrayList<Road> open, ArrayList<Road> closed, ArrayList<Goal> goals) {		
		//getChild returns null if no child
		Road right    = current.getChildRight();
		Road left     = current.getChildLeft();
		Road straight = current.getChildStraight();
		
		
		//if child exists and we have not expanded it yet
		if(right != null && !closed.contains(right)) {			
			right.setG_value(current.getG_value() + right.getLength());//record the cost of getting here
			if(Goal.isGoal(goals, right)) return right; //check if we made it to the goal
			
			open.add(right);//add road to the open list so it can be expanded in the future
		}
		
		if(left != null && !closed.contains(left)) {			
			left.setG_value(current.getG_value() + left.getLength());
			if(Goal.isGoal(goals, left)) return left;
			open.add(left);
		}
		
		if(straight != null && !closed.contains(straight)) {			
			straight.setG_value(current.getG_value() + straight.getLength());
			if(Goal.isGoal(goals, straight)) return straight;
			open.add(straight);
		}
		
		closed.add(current);//make sure we don't expand current again
		open.remove(current);
		
		
		return null;//null because we did not find the goal yet
	}	
}
