package program.main;

import java.util.ArrayList;

import program.mapping.Direction;
import program.mapping.Goal;
import program.mapping.Map;
import program.mapping.Mapper;
import program.mapping.Road;
import program.mapping.Step;
import lejos.nxt.Button;
import lejos.robotics.Color;

public class Main {

	public static void main(String[] args) throws Exception {
		Robot robot = new Robot();
		robot.setPIDConstants(1.0f, 0.0f, 5.0f, 1.0f, 0.0f, 0.0f);
		Road map = Map.getMap();
		ArrayList<Goal> goals = new ArrayList<Goal>();
		
		goals.add(new Goal("R1", 2, Direction.Left));
		//goals.add(new Goal("R15", 4, Direction.Right));
		//goals.add(new Goal("R45", 4, Direction.Right));
		//goals.add(new Goal("R55", 4, Direction.Right));
		//goals.add(new Goal("R69", 4, Direction.Right));
		//goals.add(new Goal("R36", 4, Direction.Right));
		//goals.add(new Goal("start", 0, Direction.Left));
		
		Mapper mapper = new Mapper();
		ArrayList<Step> path;
		
		path = mapper.getPath(map, goals);
		for(int i=0;i<path.size();i++) {
			path.get(i).print();
		}
	
			// TODO Auto-generated catch block
		
		
		
		
		
		while (!Button.ENTER.isDown()) {
			//System.out.println("Go");
			//Mapper mapper = new Mapper();
			//Road currentRoad;
			//ArrayList<Goals>;
			//ArrayList<Step> = mapper.getPath(currentRoad, 
			//System.out.println(getColorString(robot.getMidColor()));
			//robot.followLeftLine(false);
			//String midColor = getColorString(robot.getMidColor());
			//System.out.println(midColor);
			/*
			if (!(midColor.equals("Red"))) {
				robot.tankDrive(1, 1);
			}
			else { 
				robot.tankDrive(0, 0);
				break;
			}
			*/
		}
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
