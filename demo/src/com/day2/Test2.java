package com.day2;

public class Test2 {
	
	public static void main(String[] args) {
	
		//�ڷ��� : int (����)
		//num1 : ������
		int num1 = 20;//������ �����ϸ鼭 �ʱ�ȭ �ߴ�.
		int num2; //����
		num2 = 10; //�ʱ�ȭ
		
		int num3,num4;//������ ��. 0(�⺻��)���� �ʱ�ȭ�ϸ� ������ ������ ���� (num3=0)
		
		System.out.println(num1);
		System.out.println(num2);
		//System.out.println(num3);������ ����(�����Ⱚ�� �������� ����)
		//System.out.println(num4);
		
		num3 = num1 + num2;
		System.out.println(num3);
		
		num4 = num1-num2;
		System.out.println(num4);
		
		System.out.println(num1 + "+" + num2 + "=" + num3);
		System.out.println(num1 + "-" + num2 + "=" + num4);
		
		
		num1 = 200;
		num2 = 100;
		System.out.println(num1 + "+" + num2 + "=" + num3);
		System.out.println(num1 + "-" + num2 + "=" + num4);
		
		//f = format ������ ����� ��
		System.out.printf("%d+%d=%d%n" ,num1,num2,num3);
		System.out.printf("%d-%d=%d" ,num1,num2,num3);
		System.out.println();
		
		System.out.printf("%d+%d=%d%n", num1, num2, num3);
		
		
		
	}

}
	