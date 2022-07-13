package com.day11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test9 {

	public static void main(String[] args) throws IOException {
		
		int num1,num2,result;
		result=0;
		String answer;
		
		BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("연산식을 입력해주세요");
		answer = rd.readLine();
		answer = answer.replaceAll("\\s", "");
		
		String str[] = {"+","-","*","/"};
		
		for(String s:str) {
			int a = answer.indexOf(s);
			
			if(a>-1) {
				num1 = Integer.parseInt(answer.substring(0, a));
				num2 = Integer.parseInt(answer.substring(a+1));
				
				char ch = answer.charAt(a);
				
				switch (ch){
				case '+':
					result = num1+num2; break;
				case '-':
					result = num1-num2; break;
				case '*':
					result = num1*num2; break;
				case '/':
					result = num1/num2; break;
						
					
				}
				
				System.out.printf("%d %c %d = %d",num1,ch,num2,result);
				
			}
		}
		
		
		
		
		

	}

}
