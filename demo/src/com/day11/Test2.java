package com.day11;

//String : 기본자료형이 아니고 class이다.
//저장할 데이터는 크고, 사용빈도는 높기때문에
//String은 불변의 법칙을 가지고있다

public class Test2 {

	public static void main(String[] args) {
		
		String ob1 = "Seoul";//
		String ob2 = "Seoul";//같은 문자여서 주소를 공유함
		String ob3 = new String("Seoul");
		
		System.out.println("ob1==ob2: "+(ob1==ob2)); //Call by Reference
		System.out.println("ob1==ob3: "+(ob1==ob3));
		System.out.println("ob1.equals(ob3): "+ob1.equals(ob3)); //String의 equals:
		                                                         //주소가 아닌 데이터를 비교하는 equals.(오버라이딩)
		                                                         
		ob2 = "Korea";
		System.out.println("ob1==ob2: "+(ob1==ob2));
		
		ob2 = "Japan";
		System.out.println("ob1==ob2: "+(ob1==ob2));
		
		ob2 = "China";
		System.out.println("ob1==ob2: "+(ob1==ob2));
		
		ob2 = "Seoul";
		System.out.println("ob1==ob2: "+(ob1==ob2));
		
		System.out.println(ob2);
		System.out.println(ob2.toString());
		
		
		
		

	}

}
