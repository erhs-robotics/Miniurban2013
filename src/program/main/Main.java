package program.main;

import java.util.ArrayList;
import program.mapping.Direction;
import program.mapping.Goal;
import program.mapping.Map;
import program.mapping.Mapper;
import program.mapping.Road;
import program.mapping.Step;

public class Main {

	public static void main(String[] args) throws Exception {
		Robot robot = new Robot();		
		Mapper mapper = new Mapper();
		Road map = Map.getMap();
		
		ArrayList<Goal> goals = new ArrayList<Goal>();
		goals.add(new Goal("R6", 2, Direction.Left));
		goals.add(new Goal("R6", 2, Direction.Left));
		goals.add(new Goal("R6", 2, Direction.Left));
		goals.add(new Goal("R6", 2, Direction.Left));
		goals.add(new Goal("R6", 2, Direction.Left));
		goals.add(new Goal("R6", 2, Direction.Left));
		ArrayList<Step> path = mapper.getPath(map, goals);	
		
		robot.followSteps(path);	
	}

}
