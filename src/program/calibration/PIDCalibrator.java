package program.calibration;

import lejos.nxt.comm.RConsole;
import program.main.RoboMap;
import program.main.Robot;

public class PIDCalibrator {

	public static void main(String args[]) throws InterruptedException {
		//RConsole.openBluetooth(0);
		Robot robot = new Robot();
		/*
		while(!robot.checkForStop())robot.followLeftLine(false);
		robot.turnLeft(RoboMap.NORMAL_TURN_ANGLE, RoboMap.TURN_TRAVEL_DISTANCE);
		robot.foundLine = false;
		while(!robot.checkForStop())robot.followLeftLine(false);
		*/
		while (true) robot.followLeftLine(false);
	}	
	
}
