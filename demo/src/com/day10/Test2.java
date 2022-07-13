package com.day10;

//상속(부모가 자식한테 주는것)
//1.부모꺼는 내꺼다.
//2.private로 선언한 것은 상속이 안됨
//3.protected로 선언한 것은 상속이 가능하다
//4.내꺼는 내꺼다
//5.부모와 같은 객체를 가지고 있다면 내꺼 쓴다

class SuperB{
	
	private String title;
	protected int area;
	
	public void set(String title) {
		this.title = title;
	
		
	}
	
	public void print() {
		System.out.println(title+":"+area);
		
	}
	
}




//----------------------------------------------------------

class RectB extends SuperB{ //부모인 SuperB를 가져와서 쓰고싶을때
	
	private int w,h;
	
	//기본생성자는 숨어있음
	
	public RectB(int w, int h) { //오버로딩 -> 초기화
		this.w = w;
		this.h = h;
		
	}
	
	public void rectArea() {
		
		area = w*h; //protected로 선언한 것은 상속이 가능하다
		set("사각형"); //부모꺼는 내꺼.
		
	}
	
}



//----------------------------------------------------------




public class Test2 {

	public static void main(String[] args) {
		
		RectB ob = new RectB(100, 200); //Rect 가져와서 쓰기.
		
		ob.rectArea();
		
		ob.print(); //부모인 SuperB의 메소드
		

	}

}
