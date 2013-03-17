package program.main;

import lejos.nxt.MotorPort;
import lejos.nxt.SensorPort;

public class RoboMap {
	
	public static SensorPort LEFT_COLOR_SENSOR_PORT  = SensorPort.S4;
	public static SensorPort MID_COLOR_SENSOR_PORT   = SensorPort.S2;
	public static SensorPort RIGHT_COLOR_SENSOR_PORT = SensorPort.S1;
	
	public static MotorPort LEFT_MOTOR_PORT = MotorPort.B;
	public static MotorPort RIGHT_MOTOR_PORT = MotorPort.A;
	
	public static final double PID_WHITE_SETPOINT  = 60; // Needs calibration -- Works (test map)
	public static final double PID_YELLOW_SETPOINT = 65; // Needs calibration -- Works (test map)
	public static final double PID_BLUE_SETPOINT   = 6;  // Needs calibration -- Not working (test map)
	
	public static final int TURN_TRAVEL_DISTANCE = 20;
	public static final int NORMAL_TURN_ANGLE = 420;
	public static final int TURN_ON_CIRCLE_ANGLE = 350;
	public static final int TURN_OFF_CIRCLE_ANGLE = 300;
	
}
