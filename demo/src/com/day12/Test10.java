package com.day12;

class SuperTest{
	
	public int a=10, b=20;
	
	public void write() {
		System.out.println("슈퍼클래스 write()...");
		
	}
	public int hap() {
		
		return a+b;
	}
	
}
class SubTest extends SuperTest{
	
	public int b=100, c=200;
	
	public void print() {
		System.out.println("서브클래스 print() ");
		System.out.println(super.b+"안녕");
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
		System.out.println("합: "+ob2.hap()); //310
		
		ob2.write();
		
		//ob2.print(); 내꺼는 내꺼다
		
		((SubTest)ob2).print(); //다운캐스트
		ob2.write();

	}

}