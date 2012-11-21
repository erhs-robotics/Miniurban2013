package program.mapping;

import java.util.ArrayList;

public class Mapper {

	//ArrayList<Road> path = new ArrayList<Road>();	
	//ArrayList<String> path = new ArrayList<String>();//String just for now because it is simpler
	int pathIndex = 0;
	

	public Mapper() {
		
	}
	
	public ArrayList<Step> getPath(Road current, ArrayList<Goal> goals) throws Exception {
		ArrayList<Step> path = findPath(current, goals);		
		
		return path;		
	}

	private ArrayList<Step> findPath(Road current, ArrayList<Goal> goals) throws Exception { // Runs the A* search, puts result in path
		ArrayList<Road> open = new ArrayList<Road>(); // The nodes that need to be expanded
		ArrayList<Road> closed = new ArrayList<Road>(); // The nodes that have already been expanded
		Road goal = null;
		current.setG_value(0);// make sure we start at 0
		while(goal == null) {
			goal = expand(current, open, closed, goals);// Expand from the current node to the surrounding nodes
			if(goal == null) current = getBestNode(open);// Picks the next current node that will most likely lead to the goal		
		}		
		
		//travels backward form goal to the start and records that path
		//also removes the goals we just found from goals
		ArrayList<Step> path = genPath(goal, goals);		
		
		//if goals is > 0 then we have more goals to find, so call findPath again with goal as starting point and with the new goals
		if(goals.size() > 0) {			
			ArrayList<Step> nextPath = findPath(goal, goals);//Recursively call findPath to find the next goal
			//store the next part of the path in path
			for(int i=0;i<nextPath.size();i++) {
				path.add(nextPath.get(i));
			}
		}
		//if goals.size() = 0, we are done so return the full path
		return path;
	}
	//takes the expanded map and works backward from goal to the start and generates the directions
	public ArrayList<Step> genPath(Road goal, ArrayList<Goal> goals) throws Exception {		
		ArrayList<Step> path = new ArrayList<Step>();
		Goal goalInfo = Goal.getGoal(goals, goal);
		//if this is not the last goal, give parking information
		if(goals.size() > 1) path.add(0, new Park(goal, goalInfo.getDirection(), goalInfo.getPark()) );
		//else this is the starting point, not a parking space
		else path.add(0, new Step());
		goals.remove(goalInfo);//we already found this goal, so remove it
		Road current = goal;
		while(current.getG_value() != 0) {
			//place all the parents of current in convenient variables
			//get_parent returns null if no parent
			Road right    = current.getRightParent();
			Road left     = current.getLeftParent();
			Road straight = current.getStraightParent();			
			
			ArrayList<Road> parents = new ArrayList<Road>();//put all parents in here to run through the getBestNode function
			//only add parent to parents if it is not null. makes sure you don't accidently choose a -1 node
			if(right != null && right.getG_value() != -1) parents.add(right);
			if(left != null && left.getG_value() != -1) parents.add(left);
			if(straight != null && straight.getG_value() != -1) parents.add(straight);
			
			if(parents.size() < 1) throw new Exception("Node has no parents!");//all parents are null
			
			Road best = getBestNode(parents);//find the node with the least g_value that is not -1
			
			//record in path, reverses directions because this function travels backwards: from goal to start
			if(best == right) path.add(0, new Turn(right, Direction.Left));
			if(best == left) path.add(0, new Turn(left, Direction.Right));
			if(best == straight) path.add(0, new Turn(straight, Direction.Straight));
			
			current = best;// record best in current so we can continue traveling backwards toward the start
			
		}
		return path;
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
	
	//expands open into the nodes surrounding current. Returns the first goal hit, if one is hit and returns null otherwise
	private Road expand(Road current, ArrayList<Road> open, ArrayList<Road> closed, ArrayList<Goal> goals) {		
		//getChild returns null if no child
		Road right    = current.getChildRight();
		Road left     = current.getChildLeft();
		Road straight = current.getChildStraight();
		
		
		//if child exists and we have not expanded it yet
		if(right != null && !closed.contains(right)) {			
			right.setG_value(current.getG_value() + right.getLength());//record the cost of getting here
			if(Goal.isGoal(goals, right)) return right; //check if we hit one of the goals, if so return it
			
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
		open.remove(current);//remove from open because it has already been expanded
		
		
		return null;//null because we did not find the goal yet
	}	
}
