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
		LinearColorMap map = new LinearColorMap(10);
		map.addSegment(0, 5, Color.White);
		map.addSegment(5, 6, Color.Red);
		map.addSegment(6, 8, Color.White);
		map.addSegment(8, 10, Color.Blue);		
		
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
