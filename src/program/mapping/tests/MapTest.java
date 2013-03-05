package program.mapping.tests;

import java.util.Map;

import program.mapping.Mapper;
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
	
	void test1() {
		Road map = Mapper.getMap();
		System.out.println(map.getChildLeft().getChildLeft().getChildLeft().getName());
	}
	
	public static void main(String[] args) {
		System.out.println("Testing started");
		MapTest mapTest = new MapTest();		
		mapTest.test1();	
		System.out.println("Testing stopped");
		
	}

}
