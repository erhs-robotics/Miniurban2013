package program.mapping;

import java.util.ArrayList;

public class Mapper {

	public Mapper() {
		
	}
	
	public ArrayList<Step> getPath(Road current, ArrayList<Goal> goals) throws Exception {
		if(goals.size() < 1) throw new Exception("No goals given! Must have at least one goal!");
		//Store were we started so we can return here at the end
		Goal start = new Goal(current.getName(), 0, Direction.None);
		//store start in a convenient list so we can pass it to findPath()
		ArrayList<Goal> _start = new ArrayList<Goal>();
		_start.add(start);
		//find the path to all the goals
		ArrayList<Step> path = findPath(current, goals);
		//find were we stopped
		Road last = path.get(path.size() - 1).getRoad();
		//find the path from where we stopped to where we started
		ArrayList<Step> pathToStart = findPath(last, _start);
		//combine the two paths
		for(int i=0;i<pathToStart.size();i++) {
			path.add(pathToStart.get(i));
		}
		//since were we started is not actually a parking space
		//remove the last parking direction and just put in a blank Step
		//object so we know that we finish here
		path.remove(path.size() - 1);
		path.add(new Step());
		//return the complete path from the start to all the goals and back again
		return path;		
	}

	private ArrayList<Step> findPath(Road current, ArrayList<Goal> goals) throws Exception { // Runs the A* search, puts result in path
		assert goals.size() > 0;
		assert current != null;
		assert current.hasLeftChild() || current.hasRightChild() || current.hasStraightChild();
		
		ArrayList<Road> open = new ArrayList<Road>(); // The nodes that need to be expanded
		ArrayList<Road> closed = new ArrayList<Road>(); // The nodes that have already been expanded
		Road goal = null;
		current.setG_value(0);// make sure we start at 0
		open.add(current);//to comply with expand assertions
		while(goal == null) {// while we have not hit a goal
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
		assert path.size() > 0;
		assert goals.size() == 0;
		//if goals.size() = 0, we are done so return the full path
		return path;
	}
	//takes the expanded map and works backward from goal to the start and generates the directions
	private ArrayList<Step> genPath(Road goal, ArrayList<Goal> goals) throws Exception {
		assert goal != null;
		assert goals.size() > 0;
		assert goal.hasExpandedLeftParent() || goal.hasExpandedRightParent() || goal.hasExpandedStraightParent();
		assert goal.getG_value() > 0;
		
		ArrayList<Step> path = new ArrayList<Step>();
		Goal goalInfo = Goal.getGoal(goals, goal);
		assert goalInfo != null;
		//give parking information
		path.add(new Park(goal, goalInfo.getDirection(), goalInfo.getPark()));
		
		goals.remove(goalInfo);//we already found this goal, so remove it
		Road current = goal;
		while(current.getG_value() != 0) {//while we have not found our starting point: a g_value of 0
			//place all the parents of current in convenient variables
			//get_parent returns null if no parent
			Road right    = current.getRightParent();
			Road left     = current.getLeftParent();
			Road straight = current.getStraightParent();			
			
			ArrayList<Road> parents = new ArrayList<Road>();//put all parents in here to run through the getBestNode function
			//only add parent to parents if it is not null. makes sure you don't accidently choose a -1 node
			if(current.hasExpandedRightParent()) parents.add(right);
			if(current.hasExpandedLeftParent()) parents.add(left);
			if(current.hasExpandedStraightParent()) parents.add(straight);
			
			assert parents.size() > 0;//all parents are null
			
			Road best = getBestNode(parents);//find the node with the least g_value that is not -1
			
			//record in path, reverses directions because this function travels backwards: from goal to start
			if(best == right) path.add(0, new Turn(right, Direction.Left));
			else if(best == left) path.add(0, new Turn(left, Direction.Right));
			else if(best == straight) path.add(0, new Turn(straight, Direction.Straight));
			else assert false;//code should not reach this!
			
			current = best;// record best in current so we can continue traveling backwards toward the start
			
		}
		assert current.getG_value() == 0;
		assert path.size() > 0;
		assert path.get(path.size() - 1) instanceof Park;		
		return path;
	}
	
	// returns the node in open with the smallest gvalue + h(x) where h(x) is the heuristic
	private Road getBestNode(ArrayList<Road> open) {
		assert open.size() > 0;		
		Road best = open.get(0);
		for(int i=0;i<open.size();i++) {
			Road road = open.get(i);			
			if(road.getG_value() < best.getG_value()) {
				best = road;
			}
		}
		assert best.getG_value() != -1;
		assert best != null;
		return best;		
	}
	
	//expands open into the nodes surrounding current. Returns the first goal hit, if one is hit and returns null otherwise
	private Road expand(Road current, ArrayList<Road> open, ArrayList<Road> closed, ArrayList<Goal> goals) {
		assert current != null;
		assert goals.size() > 0;
		assert !closed.contains(current);
		assert open.contains(current);
		assert current.hasLeftChild() || current.hasRightChild() || current.hasStraightChild();
		assert !Goal.isGoal(goals, current);
		
		//getChild returns null if no child
		Road right    = current.getChildRight();
		Road left     = current.getChildLeft();
		Road straight = current.getChildStraight();
		
		
		//if child exists and we have not expanded it yet
		if(current.hasRightChild() && !closed.contains(right)) {			
			right.setG_value(current.getG_value() + right.getCost());//record the cost of getting here
			if(Goal.isGoal(goals, right)) {
				assert !closed.contains(right);
				return right; //check if we hit one of the goals, if so return it
			}
			
			open.add(right);//add road to the open list so it can be expanded in the future
		}
		
		if(current.hasLeftChild() && !closed.contains(left)) {			
			left.setG_value(current.getG_value() + left.getCost());
			if(Goal.isGoal(goals, left)){
				assert !closed.contains(left);
				return left;
			}
			open.add(left);
		}
		
		if(current.hasStraightChild() && !closed.contains(straight)) {			
			straight.setG_value(current.getG_value() + straight.getCost());
			if(Goal.isGoal(goals, straight)){
				assert !closed.contains(straight);
				return straight;
			}
			open.add(straight);
		}
		
		closed.add(current);//make sure we don't expand current again
		open.remove(current);//remove from open because it has already been expanded
		
		assert open.size() > 0;
		return null;//null because we did not find the goal yet
	}	
}
