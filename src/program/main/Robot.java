package program.main;

import java.util.ArrayList;

import lejos.nxt.NXTRegulatedMotor;
import lejos.nxt.addon.ColorHTSensor;
import lejos.robotics.Color;
import lejos.robotics.navigation.DifferentialPilot;
import program.control.PIDControllerX;
import program.mapping.Direction;
import program.mapping.Step;

public class Robot {
	
	private final float MAXSPEED = 2 * 360; // 2 RPS
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
		pid = new PIDControllerX((1.0/120.0), 0.0, 5.0, 60.0);
		pid.setOutputCaps(-.5, .5);
	}
	
	public Color getLeftColor() { return leftColorSensor.getColor(); }
	public Color getMidColor() { return midColorSensor.getColor(); }
	public Color getRightColor() { return rightColorSensor.getColor(); }
	
	public boolean checkForStop() {
		if ( getMidColor().getColor() == Color.RED)	return true;
		else return false;		
	}

	public double runPID (boolean leftPID) {
		ColorHTSensor colorSensor = leftPID ? this.leftColorSensor : this.rightColorSensor;
		int colorID = colorSensor.getColorID();
		int colorValue = colorSensor.getRGBComponent(ColorHTSensor.BLACK);
		if (colorID == Color.WHITE) {
			return this.pid.getOutput(colorValue, RoboMap.PID_WHITE_SETPOINT);
		}
		else if (colorID == Color.YELLOW) {
			return this.pid.getOutput(colorValue, RoboMap.PID_YELLOW_SETPOINT);
		}
		else if (colorID == Color.BLUE) {
			return this.pid.getOutput(colorValue, RoboMap.PID_BLUE_SETPOINT);
		}
		else if (colorID == Color.GREEN) {
			return -.2;
		}
		return .1;
	}
	
	public void followLeftLine(boolean isCircle) {
		double speed = .5;
		double value = runPID(true);
		if(isCircle) {
			value *= 2;
		}
		//System.out.println(value);
		//System.out.println((speed - (speed * value)) + ", " + (speed + (speed * value)));
		//tankDrive(speed - (speed * value), speed + (speed * value));
		tankDrive(speed - value, speed + value);
	}
	public void followRightLine(boolean isCircle) {
		double speed = .5;
		double value = runPID(false);
		if (isCircle) {
			value *= 2;
		}
		//System.out.println(value);mine	
		//System.out.println((speed + (speed * value)) + ", " + (speed - (speed * value)));
		//tankDrive(speed + (speed * value), speed - (speed * value));
		tankDrive(speed + value, speed - value);
	}
	public void turnLeft() {
		pilot.travel(5);
		followLeftLine(false);
	}
	public void turnRight() {
		pilot.travel(5);
		followRightLine(false);
	}
	public void followSteps(ArrayList<Step> steps) {
		Step currentStep, nextStep;
		while (steps.size() > 1) {
			currentStep = steps.get(0);
			nextStep = steps.get(1);
			if (currentStep.getDirection() == Direction.Straight && nextStep.getDirection() == Direction.Right) {
				do followRightLine(false); while (!checkForStop()); 
				turnRight();
			}
			else if (currentStep.getDirection() == Direction.Straight && nextStep.getDirection() == Direction.Left) {
				do followLeftLine(false); while (!checkForStop());
				turnLeft();
			}
			else if (currentStep.getRoad().isCircle() && nextStep.getDirection() == Direction.Left) {
				do followRightLine(true); while (!checkForStop());
				turnLeft();
			}
			else if (currentStep.getRoad().isCircle() && nextStep.getDirection() == Direction.Right) {
				do followLeftLine(true); while (!checkForStop()); 
				turnRight();
			}
			steps.remove(0);
		}
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
	public void tankDrive(double left, double right, boolean cubeInputs) {
		if (cubeInputs) {
			left = MathUtils.clamp(left, -1, 1);
			right = MathUtils.clamp(right, -1, 1);
			left = left * left * left;
			right = right * right * right;
			tankDrive(left, right);
		} else {
			tankDrive(left, right);
		}
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
