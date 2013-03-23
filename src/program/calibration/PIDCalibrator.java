package program.calibration;

import lejos.nxt.comm.RConsole;
import program.main.Robot;

public class PIDCalibrator {

	public static void main(String args[]) {
		RConsole.openBluetooth(0);
		Robot robot = new Robot();
		while(true)robot.followLeftLine(false);
	}	
	
}
