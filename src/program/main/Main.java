package program.main;

import java.util.ArrayList;

import lejos.nxt.comm.RConsole;
import program.mapping.Direction;
import program.mapping.Goal;
import program.mapping.Map;
import program.mapping.Mapper;
import program.mapping.Road;
import program.mapping.Step;

public class Main {

	public static void main(String[] args) throws Exception {
		//RConsole.openBluetooth(0);
		Robot robot = new Robot();		
		Mapper mapper = new Mapper();
		Road map = Map.getMap();
		
		ArrayList<Goal> goals = new ArrayList<Goal>();
		goals.add(new Goal("R45", 1, Direction.Left));
		goals.add(new Goal("R41", 3, Direction.Left));
		goals.add(new Goal("R15", 2, Direction.Right));
		goals.add(new Goal("R1", 4, Direction.Left));
		goals.add(new Goal("R59", 2, Direction.Right));
		goals.add(new Goal("R55", 1, Direction.Right));
		ArrayList<Step> path = mapper.getPath(map, goals);	
		
		robot.followSteps(path);	
	}

}
