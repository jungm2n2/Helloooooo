package com.day16;

import java.util.InputMismatchException;
import java.util.Scanner;

//Exception 클래스(예외처리)


public class Test1 {

	public static void main(String[] args) {
		
		int num1,num2,result;
		
		String oper;
		
		Scanner sc = new Scanner(System.in);
		
		try {
			System.out.print("두개의 수?"); //30 40
			num1 = sc.nextInt();
			num2 = sc.nextInt();
			
			System.out.print("연산자?"); //+
			oper = sc.next();
			
			result = 0;
			if(oper.equals("+"))
				result = num1+num2;
			else if (oper.equals("-"))
				result = num1-num2;
			else if	 (oper.equals("*"))
				result = num1*num2;
			else if(oper.equals("/"))
					result = num1/num2;
			
			System.out.printf("%d %s %d = %d\n",num1,oper,num2,result);
			
		} catch (InputMismatchException e) {
			
			System.out.println(e.toString());
			
			System.out.println("정수를 입력하세요");
			
		}catch(ArithmeticException e) {
			
			System.out.println(e.toString());
			
			System.out.println("0으로 나눌 수 없습니다");
			
		} catch (Exception e) { //위에 오류에서 걸러지지 않으면 처리하는 사장님? 역할
			
			System.out.println(e.toString());
			
			//e.printStackTrace();
			
			System.out.println("그 밖의 에러");
			
		}finally {
			System.out.println("난 항상 보인다");
		}
		
		
		
		
		

	}

}
