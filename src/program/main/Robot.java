package program.main;

import lejos.nxt.ColorSensor;
import lejos.nxt.ColorSensor.Color;
import lejos.nxt.NXTRegulatedMotor;
import lejos.robotics.navigation.DifferentialPilot;
import lejos.util.PIDController;
import program.main.MathUtils;

public class Robot {
	
	private final float MAXSPEED = 2 * 360; // 2 RPM
	private final double WHEELDIAMETER = 4;
	private final double TRACKWIDTH = 4;
	
	private final NXTRegulatedMotor leftMotor, rightMotor;
	private ColorSensor leftColorSensor, midColorSensor, rightColorSensor;
	private DifferentialPilot pilot;
	
	private PIDController leftPID;
	private PIDController rightPID;
	
	public Robot() {
		leftMotor = new NXTRegulatedMotor(RoboMap.LEFT_MOTOR_PORT);
		rightMotor = new NXTRegulatedMotor(RoboMap.RIGHT_MOTOR_PORT);
		pilot = new DifferentialPilot(WHEELDIAMETER, TRACKWIDTH, leftMotor, rightMotor);
		leftColorSensor = new ColorSensor(RoboMap.LEFT_COLOR_SENSOR_PORT);
		midColorSensor = new ColorSensor(RoboMap.MID_COLOR_SENSOR_PORT);
		rightColorSensor = new ColorSensor(RoboMap.RIGHT_COLOR_SENSOR_PORT);
	}
	
	public Color getLeftColor() {
		return leftColorSensor.getColor();
	}
	public Color getMidColor() {
		return midColorSensor.getColor();
	}
	public Color getRightColor() {
		return rightColorSensor.getColor();
	}

	public void setPIDConstants(float left_kp, float left_ki, float left_kd,
								float right_kp, float right_ki, float right_kd) {
		leftPID.setPIDParam(PIDController.PID_KP, left_kp);
		leftPID.setPIDParam(PIDController.PID_KI, left_ki);
		leftPID.setPIDParam(PIDController.PID_KD, left_kd);
		rightPID.setPIDParam(PIDController.PID_KP, right_kp);
		rightPID.setPIDParam(PIDController.PID_KI, right_ki);
		rightPID.setPIDParam(PIDController.PID_KD, right_kd);	
	}
	public void setPIDSetpoints(float left_setpoint, float right_setpoint) {
		leftPID.setPIDParam(PIDController.PID_SETPOINT, left_setpoint);
		rightPID.setPIDParam(PIDController.PID_SETPOINT, right_setpoint);
	}
	public int doLeftPID(Color left_value) {
		return leftPID.doPID(left_value);
	}
	public int doRightPID(Color right_value) {
		return rightPID.doPID(right_value);
	}
	
	public void followLeftLine() {
		float speed = .8f;
		tankDrive(doLeftPID(getLeftColor()) * speed, speed)
	}
	public void tankDrive(float left, float right) {
		//clamp values between [-1, 1]
		left = MathUtils.clamp(left, -1, 1);
		right = MathUtils.clamp(right, -1, 1);
		
		leftMotor.setSpeed(MAXSPEED * left);
		rightMotor.setSpeed(MAXSPEED * right);
		leftMotor.forward();
		rightMotor.forward();
	}
	public void displacementDrive(float speed, float displacement) {
		displacement = MathUtils.clamp(displacement, -1, 1);
		
		float leftSpeed = speed - displacement / 2;
		float rightSpeed = speed - displacement / 2;
		
		leftSpeed = MathUtils.clamp(leftSpeed, -1, 1);
		rightSpeed = MathUtils.clamp(rightSpeed, -1, 1);		
		
		leftMotor.setSpeed(MAXSPEED * leftSpeed);
		rightMotor.setSpeed(MAXSPEED * rightSpeed);
		leftMotor.forward();
		rightMotor.forward();
	}
	public void stop() {
		pilot.stop();
	}

}
