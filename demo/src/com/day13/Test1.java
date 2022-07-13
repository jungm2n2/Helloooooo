package com.day13;

//Interface
//1.추상클래스의 일종. 선언만 있고 정의가 없다
//2. final 변수만 정의할 수 있다
//3.인터페이스를 구현하려면 implements를 사용한다
//4.하나 이상의 인터페이스를 implements한 클래스는 인터페이스의 모든 메소드를 재정의 해야한다.
//5.인터페이스가 다른 인터페이스를 상속 받을 수 있으며 이때는 extends를 사용한다
//6.클래스와는 다르게 인터페이스는 다중상속이 가능하다

interface Fruit{
	
	String Won = "원"; //final변수이기 때문에 초기화 안하면 오류. public static final 생략되어있음
	
	int getPrice(); //public abstract이 생략되어 있음
	public String getName(); //abstract가 생략되어 있음
	
}

class FruitImpl implements Fruit { //무조건 오버라이드를 해야함

	@Override
	public int getPrice() {
		
		return 1000;
	}

	@Override
	public String getName() {
		
		return "사과";
	}
	
	public String getItems() {
		return "과일";
	}
	
	
}


public class Test1 {

	public static void main(String[] args) {
		
		FruitImpl ob1 = new FruitImpl();
		
		System.out.println(ob1.getItems());
		System.out.println(ob1.getName());
		System.out.println(ob1.getPrice()+Fruit.Won);
		
		Fruit ob2 = ob1; //자식이 부모에게
		
		System.out.println(ob2.getName());
		//System.out.println(ob2.getItems()); 부모가 자식꺼 쓸수없다

	}

}




