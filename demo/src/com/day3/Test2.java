package com.day3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test2 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int su = 0;
		
		System.out.print("수 입력?");
		su = Integer.parseInt(br.readLine());
		
		String str;
		
		//삼항연산자(조건? 조건의 값이 true : 조건의 값이 false)
		str = su % 2 == 0 ? "짝수" : "홀수";
		
		str = su>0 ? "양수" : (su <0 ?"음수" : "영");
		
		
		//A(조건) && B(조건) (A and B) : A,B 둘다 true일때 true
		//A || B (A or B) : A 또는 B 둘중에 하나만 ture 이면 ture
		str = su % 4 == 0 && su % 100 !=0 || su % 400 == 0 ? "윤년" : "평년";
			//!= (같지 않다) == <-> !=
		
		
		System.out.println(su+":"+str);
		
		
		
		
		
		
		
		
	}

}
