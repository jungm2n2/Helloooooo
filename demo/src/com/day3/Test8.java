package com.day3;

import java.util.Scanner;

public class Test8 {

	public static void main(String[] args) {
		
		//1.정수를 입력 받아서 짝수, 홀수를 구별해서 출력.
		//예) 3 입력시 -> 3 => 홀수
		//예) 4 입력시 -> 4 => 짝수
		
		Scanner sc = new Scanner(System.in);
		
		int su;
		
		System.out.print("숫자?");
		su = sc.nextInt();
		
		String str;
		
		str = su % 2 == 0? "짝수":"홀수";
		
		System.out.println(su+":"+str);
		
		
		
		
		

	}

}
