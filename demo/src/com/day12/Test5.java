package com.day12;

//Singleton
//static -> 객체를 여러번 생성해도 메모리 공간은 한개만 생성한다.

class Sing{
	
	private static Sing ob;
	
	public static Sing getInstance() {
		if(ob==null) {
			ob = new Sing();
		}
		return ob;
	}
	
	
}

public class Test5 {

	public static void main(String[] args) {
		
		
		Sing ob1 = Sing.getInstance();
		Sing ob2 = Sing.getInstance();
		
		if(ob1==ob2)
			System.out.println("동일 객체...");
		
		

	}

}
