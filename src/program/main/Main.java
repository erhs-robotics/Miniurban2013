package program.main;

import lejos.nxt.Button;
import lejos.robotics.Color;

public class Main {
	
	public static void main(String[] args) {
		Robot robot = new Robot();
		robot.setPIDConstants(1.0f, 0.0025f, 0.05f, 1, 0, 0);
		while (!Button.ENTER.isDown()) {
			//System.out.println("Go");
			//Mapper mapper = new Mapper();
			//Road currentRoad;
			//ArrayList<Goals>;
			//ArrayList<Step> = mapper.getPath(currentRoad, 
			//System.out.println(getColorString(robot.getMidColor()));
			robot.followLeftLine();
			//String midColor = getColorString(robot.getMidColor());
			//System.out.println(midColor);
			/*
			if (!(midColor.equals("Red"))) {
				robot.tankDrive(1, 1);
			}
			else { 
				robot.tankDrive(0, 0);
				break;
			}
			*/
		}
	}
	
	public static String getColorString(Color color) {
		int colorID = color.getColor();
		if (colorID == Color.BLACK) return "Black";
		else if (colorID == Color.BLUE) return "Blue";
		else if (colorID == Color.GREEN) return "Green";
		else if (colorID == Color.WHITE) return "White";
		else if (colorID == Color.RED) return "Red";
		else if (colorID == Color.YELLOW) return "Yellow";
		else return "Error";
	}

}
