package program.main;

import lejos.nxt.MotorPort;
import lejos.nxt.SensorPort;

public class RoboMap {
	
	public static SensorPort LEFT_COLOR_SENSOR_PORT  = SensorPort.S2;
	public static SensorPort MID_COLOR_SENSOR_PORT   = SensorPort.S4;
	public static SensorPort RIGHT_COLOR_SENSOR_PORT = SensorPort.S1;
	
	public static MotorPort LEFT_MOTOR_PORT = MotorPort.B;
	public static MotorPort RIGHT_MOTOR_PORT = MotorPort.A;
	
	public static final double PID_WHITE_SETPOINT  = 160;
	public static final double PID_YELLOW_SETPOINT = 100;
	public static final double PID_BLUE_SETPOINT   = 85;
	public static final double PID_RED_SETPOINT = 130;
	
	public static final double WHITE_P = 0.0017;
	public static final double WHITE_I = 0;
	public static final double WHITE_D = 0.000;
	
	public static final double YELLOW_P = 0.0017;
	public static final double YELLOW_I = 0;
	public static final double YELLOW_D = 0;
	
	public static final double BLUE_P = 0.0025;
	public static final double BLUE_I = 0;
	public static final double BLUE_D = 0;
	
	public static final double RED_P  = .005;
	public static final double RED_I  = 0;
	public static final double RED_D  = 0;
	
	public static final int TURN_TRAVEL_DISTANCE = 18;
	public static final int OFF_OF_CIRCLE_DISTANCE = 18;
	public static final int NORMAL_TURN_ANGLE = 80;
	public static final int TURN_ON_CIRCLE_ANGLE = 80;
	public static final int TURN_OFF_CIRCLE_ANGLE = 46;
	public static final int KEEP_ON_CIRCLE_DISTANCE = 2;
	public static final int PARK_TRAVEL_DISTANCE = 15;
	public static final int OUT_OF_PARK_DISTANCE = -21;
	public static final int OUT_OF_PARK_TURN = 85;
	
	public static final float MAXSPEED = 2.4f * 360f;
	public static final float SLOWSPEED = 2f * 360f;
	public static final double WHEELDIAMETER = 3;
	public static final double TRACKWIDTH = 13;

	public static final double PARK_LENGTH = 20;
	public static final double TACHO_TO_CM = 1/20.0;
	
	public static final long STOP_WAIT_TIME = 1;
	public static final long PARK_WAIT_TIME = 5;	
	
	public static final int[] BLACK_MIN = {0,199,226,36,0,34};
	public static final int[] BLACK_MAX = {58,255,255,102,58,92};
	public static final int[] WHITE_MIN = {70,215,226,164,60,43};
	public static final int[] WHITE_MAX = {255,255,255,255,239,80};
	public static final int[] RED_MIN = {0,34,226,58,0,23};
	public static final int[] RED_MAX = {77,161,255,214,55,87};
	public static final int[] GREEN_MIN = {80,226,130,166,36,1};
	public static final int[] GREEN_MAX = {151,255,191,246,102,59};
	public static final int[] BLUE_MIN = {25,124,50,122,53,0};
	public static final int[] BLUE_MAX = {122,195,139,255,184,60};
	public static final int[] YELLOW_MIN = {71,174,226,183,14,32};
	public static final int[] YELLOW_MAX = {234,240,255,255,92,90};

	
	public static final double[] PARK_COUNTS = {0, 686.5, 1378.0, 2114.5, 0};

}
