package com.day11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test6 {
	
	

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("수식[3+5]?");
		String str = br.readLine();
		
		str = str.replaceAll("\\s", ""); //i=i+1
		
		String [] op = {"+","-","*","/"};
		for(String o : op) {
		//for(String op : new String[] {"+","-","*","/"}) {
			
			
			//123+56
			//012345
			int pos = str.indexOf(o);
			
			if(pos>-1) {
				
				int num1 = Integer.parseInt(str.substring(0, pos));//123
				int num2 = Integer.parseInt(str.substring(pos+1));//56
				//String값을 정수로 바꿈 -> Integer.parseInt
				
				int result = 0;
				char oper = str.charAt(pos); //+
				
				switch(oper) {
				
				case '+':
					result = num1+num2; break;
				case '-':
					result = num1-num2; break;
				case '*':
					result = num1*num2; break;
				case '/':
					result = num1/num2; break;
				
				}
				
				//System.out.printf("%d %c %d = %d",num1,oper,num2,result);
				String s = String.format("%d %c %d = %d",num1,oper,num2,result);
				
				System.out.println(s);
			}
		
		
		
		}
		
		
	}

}
