package com.day11;


//Object : 모든 클래스의 최상위 부모
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
		
		System.out.println("ob1==ob2: "+(ob1==ob2)); //== : 주소비교
		System.out.println("ob1.equals(ob2): "+ob1.equals(ob2));
		
		//해쉬코드[클래스이름@해쉬코드]
		System.out.println("ob1: "+ob1);
		System.out.println("ob2: "+ob2);
		
		System.out.println("ob1.toString(): "+ob1.toString()); //toString(문자로 바꿔서 보여달라)
		
	
	}

}
