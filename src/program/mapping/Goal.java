package program.mapping;

import java.util.ArrayList;

public class Goal {
	private String goal;
	private int park;
	private Direction direction;
	public Goal(String goal, int park, Direction direction) {
		this.goal = goal;
		this.park = park;
		this.direction = direction;
	}
	
	public static boolean isGoal(ArrayList<Goal> goals, Road road) {
		for(int i=0;i<goals.size();i++) {
			if(goals.get(i).isGoal(road)) {
				return true;
			}
		}
		
		return false;
	}
	
	public static Goal getGoal(ArrayList<Goal> goals, Road road) {
		for(int i=0;i<goals.size();i++) {
			if(goals.get(i).isGoal(road)) {
				return goals.get(i);
			}
		}
		
		return null;
	}
	
	public boolean isGoal(Road road) {
		if(road.getName().equals(goal)) return true;
		return false;
	}
	
	public String getGoal() {
		return goal;
	}
	
	public int getPark() {
		return park;
	}
	
	public Direction getDirection() {
		return direction;
	}
	

}
