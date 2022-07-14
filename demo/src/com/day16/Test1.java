package com.day16;

import java.util.InputMismatchException;
import java.util.Scanner;

//Exception Ŭ����(����ó��)


public class Test1 {

	public static void main(String[] args) {
		
		int num1,num2,result;
		
		String oper;
		
		Scanner sc = new Scanner(System.in);
		
		try {
			System.out.print("�ΰ��� ��?"); //30 40
			num1 = sc.nextInt();
			num2 = sc.nextInt();
			
			System.out.print("������?"); //+
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
			
			System.out.println("������ �Է��ϼ���");
			
		}catch(ArithmeticException e) {
			
			System.out.println(e.toString());
			
			System.out.println("0���� ���� �� �����ϴ�");
			
		} catch (Exception e) { //���� �������� �ɷ����� ������ ó���ϴ� �����? ����
			
			System.out.println(e.toString());
			
			//e.printStackTrace();
			
			System.out.println("�� ���� ����");
			
		}finally {
			System.out.println("�� �׻� ���δ�");
		}
		
		
		
		
		

	}

}