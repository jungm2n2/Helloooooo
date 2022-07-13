package com.day10;



class Super{
	
	private String title;
	protected double area;
	
	public Super() {} //기본생성자 (Recta)
	
	public Super(String title) { //오버로딩된 생성자 (Circle)
		this.title = title;	
	}
	
	public void write() {
		System.out.println(title+":"+area);
		
	}
	
	
	
}

class Circle extends Super{ //Recta와 아무 관계도 아님. 부모인 Super에게 상속받은것일 뿐.
	
	private int r;
	protected static final double PI = 3.14; //final = 상수. 꼭!!초기화해야함. 절대 바꿀 수 없는 수.
	
	public Circle(int r) {
		
		//super(); 부모의 기본생성자를 찾아감. 숨어있음.
		super("원"); //부모의 오버로딩된 생성자를 찾아감
		this.r = r;
		
		
	}
	public void circleArea() {
		
		area=r*r*PI;
		
	}
	
}


class Recta extends Super{ //Circle과 아무 관계도 아님. 부모인 Super에게 상속받은것일 뿐.
	
	private int w,h;
	
	//public Recta() {
	//	super();
	//}
	
	public void rectArea(int w, int h) {
		this.w = w;
		this.h = h;
		
		area = w*h;
		
	}
	
	
		


	
	
	
	//Override
	//상위클래스에 정의되어 있는 메소드를 재정의 한다.(클래스의 다형성)
	//@Override //어노테이션(annotation)
	@Override
	public void write() {
		System.out.println("가로: "+w);
		System.out.println("세로: "+h);
		System.out.println("넓이: "+area);
	
	
	}
	
}





public class Test {

	public static void main(String[] args) {
		
		Circle c = new Circle(10);
		c.circleArea();
		c.write();
		
		Recta r = new Recta();
		r.rectArea(10, 20);
		r.write();
		

	}

}
