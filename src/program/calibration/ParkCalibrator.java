package program.calibration;

import lejos.nxt.comm.RConsole;
import program.main.Robot;

public class ParkCalibrator {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		RConsole.openBluetooth(0);
		Robot robot = new Robot();
		/*
		long start = System.currentTimeMillis();		
		Robot robot = new Robot();
		while(System.currentTimeMillis() - start < 1700) {
			robot.followLeftLine(false);
		}
		RConsole.println(String.valueOf(robot.getAveTacoCount()));
		*/
		robot.park(false, 4, true, "R59");
		
	}

}
