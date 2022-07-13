package com.day10;

//���(�θ� �ڽ����� �ִ°�)
//1.�θ𲨴� ������.
//2.private�� ������ ���� ����� �ȵ�
//3.protected�� ������ ���� ����� �����ϴ�
//4.������ ������
//5.�θ�� ���� ��ü�� ������ �ִٸ� ���� ����

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

class RectB extends SuperB{ //�θ��� SuperB�� �����ͼ� ���������
	
	private int w,h;
	
	//�⺻�����ڴ� ��������
	
	public RectB(int w, int h) { //�����ε� -> �ʱ�ȭ
		this.w = w;
		this.h = h;
		
	}
	
	public void rectArea() {
		
		area = w*h; //protected�� ������ ���� ����� �����ϴ�
		set("�簢��"); //�θ𲨴� ����.
		
	}
	
}



//----------------------------------------------------------




public class Test2 {

	public static void main(String[] args) {
		
		RectB ob = new RectB(100, 200); //Rect �����ͼ� ����.
		
		ob.rectArea();
		
		ob.print(); //�θ��� SuperB�� �޼ҵ�
		

	}

}
