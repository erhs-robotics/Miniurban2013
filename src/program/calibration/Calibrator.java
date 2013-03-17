package program.calibration;

import lejos.nxt.Button;
import lejos.nxt.addon.ColorHTSensor;

public class Calibrator {
	
	public static void calibrateColor(ColorHTSensor sensor) {
		
		int[] black  = new int[5];
		int[] white  = new int[5];
		int[] red    = new int[5];
		int[] green  = new int[5];
		int[] blue   = new int[5];
		int[] yellow = new int[5];
		
		System.out.println("Please be ready to provide 5 color samples of the " 
							+ "color to be calibrated");
		System.out.println("When you are over the sample, press the right button");
		
		for (int i = 0; i < 5; i++) {
			System.out.println("Sample " + i);
			while(!Button.RIGHT.isDown()) { ; }
			try { Thread.sleep(200); } 
			catch (InterruptedException ex) { ex.printStackTrace(); }
			black[i]  = sensor.getRGBComponent(ColorHTSensor.BLACK);
			white[i]  = sensor.getRGBComponent(ColorHTSensor.WHITE);
			red[i]    = sensor.getRGBComponent(ColorHTSensor.RED);
			green[i]  = sensor.getRGBComponent(ColorHTSensor.GREEN);
			blue[i]   = sensor.getRGBComponent(ColorHTSensor.BLUE);
			yellow[i] = sensor.getRGBComponent(ColorHTSensor.YELLOW);
		}
		
		// ToDo: Print out results of calibration
		
	}
	
}
