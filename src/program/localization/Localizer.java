package program.localization;


public class Localizer {
	private final double pSense = 0.8;// The probability that the color sensed is correct
	private final double pMoveExact = 0.7;// The probability that the movement was correctly executed
	private final double pMoveUnderShoot = 0.15;// The probability that the robot moved less than predicted
	private final double pMoveOvershoot = 0.15;// The probability that the robot moved more than predicted
	private LinearColorMap map;// The map of all possible colors on the route
	private double[] grid;// The map of probable locations
	private double step;
	
	public Localizer() {
		
	}
	
	public void reset(LinearColorMap map) {
		step = 0;
		this.map = map;
		grid = new double[map.getLength()];
		for(int i=0;i<map.getLength();i++) {
			grid[i] = 1.0 / map.getLength();
		}
	}
	
	public void sense(Color color) {
		for(int x=0;x<grid.length;x++) {
			if(map.isColorAt(color, x))	grid[x] *= pSense;// pSense is the probability that the sensor is right
			else grid[x] *= 1 - pSense; // 1-pSense is the probability that the sensor is wrong						
		}
		normalize();
	}
	
	public void move(double value) {
		// Convert tachometer value to centimeters
		value = tacoTocm(value);
		//Save the exact value of value
		step += value;
		//Truncate the decimal to get the number of grid spaces moved
		int delta = (int) step;
		//Save the decimal in step so we can add it to value in the next motion
		step %= 1;
		
		// Save the current contents of grid to oldGrid
		double[] oldGrid = new double[map.getLength()];
		for(int i=0;i<grid.length;i++) {
			oldGrid[i] = grid[i];
		}
		//iterate over every grid
		for(int i=0;i<oldGrid.length;i++) {
			double p = 0;
			int dir = (delta / Math.abs(delta));// 1 or -1 depending on robot's direction
			if(i - delta >= 0 && i - delta <= oldGrid.length) {
				//if we move exactly what we predicted, then we came from
				//delta steps to the left. So the p(i) being correct
				//is the grid delta steps back (i - delta) * the probability our movement prediction
				//is correct
				p += oldGrid[i - delta] * pMoveExact;
			}
			if(i - delta - dir >= 0 && i - delta - dir <= oldGrid.length) {
				//if we underestimated the movement then we came from delta + a little more steps back				
				p += oldGrid[i - delta - dir] * pMoveOvershoot;
			}
			if(i - delta + dir >= 0 && i - delta + dir <= oldGrid.length) {
				//if we overestimated the movement then we came from a little less then delta steps back
				p += oldGrid[i - delta + dir] * pMoveUnderShoot;
			}
			
			grid[i] = p;
		}
		normalize();
	}
	//ensures that all the grid cells add up to one
	private void normalize() {
		double sum = 0;
		//find the sum off all the grids
		for(int i=0;i<grid.length;i++) {
			sum += grid[i];
		}
		//divide every cell by the sum
		for(int i=0;i<grid.length;i++) {
			grid[i] /= sum;
		}
	}
	
	// returns the number of the cell with the largest probability
	public int getLocation() {
		int max = 0;
		for(int i=0;i<grid.length;i++) {
			if(grid[i] > grid[max]) {
				max = i;
			}
		}
		
		return max;
	}
	
	public void print() {
		System.out.print("[");
		for(int i=0;i<grid.length;i++) {
			System.out.print(grid[i]);
			if(i+1 != grid.length) {
				System.out.print(", ");
			}
		}
		System.out.println("]");
	}
	
	private double tacoTocm(double taco) {
		return taco * 0.031875;
	}
	

}
