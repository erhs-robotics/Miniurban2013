package program.main;

public class MathUtils {
	
	public static double clamp(double value, double min, double max) {
		if(value < min) value = min;
		else if(value > max) value = max;
		assert value <= max && value >= min;
		
		return value;
	}
	public static float clamp(float value, float min, float max) {
		if(value < min) value = min;
		else if(value > max) value = max;
		assert value <= max && value >= min;
		
		return value;
	}
	
	public static boolean isWithin(int value, int min, int max) {
		if (value <=max && value >= min) return true;
		return false;
	}

}
