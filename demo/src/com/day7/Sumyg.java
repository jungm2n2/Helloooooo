package com.day7;

import java.util.Scanner;

public class Sumyg {
	
	
	String name,pan;
	int kor;
	
	public void input() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("이름?");
		name = sc.next();
		System.out.print("국어 점수?");
		kor = sc.nextInt();
		
	}
	
	public String pan() {
		
		if(kor>=90) {
			pan = "수";
		}else if(kor>=80) {
			pan = "우";
		}else if(kor>=70) {
			pan = "미";
		}else if(kor>=60) {
			pan = "양";
		}else {
			pan= "가";
		}
		String result;
		result = pan;
		return pan;
	}
	
	public void print(String pan) {
		
		System.out.printf("%s의 국어 점수는 %d점이고, 환산 점수는 %s 입니다", name,kor,pan);
		
	}

}
