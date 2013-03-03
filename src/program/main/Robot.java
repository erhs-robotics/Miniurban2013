package program.main;

import lejos.nxt.NXTRegulatedMotor;
import lejos.robotics.navigation.DifferentialPilot;
import program.main.MathUtils;
import lejos.nxt.addon.ColorHTSensor;
import lejos.robotics.Color;

import program.control.PIDControllerX;

public class Robot {
	
	private final float MAXSPEED = 2 * 360; // 2 RPM
	private final double WHEELDIAMETER = 4;
	private final double TRACKWIDTH = 4;
	
	private final NXTRegulatedMotor leftMotor, rightMotor;
	private ColorHTSensor leftColorSensor, midColorSensor, rightColorSensor;
	private DifferentialPilot pilot;
	
	public PIDControllerX pid;
	
	public Robot() {
		leftMotor = new NXTRegulatedMotor(RoboMap.LEFT_MOTOR_PORT);
		rightMotor = new NXTRegulatedMotor(RoboMap.RIGHT_MOTOR_PORT);
		pilot = new DifferentialPilot(WHEELDIAMETER, TRACKWIDTH, leftMotor, rightMotor);
		leftColorSensor = new ColorHTSensor(RoboMap.LEFT_COLOR_SENSOR_PORT);
		midColorSensor = new ColorHTSensor(RoboMap.MID_COLOR_SENSOR_PORT);
		rightColorSensor = new ColorHTSensor(RoboMap.RIGHT_COLOR_SENSOR_PORT);
		pid = new PIDControllerX(1.0, 0.0, 5.0, 60);
	}
	
	public Color getLeftColor() { return leftColorSensor.getColor(); }
	public Color getMidColor() { return midColorSensor.getColor(); }
	public Color getRightColor() { return rightColorSensor.getColor(); }

	public double runPID (boolean leftPID) {
		int colorValue;
		int color;
		if (leftPID) {
			color = leftColorSensor.getColorID();
			/*if (color == Color.WHITE) {*/
				colorValue = leftColorSensor.getRGBComponent(ColorHTSensor.BLACK);
				//if (colorValue > 75) colorValue = 75;
				//System.out.println(colorValue);
				return this.pid.getOutput(colorValue);
			//}
			/*
			else if (color == Color.YELLOW) {
				colorValue = leftColorSensor.getRGBComponent(ColorHTSensor.YELLOW);
				return this.leftPID.doPID(colorValue);
			}
			else if (color == Color.GREEN) {
				return -5f;
			}
			else {
				return .5f;
			}
			*/
		}
		else {
			color = rightColorSensor.getColorID();
			if (color == Color.WHITE) {
				colorValue = rightColorSensor.getRGBComponent(ColorHTSensor.BLACK);
				return this.pid.getOutput(colorValue);
			}
			else if (color == Color.YELLOW) {
				colorValue = rightColorSensor.getRGBComponent(ColorHTSensor.YELLOW);
				return this.pid.getOutput(colorValue);
			}
			else {
				return 0;
			}
		}
	}
	
	public void followLeftLine(boolean iscircle) {
		double speed = 1;
		double value = runPID(true);
		if(iscircle) {
			value /= 100f;
		} else {
			value /= 200f;
		}
		//System.out.println(value);
		System.out.println((speed - (speed * value)) + ", " + (speed + (speed * value)));
		tankDrive(speed - (speed * value), speed + (speed * value));
	}
	
	public void followRightLine(boolean isCircle) {
		double speed = .6f;
		double value = runPID(false);
		System.out.println(value);
		tankDrive(speed + (speed * value), speed - (speed * value));
	}
	
	public void tankDrive(double left, double right) {
		//clamp values between [-1, 1]
		left = MathUtils.clamp(left, -1, 1);
		right = MathUtils.clamp(right, -1, 1);
		
		float leftDrive = (float) left;
		float rightDrive = (float) right;
		
		leftMotor.setSpeed(MAXSPEED * leftDrive);
		rightMotor.setSpeed(MAXSPEED * rightDrive);
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
