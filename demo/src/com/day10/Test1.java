package com.day10;

//상속(부모가 자식한테 주는것)
//1.부모꺼는 내꺼다.
//2.private로 선언한 것은 상속이 안됨
//3.protected로 선언한 것은 상속이 가능하다
//4.내꺼는 내꺼다
//5.부모와 같은 객체(변수, 메소드)를 가지고 있다면 내꺼 쓴다

class SuperC{
	
	private String title;
	private int area;
	
	public void set(String title, int area) {
		this.title = title;
		this.area = area;
		
	}
	
	public void print() {
		System.out.println(title+":"+area);
		
	}
	
}

//----------------------------------------------------------

class Rect extends SuperC{ //부모인 SuperC를 가져와서 쓰고싶을때
	
	private int w,h;
	
	//기본생성자는 숨어있음
	
	public Rect(int w, int h) { //오버로딩된 생성자 -> 초기화
		
		super();
		this.w = w;
		this.h = h;
		
	}
	
	public void rectArea() {
		
		int a = w*h;
		
		set("사각형", a); //부모꺼는 내꺼.
		
	}
	
}



//----------------------------------------------------------




public class Test1 {

	public static void main(String[] args) {
		
		Rect ob = new Rect(10, 20); //Rect 가져와서 쓰기.
		
		ob.rectArea();
		
		ob.print(); //부모인 SuperC의 메소드
		

	}

}
