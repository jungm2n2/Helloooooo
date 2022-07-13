package com.day9;

//Overload = Overloading
//�޼ҵ� �ߺ� ����
//�ϳ��� Ŭ���� �ȿ��� ����� �۾��� �ϴ� �޼ҵ��� �̸��� ����������
//�Ű������� ������ �ٸ��ų� �ڷ����� �ٸ���
//�ٸ� �޼ҵ�� �ν��Ѵ�

class Rect{
	
	private int w,h;
	
	public void set(int w, int h) { //��ȸ����
		this.w = w; //�Է¹��� int w�� �������ֱ� ���� this ���
		this.h = h;//�Է¹��� int h�� �������ֱ� ���� this ���
		
	}
	
	
	public int area() {
		return w*h;
		
	}
	
	public int length() {
		return (w+h)*2;
		
	}
	
	public void print (int a, int l) {
		System.out.println("����: "+ w);
		System.out.println("����: "+ h);
		System.out.println("����: "+ a);
		System.out.println("�ѷ�: "+ l);
		
	}
	
	public void print() {
		System.out.println("����: "+ w);
		System.out.println("����: "+ h);
		
		
	}
	
	public void print(int a) {
		System.out.println("����: "+ w);
		System.out.println("����: "+ h);
		System.out.println("����: "+ a);
		
	}
	
	//public void dul(int l) { //���� �޼ҵ��� �ڷ����� ������ ���⶧���� dul�� print�� �ٲ� �� ����.
	public void print(double l) {	//�׷��� �ڷ����� double�� �ٲ��ְ� �޼ҵ带 ������ print�� �ٲ�
		System.out.println("����: "+ w);
		System.out.println("����: "+ h);
		System.out.println("�ѷ�: "+ l);
		
	}
	
}

public class Test1 {

	public static void main(String[] args) {
		
		Rect ob = new Rect(); //��ü����
		
		ob.set(10, 20);
		
		int area = ob.area();
		int length = ob.length();
		
		
		ob.print();
		ob.print(area);
		ob.print(area,length);
		ob.print((double)length);
	
		
	}

}
