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
	public static final double PID_YELLOW_SETPOINT = 185;
	public static final double PID_BLUE_SETPOINT   = 116;
	
	public static final int TURN_TRAVEL_DISTANCE = 19;
	public static final int OFF_OF_CIRCLE_DISTANCE = 18;
	public static final int NORMAL_TURN_ANGLE = 85;
	public static final int TURN_ON_CIRCLE_ANGLE = 80;
	public static final int TURN_OFF_CIRCLE_ANGLE = 46;
	public static final int KEEP_ON_CIRCLE_DISTANCE = 2;
	public static final int PARK_TRAVEL_DISTANCE = 10;
	public static final int OUT_OF_PARK_DISTANCE = -23;
	public static final int OUT_OF_PARK_TURN = 80;
	
	public static final float MAXSPEED = 2.4f * 360f;
	public static final float SLOWSPEED = 2f * 360f;
	public static final double WHEELDIAMETER = 3;
	public static final double TRACKWIDTH = 13;

	public static final double PARK_LENGTH = 20;
	public static final double TACO_TO_CM = 1/20.0;
	
	public static final long STOP_WAIT_TIME = 1;
	public static final long PARK_WAIT_TIME = 5;
	
	public static final double WHITE_P = 0.0015;
	public static final double WHITE_I = 0;
	public static final double WHITE_D = 0.0001;
	public static final double YELLOW_P = 0.003;
	public static final double YELLOW_I = 0;
	public static final double YELLOW_D = 0;
	public static final double BLUE_P = 0.005;
	public static final double BLUE_I = 0;
	public static final double BLUE_D = 0;
	
	public static final int[] BLACK_MIN = {2,226,197,43,0,34};
	public static final int[] BLACK_MAX = {67,255,255,119,65,92};
	public static final int[] WHITE_MIN = {142,226,197,226,134,34};
	public static final int[] WHITE_MAX = {255,255,255,255,255,92};
	public static final int[] RED_MIN = {19,34,226,164,0,23};
	public static final int[] RED_MAX = {78,95,255,229,60,81};
	public static final int[] GREEN_MIN = {19,226,121,72,13,1};
	public static final int[] GREEN_MAX = {107,255,220,209,102,76};
	public static final int[] BLUE_MIN = {43,94,62,206,97,0};
	public static final int[] BLUE_MAX = {117,185,162,255,182,60};
	public static final int[] YELLOW_MIN = {178,226,202,226,30,32};
	public static final int[] YELLOW_MAX = {255,255,255,255,100,90};

}
