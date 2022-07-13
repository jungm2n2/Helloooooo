package com.day12;

class SuperTest{
	
	public int a=10, b=20;
	
	public void write() {
		System.out.println("����Ŭ���� write()...");
		
	}
	public int hap() {
		
		return a+b;
	}
	
}
class SubTest extends SuperTest{
	
	public int b=100, c=200;
	
	public void print() {
		System.out.println("����Ŭ���� print() ");
		System.out.println(super.b+"�ȳ�");
		System.out.println(b);
	}
	
	@Override
	public int hap() {
		
		return a+b+c;
	}
}



public class Test10 {

	public static void main(String[] args) {
		
		SubTest ob1 = new SubTest();
		
		System.out.println("ob1.b: "+ ob1.b); //100
		
		
		
		SuperTest ob2 = ob1; //upcast
		//SuperTest ob2 = (SuperTest)ob1;
		
		System.out.println(ob1);
		System.out.println(ob2);
		
		System.out.println(((SuperTest)ob1).b);
		
		System.out.println("ob2.b : "+ ob2.b); //20
		System.out.println("ob1.b : "+ ob1.b);
		System.out.println("��: "+ob2.hap()); //310
		
		ob2.write();
		
		//ob2.print(); ������ ������
		
		((SubTest)ob2).print(); //�ٿ�ĳ��Ʈ
		ob2.write();

	}

}