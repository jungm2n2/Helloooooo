package com.day8;


//static
//알아서 메모리에 올라감(메모리 할당을 받음)
//객체를 1000번 생성해도 메모리 공간은 1개.


public class Test2 {
	
	public static int a = 10;//class변수
	//클래스 변수 또는 클래스 메소드 클래스가 로딩되는 순간
	//메모리 할당이 이루어지며 [클래스이름.객체]를 통해서 접근 가능하다.
	//즉, new를 통해서 메모리 할당을 받지 않아도 사용 가능하다.
	
	
	
	
	public int b = 20;//instance 변수
	//인스턴스 변수는 new를 통해서 메모리 할당을 받아야만 사용이 가능하고,
	//클래스 메소드 에서는 접근이 불가능하다.
	
	
	public void write() { //instance 메소드
		System.out.println("class변수: "+ a);
		System.out.println("instance 변수: "+b);
		
		
	}

	
	public static void print() {//class 메소드

		System.out.println("class변수: "+ a);
		//System.out.println("instance 변수: "+b);
		
		
	}
	
	

	public static void main(String[] args) {
		
		System.out.println("class변수: "+a);
		System.out.println("class변수: "+Test2.a);
		
		//System.out.println("instance변수: "+Test2.b); 에러생김. 아직 new를 만나지 못했기 때문.
		
		//write(); new로 객체를 생성해야만 사용 가능
		print();
		Test2.print();
		
		
		Test2 ob = new Test2(); //객체생성
		
		
		System.out.println(ob.a);
		System.out.println(Test2.a);
		
		ob.write();
		
		ob.print();
		Test2.print();
		
		System.out.println(ob.a);
		System.out.println(ob.b);
		
		System.out.println("---------------------------------");
		
		Test2 ob1 = new Test2();
		
		ob1.a = 500;
		ob1.b = 200;
		System.out.println(ob1.a);
		System.out.println(ob1.b);
		
		System.out.println("---------------------------------");
		
		
		Test2 ob2 = new Test2();
		System.out.println(ob2.a);
		System.out.println(ob2.b);
		
		System.out.println("---------------------------------");
		
		
		Test2 ob3 = new Test2();
		System.out.println(ob3.a);
		System.out.println(ob3.b);

	}

}
