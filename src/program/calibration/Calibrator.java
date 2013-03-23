package program.calibration;

import program.main.MathUtils;
import program.main.Robot;
import lejos.nxt.Button;
import lejos.nxt.addon.ColorHTSensor;
import lejos.nxt.comm.RConsole;

public class Calibrator {
	
	public static final int VARIANCE = 29;
	
	public static void calibrateColor(ColorHTSensor sensor, String name) {
		
		int[] black  = new int[6];
		int[] white  = new int[6];
		int[] red    = new int[6];
		int[] green  = new int[6];
		int[] blue   = new int[6];
		int[] yellow = new int[6];
		
		System.out.println("Please be ready to provide 5 color samples of the " 
							+ "color to be calibrated");
		System.out.println("When you are over the sample, press the right button");
		
		for (int i = 0; i < 6; i++) {
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
		RConsole.println("public static final int[] " + name + "_MIN = {" + min(black) + "," + min(white) + "," + 
							min(red) + "," + min(green) + "," + 
							min(blue) + "," + min(yellow) + "};");
		
		RConsole.println("public static final int[] " + name + "_MAX = {" + max(black) + "," + max(white) + "," + 
				max(red) + "," + max(green) + "," + 
				max(blue) + "," + max(yellow) + "};");		
		
		
	}
	
	private static String min(int[] array) {
		int out = (int)(MathUtils.arrayMin(array) - VARIANCE);
		if (out < 0) out = 0;
		return Integer.toString(out);
	}
	private static String max(int[] array) {
		int out = (int)(MathUtils.arrayMax(array) + VARIANCE);
		if (out > 255) out = 255;
		return Integer.toString(out);
	}
	
}
