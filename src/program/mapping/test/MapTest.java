package program.mapping.test;

import program.mapping.Road;

public class MapTest {
	//  -----------------------
	//  -                     -
	//  -                     -
	//  -                     -
	//  -                     -
	//  -----------------------
	void test0() {
		Road top = new Road(0, "top");
		Road bottom = new Road(0, "bottom");
		Road left = new Road(0, "left");
		Road right = new Road(0, "right");		
		
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
