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
	public static final double PID_BLUE_SETPOINT   = 100;  // Needs calibration -- Not working (test map)
	
	public static final int TURN_TRAVEL_DISTANCE = 17;
	public static final int NORMAL_TURN_ANGLE = 85;
	public static final int TURN_ON_CIRCLE_ANGLE = 80;
	public static final int TURN_OFF_CIRCLE_ANGLE = 46;
	public static final int KEEP_ON_CIRCLE_DISTANCE = 2;
	
	public static final float MAXSPEED = 2.5f * 360f; // 2 RPS
	public static final float SLOWSPEED = 2f * 360f;
	public static final double WHEELDIAMETER = 3;
	public static final double TRACKWIDTH = 13;
	
}
