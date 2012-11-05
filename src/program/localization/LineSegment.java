package program.localization;

public class LineSegment {
	private double x0, x1;
	private Color color;
	
	public LineSegment(double x0, double x1, Color color) {
		this.x0 = x0;
		this.x1 = x1;
		this.color = color;
	}
	
	public double getX0() {
		return x0;
	}
	
	public double getX1() {
		return x1;
	}
	
	public Color getColor() {
		return color;
	}
}
