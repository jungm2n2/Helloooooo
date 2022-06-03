package com.day3;

import java.util.Scanner;

public class Test5 {
	
	// else if 문 / 조건여러개 = 작업여러개

	public static void main(String[] args) {

		
		Scanner sc = new Scanner(System.in);
		
		String name;
		int kor;
		
		System.out.print("이름?");
		name = sc.next();
		
		System.out.print("국어?");
		kor = sc.nextInt();
		
		String pan; //"가" 초기값지정 
		//else if 문은 큰 값이 위에, 작은 값이 아래에 오도록.
		
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
		
		
		
		System.out.println(name+"의 국어 점수는 "+kor+"점이고, "+
		"환산 점수는 ("+pan+") 입니다.");
		System.out.printf("%s의 국어 점수는 %d점이고, 환산 점수는 (%s) 입니다", name,kor,pan);
		
		
	}

}


