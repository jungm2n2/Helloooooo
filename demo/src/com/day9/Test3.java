package com.day9;

class RectA{
	
	private int w,h;
	
	public RectA() {} //�⺻������
		
	public RectA(int w, int h) { //��ȸ���� ���� �ٷ� �ʱ�ȭ. �����ε��� ������
		
		this.w = w;
		this.h = h;
				
	}
	
	public void set(int w, int h) {//�⺻������ -> ��ȸ����. �ʱ�ȭ �޼ҵ�
		this.w = w;
		this.h = h;
	}
	
	public int area() {
		return w*h;
	}
	
	public int length() {
		return (w+h)*2;
	}
	
	public void print(int a) {
		System.out.println("����: "+w+",����: "+h);
		System.out.println("����: "+a);

	}
	
	//�޼ҵ� �����ε�
	public void print(int a, int l) {//�Ű����� ������ �ٸ��� �ؼ� �����ε�
		System.out.println("����: "+w+",����: "+h);
		System.out.println("����: "+a);
		System.out.println("�ѷ�: "+l);
		
	}
	
	
}

public class Test3 {

	public static void main(String[] args) {
		
		RectA ob1 = new RectA(); //�⺻������
		ob1.set(10, 20); //�⺻�����ڴ� ��ȸ���θ� ���� �ʱ�ȭ.
		int a = ob1.area();
		int l = ob1.length();
		ob1.print(a);
		ob1.print(a, l);
		
		System.out.println("-----------------------");
		
		RectA ob2 = new RectA(100, 200); //�����ε��� 
		a = ob2.area();
		l = ob2.length();
		ob2.print(a);
		ob2.print(a, l);
		
		
		
		
		
		
		

	}

}
