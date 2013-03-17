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
	
	public static int arrayMax(int[] array) {
		int max = array[0];
		for(int i = 1; i < array.length; i++) {
			if (array[i] > max) max = array[i];
		}
		return max;
	}
	
	public static int arrayMin(int[] array) {
		int min = array[0];
		for(int i = 1; i < array.length; i++) {
			if (array[i] < min) min = array[i];
		}
		return min;
	}

}
