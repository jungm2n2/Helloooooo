package com.day10;

//���(�θ� �ڽ����� �ִ°�)
//1.�θ𲨴� ������.
//2.private�� ������ ���� ����� �ȵ�
//3.protected�� ������ ���� ����� �����ϴ�
//4.������ ������
//5.�θ�� ���� ��ü(����, �޼ҵ�)�� ������ �ִٸ� ���� ����

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

class Rect extends SuperC{ //�θ��� SuperC�� �����ͼ� ���������
	
	private int w,h;
	
	//�⺻�����ڴ� ��������
	
	public Rect(int w, int h) { //�����ε��� ������ -> �ʱ�ȭ
		
		super();
		this.w = w;
		this.h = h;
		
	}
	
	public void rectArea() {
		
		int a = w*h;
		
		set("�簢��", a); //�θ𲨴� ����.
		
	}
	
}



//----------------------------------------------------------




public class Test1 {

	public static void main(String[] args) {
		
		Rect ob = new Rect(10, 20); //Rect �����ͼ� ����.
		
		ob.rectArea();
		
		ob.print(); //�θ��� SuperC�� �޼ҵ�
		

	}

}
