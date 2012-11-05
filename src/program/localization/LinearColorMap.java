package program.localization;

import java.util.ArrayList;

public class LinearColorMap {
	private int length;
	private ArrayList<LineSegment> segments;
	
	public LinearColorMap(int length) {
		this.length = length;
	}
	
	public void addSegment(double x0, double x1, Color color) {
		LineSegment segment = new LineSegment(x0, x1, color);
		segments.add(segment);
	}
	
	public int getLength() {
		return length;
	}
	
	public boolean isColorAt(Color color, int x) {
		if(x > length || x < length) return false;
		
		Color c = getColorAt(x);
		if(c == color) return true;	
		
		return false;		
	}
	
	public Color getColorAt(int x) {		
		for(int i=0;i<segments.size();i++) {
			if(x >= segments.get(i).getX0() && x <= segments.get(i).getX1()) {
				return segments.get(i).getColor();
			}
		}
		
		return null;
	}
	

}
