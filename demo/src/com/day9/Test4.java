package com.day9;

public class Test4 {
	
	int a = 5;
	
	//초기화 블럭. new를 만나면! 딱 한번만 실행된다(이름이 없기 때문에 재호출 불가능).
	{
		System.out.println("초기화 블럭a : "+ a);
		a = 10;
		System.out.println("초기화 블럭a : "+ a);
	}

	//System.out.println("초기화 블럭a : "+ a); //변수만 밖에 써줄 수 있다.
	
	
	static int b;
	static { //로딩하면 알아서 실행. static 블럭은 무조건 딱 한번만 실행.
		b = 10;
		System.out.println("초기화 블럭b : "+ b);
		
	}
	
	final int C; //상수. 초기화 필수(C=0). 대문자로 씀.
	
	
	public Test4() { //기본생성자
		
		System.out.println("생성자..");
		C=100; //초기화
		System.out.println("C : "+C);
		
	}
	
	
	public static void main(String[] args) {
		
		Test4 ob1 = new Test4();
		Test4 ob2 = new Test4();
		
		//실행순서 : static -> new(instance 변수, 메소드) -> 생성자

	}

}
