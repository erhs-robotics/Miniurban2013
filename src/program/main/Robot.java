package program.main;

import lejos.nxt.NXTRegulatedMotor;
import lejos.robotics.navigation.DifferentialPilot;
import lejos.util.PIDController;
import program.main.MathUtils;
import lejos.nxt.addon.ColorHTSensor;
import lejos.robotics.Color;

public class Robot {
	
	private final float MAXSPEED = 2 * 360; // 2 RPM
	private final double WHEELDIAMETER = 4;
	private final double TRACKWIDTH = 4;
	
	private final NXTRegulatedMotor leftMotor, rightMotor;
	private ColorHTSensor leftColorSensor, midColorSensor, rightColorSensor;
	private DifferentialPilot pilot;
	
	private PIDController leftPID;
	private PIDController rightPID;
	
	public Robot() {
		leftMotor = new NXTRegulatedMotor(RoboMap.LEFT_MOTOR_PORT);
		rightMotor = new NXTRegulatedMotor(RoboMap.RIGHT_MOTOR_PORT);
		pilot = new DifferentialPilot(WHEELDIAMETER, TRACKWIDTH, leftMotor, rightMotor);
		leftColorSensor = new ColorHTSensor(RoboMap.LEFT_COLOR_SENSOR_PORT);
		midColorSensor = new ColorHTSensor(RoboMap.MID_COLOR_SENSOR_PORT);
		rightColorSensor = new ColorHTSensor(RoboMap.RIGHT_COLOR_SENSOR_PORT);
		leftPID = new PIDController(255, 50);
		rightPID = new PIDController(255, 50);
	}
	
	public Color getMidColor() {
		return midColorSensor.getColor();
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
	public float doPID (boolean leftPID) {
		int colorValue;
		int color;
		if (leftPID) {
			color = leftColorSensor.getColorID();
			if (color == Color.WHITE) {
				
				colorValue = leftColorSensor.getRGBComponent(ColorHTSensor.BLACK);
				System.out.println(colorValue);
				return this.leftPID.doPID(colorValue);
			}
			else if (color == Color.YELLOW) {
				colorValue = leftColorSensor.getRGBComponent(ColorHTSensor.YELLOW);
				return this.leftPID.doPID(colorValue);
			}
			else {
				return 0;
			}
		}
		else {
			color = rightColorSensor.getColorID();
			if (color == Color.WHITE) {
				colorValue = rightColorSensor.getRGBComponent(ColorHTSensor.BLACK);
				return this.rightPID.doPID(colorValue);
			}
			else if (color == Color.YELLOW) {
				colorValue = rightColorSensor.getRGBComponent(ColorHTSensor.YELLOW);
				return this.rightPID.doPID(colorValue);
			}
			else {
				return 0;
			}
		}
	}
	
	public void followLeftLine() {
		float speed = .6f;
		float value = doPID(true);
		System.out.println(value);
		//tankDrive(speed - (speed * value), speed + (speed * value));
	}
	public void followRightLine() {
		float speed = .6f;
		float value = doPID(false);
		System.out.println(value);
		tankDrive(speed + (speed * value), speed - (speed * value));
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
