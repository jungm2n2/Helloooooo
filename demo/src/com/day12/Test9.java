package com.day12;


class TestA{
	
	public void print() {
		System.out.println("TestA 클래스");
		
	}
}


class TestB extends TestA{
	
	public void print() {
		System.out.println("TestB 클래스");
		
	}
}

public class Test9 {

	public static void main(String[] args) {
		
		
		TestA a = new TestA();
		TestB b;
		
		a.print();
		
		//b=a;
		
		
		b = (TestB)a;
		

	}

}
