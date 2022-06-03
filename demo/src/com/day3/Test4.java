package com.day3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test4 {

	public static void main(String[] args) throws  IOException {
		
		//제어문
		//if, 반복문(for, while, do~while), switch
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int num;
		String  str = ""; //null로 초기화
		
		System.out.print("수 입력");
		num = Integer.parseInt(br.readLine());
		
		//if(조건식){작업} = 단일if문 조건1에 작업1 //단일if문은 초기화 시키기
		
		/*if(num%2==0) {
			str = "짝수";
			
		}
		
		if(num%2!=0) // or (num%2==1) {
			str = "홀수";
			
		}
		*/
		
		
		//if~else (조건1에 조건2)
		
		if(num%2==0) {
			str = "짝수";
		}else {
			str = "홀수";
		
		}
		
		System.out.println(num + ":" + str);
		
		

	}

}
