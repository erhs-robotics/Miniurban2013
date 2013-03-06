package program.main;

import lejos.nxt.MotorPort;
import lejos.nxt.SensorPort;

public class RoboMap {
	
	public static SensorPort LEFT_COLOR_SENSOR_PORT  = SensorPort.S4;
	public static SensorPort MID_COLOR_SENSOR_PORT   = SensorPort.S2;
	public static SensorPort RIGHT_COLOR_SENSOR_PORT = SensorPort.S1;
	
	public static MotorPort LEFT_MOTOR_PORT = MotorPort.B;
	public static MotorPort RIGHT_MOTOR_PORT = MotorPort.A;
	
	public static final int PID_WHITE_SETPOINT  = 60; // Needs calibration
	public static final int PID_YELLOW_SETPOINT = 60; // Needs calibration
	public static final int PID_BLUE_SETPOINT   = 60; // Needs calibration
	
}
