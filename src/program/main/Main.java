package program.main;

import java.util.ArrayList;

import program.mapping.Direction;
import program.mapping.Goal;
import program.mapping.Map;
import program.mapping.Mapper;
import program.mapping.Road;
import program.mapping.Step;
import lejos.nxt.Button;
import lejos.nxt.addon.ColorHTSensor;
import lejos.robotics.Color;

public class Main {

	public static void main(String[] args) throws Exception {
		Robot robot = new Robot();
		
		Road map = Map.getMap();
		ArrayList<Goal> goals = new ArrayList<Goal>();
		
		goals.add(new Goal("R1", 2, Direction.Left));
		goals.add(new Goal("R15", 4, Direction.Right));
		goals.add(new Goal("R45", 4, Direction.Right));
		goals.add(new Goal("R55", 4, Direction.Right));
		goals.add(new Goal("R69", 4, Direction.Right));
		goals.add(new Goal("R36", 4, Direction.Right));
		
		Mapper mapper = new Mapper();
		ArrayList<Step> path = mapper.getPath(map, goals);		
		/*for(int i=0;i<path.size();i++) {
			path.get(i).print();
		}*/
		//robot.followSteps(path);
		while (!robot.checkForStop()) {
			robot.followLeftLine(false);
		}
		robot.turnLeft();
		while (!robot.checkForStop()) {
			robot.followRightLine(false);
		}
		robot.turnRight();
		while (!robot.checkForStop()) {
			robot.followLeftLine(true);
		}
		/*
		while (!Button.ENTER.isDown()) {
			//System.out.println(robot.leftColorSensor.getRGBComponent(ColorHTSensor.BLACK));
			//robot.followLeftLine(true);
			//robot.tankDrive(1, 1);
			//System.out.println(robot.leftColorSensor.getRGBComponent(ColorHTSensor.BLACK));
			//robot.followLeftLine(false);
			//System.out.println(robot.checkColor(robot.midColorSensor));
			//robot.followLeftLine(false);
			//robot.followLeftLine(false);
			//System.out.println(robot.leftColorSensor.getRGBComponent(ColorHTSensor.BLACK));
			robot.followLeftLine(false);
		}
		*/
	}

	public static String getColorString(Color color) {
		int colorID = color.getColor();
		if (colorID == Color.BLACK)
			return "Black";
		else if (colorID == Color.BLUE)
			return "Blue";
		else if (colorID == Color.GREEN)
			return "Green";
		else if (colorID == Color.WHITE)
			return "White";
		else if (colorID == Color.RED)
			return "Red";
		else if (colorID == Color.YELLOW)
			return "Yellow";
		else
			return "Error";
	}

}
