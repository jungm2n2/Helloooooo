package com.day3;

import java.util.Scanner;

public class Test12 {

	public static void main(String[] args) {
		
		/*6. �̸��� 3������ ������ �Է� �޾� �������ǿ� ���� ���
		-��� ������ ������ 40�� �̻��̰� ����� 60�� �̻��̸� �հ�
		-�Ѱ����̶� 40�� �̸��̰� ����� 60�� �̻��̸� ����
		-����� 60�� �̸��̸� ���հ�

	�̸� ? ȫ�浿
	������ ���� ? 60 70 80
	�̸� : ȫ�浿
	���� : 210, ��� : 70, ���� :�հ�
		*/

		
		Scanner sc = new Scanner(System.in);
		
		String name;
		int num1,num2,num3;
		
		System.out.print("�̸�?");
		name = sc.next();
		
		System.out.print("������ ����?");
		num1 = sc.nextInt();
		num2 = sc.nextInt();
		num3 = sc.nextInt();
		
		if ((num1+num2+num3)/3<60) {
			System.out.printf("����:%d, ���%d, ����:���հ�", num1+num2+num3,(num1+num2+num3)/3);
		} else if (num1>=40&&num2>=40&&num3>=40 && (num1+num2+num3)/3>=60) {
			System.out.printf("����:%d, ���%d, ����:�հ�", num1+num2+num3,(num1+num2+num3)/3); 
		} else if (num1<40||num2<40||num3<40 && (num1+num2+num3)/3>=60) {
			System.out.printf("����:%d, ���%d, ����:����", num1+num2+num3,(num1+num2+num3)/3);
		 
		}
	
		
		
		
		
		
		
		
	}

}
