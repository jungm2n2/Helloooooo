package com.day13;

//1.����Ŭ����(Inner)

class Outer1{
	
	static int a = 10;
	int b = 20;
	
	
//---------------------------------------------------------------------	
	public class Inner1{
		
		int c = 30;
		
		public void write() {
			System.out.println(a);
			System.out.println(b);
			System.out.println(c);
			
		}
		
		
		
	}
//--------------------------------------------------------------------	
	public void print() {
		System.out.println("print()...");
		
		
		Inner1 ob = new Inner1();
		ob.write();
		
		
	}
	
}
//--------------------------------------------------------------------
public class Test4 {
	
	

	public static void main(String[] args) {
		
		
		//�ܺ�Ŭ������ ��ü ������ �Ǿ��
		//����Ŭ������ ��ü�� ������ �� �ְ�
		//�ܺ�Ŭ������ ��ü�� ������ �Ǿ��ٰ� �ؼ�
		//�ڵ����� ����Ŭ������ ��ü�� �����Ǵ� ���� �ƴϴ�.
		
		Outer1 out = new Outer1();
		out.print();
		
		Outer1.Inner1 inner = out.new Inner1();
		inner.write();
		
		
		
	}

}
