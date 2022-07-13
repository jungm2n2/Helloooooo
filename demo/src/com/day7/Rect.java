package com.day7;

import java.util.Scanner;

public class Rect {
	
	int w,h; //전역변수,instance 변수. 초기값이 자동으로 들어가있음.
	public void input() {
		
		Scanner sc = new Scanner(System.in);
		//int w,h; //지역변수
		
		System.out.print("가로값?");//10
		w = sc.nextInt();
		
		System.out.print("세로값?");//20
		h = sc.nextInt();
		
		//return; void에는 생략가능. 반환값이 없기 때문.
	}
	
	//넓이 구하기
	public int area() {
		
		
		int result;
		
		result = w*h;
		
		return result;
		
		
		
		
	}
	
	//둘레구하기
	public int length() {
		
		return (w+h)*2;
		
		
		
	}
	
	//출력
	public void print (int a, int l) {//매개변수
		
		System.out.println("가로: "+ w);
		System.out.println("세로: "+ h);
		System.out.println("넓이: "+ a);
		System.out.println("둘레: "+ l);
		
		
	}

}

//Class는 자료형
