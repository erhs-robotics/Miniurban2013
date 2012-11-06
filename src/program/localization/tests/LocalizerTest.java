package program.localization.tests;

import program.localization.Color;
import program.localization.LinearColorMap;
import program.localization.Localizer;

public class LocalizerTest {
	private LinearColorMap map;
	
	public LocalizerTest() {
		map = buildMap();
	}
	private LinearColorMap buildMap() {
		LinearColorMap map = new LinearColorMap(5);
		map.addSegment(0, 1, Color.White);
		map.addSegment(1, 3, Color.Red);		
		map.addSegment(3, 5, Color.Blue);		
		
		return map;
	}
	
	public void test0() {
		Localizer localizer = new Localizer();
		localizer.reset(map);
		
		localizer.sense(Color.White);
		localizer.print();
		
		localizer.move(3);
		localizer.print();
		
		localizer.sense(Color.Blue);
		localizer.print();
		
		
	}
	
	public static void main(String[] args) {
		LocalizerTest localizerTest = new LocalizerTest();
		localizerTest.test0();
		//System.out.println("yomon");

	}

}
