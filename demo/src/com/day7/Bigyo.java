package com.day7;

import java.util.Scanner;

public class Bigyo {
	int num1,num2;
	
	
	public void input() {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("�ΰ��� ������ �Է��Ͻÿ�");
		num1 = sc.nextInt();
		num2 = sc.nextInt();
	}
	
	public void print() {
		
		if (num1>num2) {
			System.out.printf("ū���� %d, �������� %d �Դϴ�.", num1,num2);
		}else {
			System.out.printf("ū���� %d, �������� %d �Դϴ�.", num2,num1);
			
		}
		
		

	
	
	
	
	}

	}


/*�� ���� ������ �Է� �ް�, ū ���ڿ� ���� ���ڸ� �����ؼ� ���.(if�� �̿�)
//��) 20, 30 �Է½� -> ū ���� 30, ���� ���� 20


Scanner sc = new Scanner(System.in);

int num1, num2;

System.out.print("���� �ΰ�?");
num1 = sc.nextInt();
num2 = sc.nextInt();


if (num1>num2) {
	System.out.printf("ū���� %d, �������� %d �Դϴ�.", num1,num2);
}else {
	System.out.printf("ū���� %d, �������� %d �Դϴ�.", num2,num1);
}
	*/


