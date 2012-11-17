package program.mapping.tests;

import program.mapping.Mapper;
import program.mapping.Road;

public class MapperTest {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public void test0() throws Exception {
		Road R0 = new Road(1, 0, "R0");
		Road R1 = new Road(1, 0, "R1");
		Road R2 = new Road(1, 0, "R2");
		Road R3 = new Road(1, 0, "R3");
		Road R4 = new Road(1, 0, "R4");
		Road R5 = new Road(1, 0, "R5");
		Road R6 = new Road(1, 0, "R6");
		Road R7 = new Road(2, 0, "R7");
		Road R8 = new Road(1, 0, "R8");
		Road R9 = new Road(2, 0, "R9");
		
		R0.setRightChild(R9);
		R0.setLeftChild(R1);
		
		R1.setRightChild(R2);
		
		R2.setStraightChild(R4);
		R2.setRightChild(R3);
		
		R3.setLeftChild(R6);
		
		R4.setRightChild(R5);
		
		//R5 has no children
		//R6 has no children
		
		R7.setRightChild(R6);
		
		R8.setLeftChild(R7);
		
		R9.setLeftChild(R8);
		
		
		
		Mapper mapper = new Mapper();
		
		mapper.findPath(R0, R6);
		
		for(int i=0;i<mapper.getPath().size();i++) {
			System.out.println(mapper.getPath().get(i));
		}
		
	}
	
	public void test1() throws Exception {
		Road R0 = new Road(1, 0, "R0");
		Road R1 = new Road(1, 0, "R1");
		Road R2 = new Road(1, 0, "R2");
		Road R3 = new Road(1, 0, "R3");
		Road R4 = new Road(2, 0, "R4");
		Road R5 = new Road(2, 0, "R5");
		Road R6 = new Road(1, 0, "R6");
		Road R7 = new Road(1, 0, "R7");
		Road R8 = new Road(1, 0, "R8");
		Road R9 = new Road(1, 0, "R9");
		Road R10 = new Road(1, 0, "R10");
		Road R11 = new Road(1, 0, "R11");
		Road R12 = new Road(1, 0, "R12");
		
		R0.setLeftChild(R1);
		
		R1.setLeftChild(R2);
		
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
		
		R12.setRightChild(R0);
		R12.setStraightChild(R1);
		
		Mapper mapper = new Mapper();
		
		mapper.findPath(R0, R12);
		System.out.println(R7.getG_value());
		System.out.println(R6.getG_value());
		System.out.println(R5.getG_value());
		for(int i=0;i<mapper.getPath().size();i++) {
			System.out.println(mapper.getPath().get(i));
		}
		
	}
	
	public static void main(String[] args) throws Exception {
		System.out.println("Test Started");
		MapperTest mapperTest = new MapperTest();
		
		mapperTest.test1();

		System.out.println("Test Finished");
	}

}
