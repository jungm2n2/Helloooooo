package com.day9;

//생성자
//1.메모리 할당(객체생성)
//2.변수 초기화
//클래스의 이름과 동일
//리턴값이 없기 때문에 property가 없다.
//중복 정의가 가능하다.
//생성자에서 다른 생성자를 호출 할 수 있다.
//단, 코딩의 맨 선두에서 한번만 호출 가능하다.



public class Test2 {
	
	private int x;
	
	public Test2() {} //오버로딩 할때 기본 생성자를 명시하면 기본 생성자 사용 가능. 없을때는 오버로딩 된 생성자만 사용한다.
	
	//public Test2() { //기본 생성자, 인수가 없는 생성자. 모든 클래스에 숨어있다. 필요할때 꺼내 쓰기
		
		//this(30); //기본에서 오버로딩 호출. 선두에서만 가능
		
		//System.out.println("기본생성자~!~!!!~~!!~~~!!");
		
		//x = 10; //초기화. 우회도로 없이도 초기화 가능하다. 하지만 값이 고정된다. 그래서 우회도로 사용
		//System.out.println("x : " + x);
		
	//}
	
	public Test2(int x) {//생성자 중복정의
		
		//this(); //오버로딩 생성자에서 기본생성자 호출.
	
		//System.out.println("오버로딩 된 생성자~~~!~!!~!~!~!!");
		
		this.x = x ;
		//System.out.println("x : " + x);
	
	}
	
	
	public void setData(int x) { //우회도로
		this.x = x;
		
	}
	
	

	public static void main(String[] args) {

		Test2 ob1 = new Test2(); //기본생성자
		
		System.out.println(ob1.x); //0
		
		ob1.setData(100);
		
		System.out.println(ob1.x); //100
		
		//--------------------------------------
		
		Test2 ob2 = new Test2(20); //한번만 사용
		System.out.println(ob2.x);
		
		ob2.setData(4); //객체를 유지하면서 20->4 하기. 우회도로에서 지정
		System.out.println(ob2.x);
		
		Test2 ob3 = new Test2();
		Test2 ob4 = new Test2(60);
	}

}
