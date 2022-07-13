package com.excep;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ExceptionMain {

	public static void main(String[] args) {
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		String str;
		double num1,num2,result;
		
		OperationAuthenticator auth = new OperationAuthenticator();
		
		try {
			
			System.out.print("�ΰ��� ��?[a,b]");
			str = br.readLine();
			
			//����ó��
			auth.inputFormat(str);
			
			String[] temp = str.split(",");
			
			//����ó��
			auth.number(temp[0]);
			num1 = Double.parseDouble(temp[0]);
			
			//����ó��
			auth.number(temp[1]);
			num2 = Double.parseDouble(temp[1]);
			
			System.out.print("������?");
			str=br.readLine();
			
			//����ó��
			auth.operator(str.charAt(0));
			
			char ch = str.charAt(0);
			
			result = 0;
			if(ch=='+')
				result = num1+num2;
			else if (ch=='-')
				result = num1-num2;
			else if	 (ch=='*')
				result = num1*num2;
			else if(ch=='/')
					result = num1/num2;
			
			System.out.printf("%g %c %g = %g\n",num1,ch,num2,result);
			
			
			
		} catch (Exception e) {
			System.out.println(e.toString());
			
		}
		
		
		
		
		
		
		
		

	}

}
