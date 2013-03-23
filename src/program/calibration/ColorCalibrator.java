package program.calibration;

import lejos.nxt.comm.RConsole;
import program.main.Robot;

public class ColorCalibrator {
	
	public static void main(String args[]) {
		Robot robot = new Robot();
		RConsole.openBluetooth(0);
		RConsole.println("THIS IS R!!!!");
		String[] names = {"BLACK", "WHITE", "RED", "GREEN", "BLUE", "YELLOW"};
		for(int i=0;i<6;i++) {			
			Calibrator.calibrateColor(robot.leftColorSensor, names[i]);	
		}
	}

}
