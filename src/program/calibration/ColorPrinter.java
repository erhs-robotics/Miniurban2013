package program.calibration;

import lejos.nxt.addon.ColorHTSensor;
import lejos.nxt.comm.RConsole;
import program.main.Robot;

public class ColorPrinter {
	
	public static void main(String args[]) {
		RConsole.openUSB(0);
		Robot robot = new Robot();		
		
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
		
	}

}
