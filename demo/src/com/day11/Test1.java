package com.day11;


//Object : ��� Ŭ������ �ֻ��� �θ�
class Test extends Object{
	private int a=10;
	
	public void write() {
		System.out.println("a: "+a);
	}
	
	
}


public class Test1 {

	public static void main(String[] args) {
		
		Test ob1 = new Test();
		Test ob2 = new Test();
		
		System.out.println("ob1==ob2: "+(ob1==ob2)); //== : �ּҺ�
		System.out.println("ob1.equals(ob2): "+ob1.equals(ob2));
		
		//�ؽ��ڵ�[Ŭ�����̸�@�ؽ��ڵ�]
		System.out.println("ob1: "+ob1);
		System.out.println("ob2: "+ob2);
		
		System.out.println("ob1.toString(): "+ob1.toString()); //toString(���ڷ� �ٲ㼭 �����޶�)
		
	
	}

}
