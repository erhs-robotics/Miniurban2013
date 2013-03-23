package program.localization;

public class ParkingMaps {
	public static LinearColorMap R1_Park;
	public static LinearColorMap R36_Park;
	public static LinearColorMap R69_Park;
	public static LinearColorMap R45_Park;
	public static LinearColorMap R51_Park;
	public static LinearColorMap R41_Park;
	public static LinearColorMap R59_Park;
	public static LinearColorMap R55_Park;
	public static LinearColorMap R15_Park;
	
	public static void buildParkingMaps() {
		R1_Park = new LinearColorMap(5);
		R36_Park = new LinearColorMap(1);
		R69_Park = new LinearColorMap(1);
		R45_Park = new LinearColorMap(1);
		R51_Park = new LinearColorMap(1);
		R41_Park = new LinearColorMap(1);
		R59_Park = new LinearColorMap(1);
		R55_Park = new LinearColorMap(1);
		R15_Park = new LinearColorMap(1);
		
		//R1_Park.addSegment(x0, x1, color)
	}

}
