package program.main;

import lejos.nxt.Motor;
import lejos.nxt.NXTRegulatedMotor;
import lejos.robotics.navigation.DifferentialPilot;
import program.main.MathUtils;




public class Robot {
	private final double WHEELDIAMETER = 4;
	private final double TRACKWIDTH = 4;
	private final NXTRegulatedMotor LEFTMOTOR = Motor.B;
	private final NXTRegulatedMotor RIGHTMOTOR = Motor.A;
	private final float MAXSPEED = 720; //2 RPM
	
	private DifferentialPilot pilot = new DifferentialPilot(WHEELDIAMETER, TRACKWIDTH, LEFTMOTOR, RIGHTMOTOR);
	
	public Robot() {
		
		
	}
	
	//drives each wheel proportional to left and right respectively 
	public void tankDrive(float left, float right) {
		//clamp values between [-1, 1]
		left = MathUtils.clamp(left, -1, 1);
		right = MathUtils.clamp(right, -1, 1);
		
		LEFTMOTOR.setSpeed(MAXSPEED * left);
		RIGHTMOTOR.setSpeed(MAXSPEED * right);
		LEFTMOTOR.forward();
		RIGHTMOTOR.forward();
	}
	
	//Drives at an angle proportional to displacement
	public void displacementDrive(float speed, float displacement) {
		displacement = MathUtils.clamp(displacement, -1, 1);
		
		float leftSpeed = speed - displacement / 2;
		float rightSpeed = speed - displacement / 2;
		
		leftSpeed = MathUtils.clamp(leftSpeed, -1, 1);
		rightSpeed = MathUtils.clamp(rightSpeed, -1, 1);		
		
		LEFTMOTOR.setSpeed(MAXSPEED * leftSpeed);
		RIGHTMOTOR.setSpeed(MAXSPEED * rightSpeed);
		LEFTMOTOR.forward();
		RIGHTMOTOR.forward();
	}
	
	public void stop() {
		pilot.stop();
	}
	

}
