package com.day11;

import java.util.Scanner;

class Sum{
	
	protected int num1,num2,result;
	protected String oper;
	
	public void write() {
		
		System.out.printf("%d %s %d = %d", num1,oper,num2,result);
		
	}
	
} 

class Cals extends Sum{
	
	public void input() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("두개의 수(10,20)");
		String su = sc.next();
		
		System.out.println("연산자 입력");
		oper = sc.next();
		
		su = su.replaceAll("\\s", "");
		String[] s = su.split(",");
		
		num1 = Integer.parseInt(s[0]);
		num2 = Integer.parseInt(s[1]);
		
		
		
	}


	public void calc() {
		
		if(oper.equals("+")) 
			result = num1+num2;
			else if (oper.equals("-")) 
				result = num1-num2;
			else if (oper.equals("*")) 
				result = num1*num2;
			else if (oper.equals("/")) 
				result = num1/num2;
		
		
	}
	
	


}

public class Test10 {

	public static void main(String[] args) {
		
		Cals ob = new Cals();
		ob.input();
		ob.calc();
		ob.write();

	}

}
