package com.day7; //하나의 file안에 여러개의 class를 만들 수 있다.

/*public*/class Sub{ //이때는 public 지우기
	
	int a,b;
	
	
	
	
	
	
	
	
}







public class Test2 {

	public static void main(String[] args) {
		
		Sub ob1 = new Sub();
		Sub ob2 = new Sub();
		
		System.out.println("ob1.a: "+ob1.a);
		System.out.println("ob1.b: "+ob1.b);
		
		ob1.a=10;
		ob1.b=20;
		System.out.println("ob1.a: "+ob1.a);
		System.out.println("ob1.b: "+ob1.b);
		
		ob2.a=100;
		ob2.b=200;
		System.out.println("ob2.a: "+ob2.a);
		System.out.println("ob2.b: "+ob2.b);
		
		System.out.println("ob1.a: "+ob1.a);
		System.out.println("ob1.b: "+ob1.b);
				
		

	}

}
