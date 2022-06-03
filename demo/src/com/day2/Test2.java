package com.day2;

public class Test2 {
	
	public static void main(String[] args) {
	
		//자료형 : int (정수)
		//num1 : 변수명
		int num1 = 20;//변수를 선언하면서 초기화 했다.
		int num2; //선언
		num2 = 10; //초기화
		
		int num3,num4;//쓰레기 값. 0(기본값)으로 초기화하면 컴파일 오류가 없음 (num3=0)
		
		System.out.println(num1);
		System.out.println(num2);
		//System.out.println(num3);컴파일 오류(쓰레기값은 보여주지 않음)
		//System.out.println(num4);
		
		num3 = num1 + num2;
		System.out.println(num3);
		
		num4 = num1-num2;
		System.out.println(num4);
		
		System.out.println(num1 + "+" + num2 + "=" + num3);
		System.out.println(num1 + "-" + num2 + "=" + num4);
		
		
		num1 = 200;
		num2 = 100;
		System.out.println(num1 + "+" + num2 + "=" + num3);
		System.out.println(num1 + "-" + num2 + "=" + num4);
		
		//f = format 형식을 만드는 것
		System.out.printf("%d+%d=%d%n" ,num1,num2,num3);
		System.out.printf("%d-%d=%d" ,num1,num2,num3);
		System.out.println();
		
		System.out.printf("%d+%d=%d%n", num1, num2, num3);
		
		
		
	}

}
	