package com.day3;

import java.util.Scanner;

public class Test11 {

	public static void main(String[] args) {
		
		/*5.�ܰ� 15,800��¥�� ��ǰ�� ���� ���� �̻� ���Խ� ������ ���ݴϴ�.
		�������� ������ �����ϴ�.
		10�� �̻� -> 10%
		20�� �̻� -> 15%
		30�� �̻� -> 20%
		�Ǹűݾ��� ����غ��ϴ�.
		��) ���Լ��� 15���� ��� -> ���Լ���: 15��, �Ǹ��ѱݾ�: 213300��
		*/
		
		Scanner sc = new Scanner(System.in);
		
		int num1;
		
		System.out.print("���Լ���?");
		num1= sc.nextInt();
		
		if (num1<10) {
			System.out.printf("���Լ����� %d��, �Ǹ� �� �ݾ��� %d�� �Դϴ�.", num1,num1*15800);	
		}else if (num1>=10 && num1<20) {
			System.out.printf("���Լ����� %d��, �Ǹ� �� �ݾ��� %g�� �Դϴ�.", num1,num1*15800*0.9);
		}else if (num1>=20 && num1<30) {
			System.out.printf("���Լ����� %d��, �Ǹ� �� �ݾ��� %g�� �Դϴ�.", num1,num1*15800*0.85);
		}else  {
			System.out.printf("���Լ����� %d��, �Ǹ� �� �ݾ��� %g�� �Դϴ�.", num1,num1*15800*0.8);
		}
		
			
		
		
		
			
	}

}
