package com.day13;

//2.내부 클래스(Local) 메소드 안에 클래스를 만든ㄱ

class Outer2{
	
	static int a = 10;
	int b = 20;
	
	public void write() {
		
		int c = 30;
		final int d= 40;
		
		class Inner2{
			
			public void print() {
				System.out.println(a);
				System.out.println(b);
				System.out.println(c);
				System.out.println(d);
				
				
				
				
			}
			
			
			
		}
		
		Inner2 ob = new Inner2();
		ob.print();
		
		
		
	}
	
	
}

public class Test5 {

	public static void main(String[] args) {
		
		Outer2 out = new Outer2();
		out.write();

	}

}
