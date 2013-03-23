package program.mapping.tests;

import java.util.ArrayList;

import lejos.nxt.comm.RConsole;

import program.main.Robot;
import program.mapping.Direction;
import program.mapping.Goal;
import program.mapping.Map;
import program.mapping.Mapper;
import program.mapping.Road;
import program.mapping.Step;

public class MapperTest {

	public void test0() throws Exception {
		Road R0 = new Road("R0", 1);
		Road R1 = new Road("R1", 1);
		Road R2 = new Road("R2", 1);
		Road R3 = new Road("R3", 1);
		Road R4 = new Road("R4", 1);
		Road R5 = new Road("R5", 1);
		Road R6 = new Road("R6", 1);
		Road R7 = new Road("R6", 1);
		
		R0.setLeftChild(R2);
		
		R1.setRightChild(R2);
		
		R2.setRightChild(R4);
		R2.setSlow(true);
		
		R3.setStraightChild(R4);
		R3.setCircle(true);
		R3.setSlow(true);
		
		R4.setRightChild(R5);
		R4.setStraightChild(R3);
		R4.setCircle(true);
		R4.setSlow(true);
		
		R5.setLeftChild(R6);
		R5.setSlow(true);
		
		//R6 has no children
		
		R7.setRightChild(R3);
		R7.setSlow(true);
		
		
		Mapper mapper = new Mapper();
		ArrayList<Goal> goals = new ArrayList<Goal>();
		goals.add(new Goal("R6", 2, Direction.Left));
		ArrayList<Step> path = mapper.getPath(R0, goals);
		
		for(int i=0;i<path.size();i++) {
			path.get(i).print();
		}
		Robot robot = new Robot();
		
		robot.followSteps(path);
		
		//while(!robot.checkForStop()) robot.followRightLine(false);

	}
	
	public void test1() throws Exception {
		Road R0 = new Road("R0", 1);
		Road R1 = new Road("R1", 10);
		Road R2 = new Road("R2", 5);
		Road R3 = new Road("R3", 1);
		Road R4 = new Road("R4", 2, 0.5);
		Road R5 = new Road("R5", 2, 0.5);
		Road R6 = new Road("R6", 1);
		Road R7 = new Road("R7", 1);
		Road R8 = new Road("R8", 1);
		Road R9 = new Road("R9", 1);
		Road R10 = new Road("R10", 1);
		Road R11 = new Road("R11", 1);
		Road R12 = new Road("R12", 1);
		
		R0.setLeftChild(R1);
		
		R1.setRightChild(R2);
		
		R2.setLeftChild(R3);
		
		R3.setLeftChild(R4);
		R3.setStraightChild(R6);
		
		R4.setLeftChild(R9);
		R4.setStraightChild(R5);
		
		R5.setLeftChild(R7);
		
		R6.setStraightChild(R7);
		
		R7.setLeftChild(R8);
		
		R8.setStraightChild(R11);
		
		R9.setRightChild(R10);
		
		R10.setLeftChild(R11);
		
		R11.setLeftChild(R12);
		
		R12.setLeftChild(R0);
		R12.setStraightChild(R1);
		
		Mapper mapper = new Mapper();
		
		ArrayList<Goal> goals = new ArrayList<Goal>();
		
		goals.add(new Goal("R3", 2, Direction.Left));
		goals.add(new Goal("R10", 4, Direction.Right));		
		
		ArrayList<Step> path = mapper.getPath(R1, goals);	
		
		for(int i=0;i<path.size();i++) {
			path.get(i).print();
		}
		
	}
	
	public void test2() throws Exception {
		Road map = Map.getMap();
		ArrayList<Goal> goals = new ArrayList<Goal>();
		
		goals.add(new Goal("R1", 2, Direction.Left));
		goals.add(new Goal("R15", 4, Direction.Right));
		goals.add(new Goal("R45", 4, Direction.Right));
		goals.add(new Goal("R55", 4, Direction.Right));
		goals.add(new Goal("R69", 4, Direction.Right));
		goals.add(new Goal("R36", 4, Direction.Right));
		
		Mapper mapper = new Mapper();
		ArrayList<Step> path = mapper.getPath(map, goals);
		
		for(int i=0;i<path.size();i++) {
			path.get(i).print();
		}
	}
	
	public static void main(String[] args) throws Exception {
		RConsole.openBluetooth(0);
		RConsole.println("THIS IS R!!!!");
		System.out.println("Test Started");		
		
		MapperTest mapperTest = new MapperTest();
		
		mapperTest.test0();

		System.out.println("Test Finished");
	}

}
