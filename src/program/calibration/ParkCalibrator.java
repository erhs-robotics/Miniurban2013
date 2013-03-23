package program.calibration;

import java.util.Timer;

import lejos.nxt.comm.RConsole;

import program.main.Robot;

public class ParkCalibrator {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		RConsole.openBluetooth(0);
		long start = System.currentTimeMillis();		
		Robot robot = new Robot();
		while(System.currentTimeMillis() - start < 5000) {
			robot.followLeftLine(false);
		}
		RConsole.println(String.valueOf(robot.getAveTacoCount()));
	}

}
