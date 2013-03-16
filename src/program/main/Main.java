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
import lejos.nxt.comm.RConsole;
import lejos.robotics.Color;

public class Main {

	public static void main(String[] args) throws Exception {
		Robot robot = new Robot();
		RConsole.openBluetooth(0);
		RConsole.println("THIS IS R!!!!");
		while(!robot.checkForStop()) robot.followLeftLine(false);
		robot.turnLeft(420);
		while(!robot.checkForStop()) robot.followLeftLine(false);
		robot.turnRight(350);
		while(!robot.checkForStop()) robot.followLeftLine(true);
		robot.turnRight(300);
		while(!robot.checkForStop()) robot.followLeftLine(false);
		robot.turnLeft(420);
			
		
		
/*
		while(true) {
			String yellow = String.valueOf(robot.leftColorSensor.getRGBComponent(ColorHTSensor.YELLOW));
			String red = String.valueOf(robot.leftColorSensor.getRGBComponent(ColorHTSensor.RED));
			String black = String.valueOf(robot.leftColorSensor.getRGBComponent(ColorHTSensor.BLACK));
			String white = String.valueOf(robot.leftColorSensor.getRGBComponent(ColorHTSensor.WHITE));
			String blue = String.valueOf(robot.leftColorSensor.getRGBComponent(ColorHTSensor.BLUE));
			String green = String.valueOf(robot.leftColorSensor.getRGBComponent(ColorHTSensor.GREEN));
			String out = "R: " + red + ", G: " + green + ", B: " + blue + ", Y: " + yellow + ", W: " + white + ", Black: " + black;
		 
			RConsole.println(out);
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
