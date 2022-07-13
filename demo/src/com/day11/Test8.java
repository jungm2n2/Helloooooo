package com.day11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/*class Sum{
	
	protected int num1,num2,result;
	protected String oper;
	
	public void write() {
		
		System.out.printf("%d %s %d = %d", num1,oper,num2,result);
		
	}
	
}


class Cals extends Sum{
	
	
	
	public void pan() throws IOException {
		
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("수식[3+5]?");
		String str = br.readLine();
		
		str = str.replaceAll("\\s", "");
		
		
		
		String [] op = {"+","-","*","/"};
		for(String o : op) {
		
		int pos = str.indexOf(o);
				
		if(pos>-1) {
			
			num1 = Integer.parseInt(str.substring(0, pos));
			num2 = Integer.parseInt(str.substring(pos+1));
			
			result = 0;
			char oper1 = str.charAt(pos); 
			oper = String.valueOf(oper1);
			
			switch(oper1) {
			
			case '+':
				result = num1+num2; break;
			case '-':
				result = num1-num2; break;
			case '*':
				result = num1*num2; break;
			case '/':
				result = num1/num2; break;
			
			}
			
			
		}
		
		
		
	}
	
	}
	
}



public class Test8 {

	public static void main(String[] args) throws IOException  {
		
		Cals ob = new Cals();
		ob.pan();
		ob.write();
		
		
	

	}

}



/*


public void input() {
	Scanner sc = new Scanner(System.in);
	
	System.out.println("두개의 수(10,20)");
	String su = sc.next();
	
	System.out.println("연산자 입력");
	oper = sc.next();
	
	su = su.replaceAll("\\s", "");
	String[] s = su.split(",");
	
	num1 = Integer.parseInt(s[0]);
	num2 = Integer.parseInt(s[1])
	
	
	
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


Calc ob = new Calc();
ob.input();
ob.calc();
ob.write();

*/