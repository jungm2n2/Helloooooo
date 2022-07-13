package com.day10;



class Super{
	
	private String title;
	protected double area;
	
	public Super() {} //�⺻������ (Recta)
	
	public Super(String title) { //�����ε��� ������ (Circle)
		this.title = title;	
	}
	
	public void write() {
		System.out.println(title+":"+area);
		
	}
	
	
	
}

class Circle extends Super{ //Recta�� �ƹ� ���赵 �ƴ�. �θ��� Super���� ��ӹ������� ��.
	
	private int r;
	protected static final double PI = 3.14; //final = ���. ��!!�ʱ�ȭ�ؾ���. ���� �ٲ� �� ���� ��.
	
	public Circle(int r) {
		
		//super(); �θ��� �⺻�����ڸ� ã�ư�. ��������.
		super("��"); //�θ��� �����ε��� �����ڸ� ã�ư�
		this.r = r;
		
		
	}
	public void circleArea() {
		
		area=r*r*PI;
		
	}
	
}


class Recta extends Super{ //Circle�� �ƹ� ���赵 �ƴ�. �θ��� Super���� ��ӹ������� ��.
	
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
	//����Ŭ������ ���ǵǾ� �ִ� �޼ҵ带 ������ �Ѵ�.(Ŭ������ ������)
	//@Override //������̼�(annotation)
	@Override
	public void write() {
		System.out.println("����: "+w);
		System.out.println("����: "+h);
		System.out.println("����: "+area);
	
	
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
