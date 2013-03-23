package program.main;

import java.util.ArrayList;

import program.calibration.Calibrator;
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
		
		//RConsole.openBluetooth(0);
		RConsole.println("THIS IS R!!!!");
		String[] names = {"BLACK", "WHITE", "GREEN", "BLUE", "YELLOW", "RED"};
		//for(int i=0;i<6;i++) {			
			//Calibrator.calibrateColor(robot.leftColorSensor, names[i]);	
		//}
		//while(true) robot.followLeftLine(false);
		//while(true) RConsole.println(robot.checkColor(robot.leftColorSensor));
		robot.park(true, 2, false);


/*
		while(true) {
			String yellow = String.valueOf(robot.leftColorSensor.getRGBComponent(ColorHTSensor.YELLOW));
			String red = String.valueOf(robot.leftColorSensor.getRGBComponent(ColorHTSensor.RED));
			String black = String.valueOf(robot.leftColorSensor.getRGBComponent(ColorHTSensor.BLACK));
			String white = String.valueOf(robot.leftColorSensor.getRGBComponent(ColorHTSensor.WHITE));
			String blue = String.valueOf(robot.leftColorSensor.getRGBComponent(ColorHTSensor.BLUE));
			String green = String.valueOf(robot.leftColorSensor.getRGBComponent(ColorHTSensor.GREEN));
			String out = "R: " + red + ", G: " + green + ", B: " + blue + ", Y: " + yellow + ", W: " + white + ", Black: " + black;
		    String color = robot.checkColor(robot.leftColorSensor);
		    out += ", Color: " + color;
			RConsole.println(out);
		}
*/
		
		
		
		
	}

}
