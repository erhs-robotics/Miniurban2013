package program.main;

import lejos.nxt.MotorPort;
import lejos.nxt.SensorPort;

public class RoboMap {
	
	public static SensorPort LEFT_COLOR_SENSOR_PORT  = SensorPort.S2;
	public static SensorPort MID_COLOR_SENSOR_PORT   = SensorPort.S4;
	public static SensorPort RIGHT_COLOR_SENSOR_PORT = SensorPort.S1;
	
	public static MotorPort LEFT_MOTOR_PORT = MotorPort.B;
	public static MotorPort RIGHT_MOTOR_PORT = MotorPort.A;
	
	public static final double PID_WHITE_SETPOINT  = 160; // Needs calibration -- Works (test map)
	public static final double PID_YELLOW_SETPOINT = 185; // Needs calibration -- Works (test map)
	public static final double PID_BLUE_SETPOINT   = 116;  // Needs calibration -- Not working (test map)
	
	public static final int TURN_TRAVEL_DISTANCE = 19;
	public static final int OFF_OF_CIRCLE_DISTANCE = 18;
	public static final int NORMAL_TURN_ANGLE = 85;
	public static final int TURN_ON_CIRCLE_ANGLE = 80;
	public static final int TURN_OFF_CIRCLE_ANGLE = 46;
	public static final int KEEP_ON_CIRCLE_DISTANCE = 2;
	public static final int PARK_TRAVEL_DISTANCE = 10;
	public static final int OUT_OF_PARK_DISTANCE = -23;
	public static final int OUT_OF_PARK_TURN = 80;
	
	public static final float MAXSPEED = 2.4f * 360f; // 2 RPS
	public static final float SLOWSPEED = 2f * 360f;
	public static final double WHEELDIAMETER = 3;
	public static final double TRACKWIDTH = 13;

	public static final double PARK_LENGTH = 20;
	public static final double TACO_TO_CM = 1/20.0;
	
	public static final int[] BLACK_MIN = {0,215,184,28,0,23};
	public static final int[] BLACK_MAX = {77,255,255,127,75,103};
	public static final int[] WHITE_MIN = {75,215,172,215,70,7};
	public static final int[] WHITE_MAX = {255,255,255,255,255,103};
	public static final int[] RED_MIN = {0,33,215,55,0,13};
	public static final int[] RED_MAX = {109,138,255,255,92,97};
	public static final int[] GREEN_MIN = {7,215,146,66,3,6};
	public static final int[] GREEN_MAX = {117,255,255,216,110,103};
	public static final int[] BLUE_MIN = {0,87,53,55,3,0};
	public static final int[] BLUE_MAX = {138,255,239,255,214,87};
	public static final int[] YELLOW_MIN = {168,215,189,215,10,20};
	public static final int[] YELLOW_MAX = {255,255,255,255,137,101};

}
