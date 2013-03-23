package program.calibration;

import program.main.Robot;
import lejos.nxt.Button;
import lejos.nxt.addon.ColorHTSensor;
import lejos.nxt.comm.RConsole;

public class SetpointCalibrator {
	
	public static void main(String args[]) {
		
		Robot robot = new Robot();
		
		System.out.println("White Setpoint, press RIGHT when done");
		while(!Button.RIGHT.isDown()) {
			RConsole.println(Integer.toString(robot.leftColorSensor.getRGBComponent(ColorHTSensor.BLACK)));
		}
		
		robot.waitS(1);
		
		System.out.println("Yellow Setpoint, press RIGHT when done");
		while(!Button.RIGHT.isDown()) {
			RConsole.println(Integer.toString(robot.leftColorSensor.getRGBComponent(ColorHTSensor.BLACK)));
		}
		
		robot.waitS(1);
		
		System.out.println("Blue Setpoint, press RIGHT when done");
		while(!Button.RIGHT.isDown()) {
			RConsole.println(Integer.toString(robot.leftColorSensor.getRGBComponent(ColorHTSensor.GREEN)));
		}
		
	}

}
