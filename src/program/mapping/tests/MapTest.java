package program.mapping.tests;

import program.mapping.Road;

public class MapTest {
	//  -----------------------
	//  -                     -
	//  -                     -
	//  -                     -
	//  -                     -
	//  -----------------------
	void test0() {
		Road top = new Road("top", 1);
		Road bottom = new Road("bottom", 1);
		Road left = new Road("left", 1);
		Road right = new Road("right", 1);		
		
		top.setRightChild(right);
		right.setRightChild(bottom);
		bottom.setRightChild(left);
		left.setRightChild(top);
		
		System.out.println(top.getChildRight().getChildRight().getName());
		
	}
	
	public static void main(String[] args) {
		System.out.println("Testing started");
		MapTest mapTest = new MapTest();		
		mapTest.test0();	
		System.out.println("Testing stopped");
		
	}

}
