package com.day3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test1 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int num1, num2;
		
		System.out.print("첫번째 수?");
		num1 = Integer.parseInt(br.readLine());
		
		System.out.print("두번째 수?");
		num2 = Integer.parseInt(br.readLine());
		
		System.out.printf("%d + %d = %d\t" , num1,num2,num1+num2); //\n \t(탭):정규화 표현식. 공통적으로 인식됌
		System.out.printf("%d - %d = %d\n", num1, num2, num1-num2);
		System.out.printf("%d * %d = %d\t", num1, num2, num1*num2);
		System.out.printf("%d / %d = %d\n", num1, num2, num1/num2); //몫
		System.out.printf("%d %% %d = %d\n", num1, num2, num1%num2);//나머지
		
		// 부등호 : >, <, >=, <=, ==
		//숫자를 부등호로 비교하면 True 또는 False 문자가 생성된다.
		System.out.println("num1>num2 : " + (num1>num2)); //boolean값. True or False
		
		
		
		

	}

}
