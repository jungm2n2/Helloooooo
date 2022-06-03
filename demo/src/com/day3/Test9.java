package com.day3;

import java.util.Scanner;

public class Test9 {

	public static void main(String[] args) {
		
		
		//두 개의 정수를 입력 받고, 큰 숫자와 작은 숫자를 구분해서 출력.(if문 이용)
		//예) 20, 30 입력시 -> 큰 숫자 30, 작은 숫자 20

		
		Scanner sc = new Scanner(System.in);
		
		int num1, num2;
		
		System.out.print("숫자 두개?");
		num1 = sc.nextInt();
		num2 = sc.nextInt();
		
		
		if (num1>num2) {
			System.out.printf("큰수는 %d, 작은수는 %d 입니다.", num1,num2);
		}else {
			System.out.printf("큰수는 %d, 작은수는 %d 입니다.", num2,num1);
		}
			
	
		
	
		
	}

}
