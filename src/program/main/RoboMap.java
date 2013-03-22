package program.main;

import lejos.nxt.MotorPort;
import lejos.nxt.SensorPort;

public class RoboMap {
	
	public static SensorPort LEFT_COLOR_SENSOR_PORT  = SensorPort.S4;
	public static SensorPort MID_COLOR_SENSOR_PORT   = SensorPort.S2;
	public static SensorPort RIGHT_COLOR_SENSOR_PORT = SensorPort.S1;
	
	public static MotorPort LEFT_MOTOR_PORT = MotorPort.B;
	public static MotorPort RIGHT_MOTOR_PORT = MotorPort.A;
	
	public static final double PID_WHITE_SETPOINT  = 69; // Needs calibration -- Works (test map)
	public static final double PID_YELLOW_SETPOINT = 47; // Needs calibration -- Works (test map)
	public static final double PID_BLUE_SETPOINT   = 100;  // Needs calibration -- Not working (test map)
	
	public static final int TURN_TRAVEL_DISTANCE = 17;
	public static final int NORMAL_TURN_ANGLE = 85;
	public static final int TURN_ON_CIRCLE_ANGLE = 80;
	public static final int TURN_OFF_CIRCLE_ANGLE = 46;
	public static final int KEEP_ON_CIRCLE_DISTANCE = 2;
	public static final int PARK_TRAVEL_DISTANCE = 10;
	
	public static final float MAXSPEED = 2.4f * 360f; // 2 RPS
	public static final float SLOWSPEED = 2f * 360f;
	public static final double WHEELDIAMETER = 3;
	public static final double TRACKWIDTH = 13;
	public static final double PARK_LENGTH = 10;
	public static final double TACO_TO_CM = 0.3;
	
	public static final int[] BLACK_MIN = {0,0,0,3,0,0};
	public static final int[] BLACK_MAX = {31,20,20,48,31,20};
	public static final int[] WHITE_MIN = {9,233,225,49,7,43};
	public static final int[] WHITE_MAX = {145,255,255,255,142,83};
	public static final int[] GREEN_MIN = {0,235,120,12,0,11};
	public static final int[] GREEN_MAX = {40,255,227,68,39,67};
	public static final int[] BLUE_MIN = {0,116,66,33,8,0};
	public static final int[] BLUE_MAX = {44,194,166,99,65,51};
	public static final int[] YELLOW_MIN = {26,200,235,75,0,41};
	public static final int[] YELLOW_MAX = {97,244,255,170,46,82};	
	public static final int[] RED_MIN = {0,0,215,40,0,8};
	public static final int[] RED_MAX = {54,73,255,121,40,88};
	
	
	

	
}
