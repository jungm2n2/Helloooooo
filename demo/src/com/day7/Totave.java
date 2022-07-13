package com.day7;

import java.util.Scanner;

public class Totave {
	
	String name;
	int math,eng,kor;
	
	public void input() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("이름? 수학? 영어? 국어?");
		name = sc.next();
		math = sc.nextInt();
		eng = sc.nextInt();
		kor = sc.nextInt();

	}
	
	public int tot() {
		
		int result;
		result = math+eng+kor;
		return result;
		
		
	}
	
	public int ave() {
		
		return (math+eng+kor)/3;
		
	}
	
	public void print(int t, int a) {
		
		System.out.println("이름 : "+name);
		System.out.println("수학 점수? : "+math);
		System.out.println("영어 점수? : "+eng);
		System.out.println("국어 점수? : "+kor);
		System.out.println("총점 : "+t);
		System.out.println("평균 : "+a);
	}

}
