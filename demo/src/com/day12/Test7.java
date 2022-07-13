package com.day12;

//추상 클래스
//메모리의 낭비 없이 클래스를 미리 설계
//메소드를 재정의(오버라이드) 해서 사용한다

abstract class ShapeClass{ //추상클래스
	
	public abstract void draw(); //추상메소드가 반드시 하나 있어야 함
								 //메소드의 내용은 정의하지 않고 껍데기만 만들어 놓음
								 //기본이 protected
	}

class Cir extends ShapeClass{

	@Override
	public void draw() { //오버라이드 반드시 해줘야 한다
		System.out.println("원을 그리다");
	}
	
}

class Rect extends ShapeClass{

	@Override
	public void draw() {
		System.out.println("사각형을 그리다");
	}
	
	
}

class Tri extends ShapeClass {
	@Override
	public void draw() {
		System.out.println("삼각형을 그리다");
	}
	
	
}

public class Test7 {

	public static void main(String[] args) {
		
		Cir c = new Cir();
		Rect r = new Rect();
		Tri t = new Tri();
		
		
		c.draw();
		r.draw();
		t.draw();
		
		

	}

}
