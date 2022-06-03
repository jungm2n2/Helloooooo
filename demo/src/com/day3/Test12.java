package com.day3;

import java.util.Scanner;

public class Test12 {

	public static void main(String[] args) {
		
		/*6. 이름과 3과목의 점수를 입력 받아 다음조건에 따라 출력
		-모든 과목의 점수가 40점 이상이고 평균이 60점 이상이면 합격
		-한과목이라도 40점 미만이고 평균이 60점 이상이면 과락
		-평균이 60점 미만이면 불합격

	이름 ? 홍길동
	세과목 점수 ? 60 70 80
	이름 : 홍길동
	총점 : 210, 평균 : 70, 판정 :합격
		*/

		
		Scanner sc = new Scanner(System.in);
		
		String name;
		int num1,num2,num3;
		
		System.out.print("이름?");
		name = sc.next();
		
		System.out.print("세과목 점수?");
		num1 = sc.nextInt();
		num2 = sc.nextInt();
		num3 = sc.nextInt();
		
		if ((num1+num2+num3)/3<60) {
			System.out.printf("총점:%d, 평균%d, 판정:불합격", num1+num2+num3,(num1+num2+num3)/3);
		} else if (num1>=40&&num2>=40&&num3>=40 && (num1+num2+num3)/3>=60) {
			System.out.printf("총점:%d, 평균%d, 판정:합격", num1+num2+num3,(num1+num2+num3)/3); 
		} else if (num1<40||num2<40||num3<40 && (num1+num2+num3)/3>=60) {
			System.out.printf("총점:%d, 평균%d, 판정:과락", num1+num2+num3,(num1+num2+num3)/3);
		 
		}
	
		
		
		
		
		
		
		
	}

}
