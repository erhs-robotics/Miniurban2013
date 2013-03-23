package program.calibration;

import program.main.Robot;

public class PIDCalibrator {

	public static void main(String args[]) throws InterruptedException {		
		Robot robot = new Robot();		
		while (!robot.checkForStop()) robot.followLeftLine(false);
	}	
	
}
