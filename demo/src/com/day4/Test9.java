package com.day4;

import java.util.Scanner;

public class Test9 {

	public static void main(String[] args) {
		
		
		//���� �Է¹޾� 1�������� �Է¹��� �� ������ �հ踦 ���Ͻÿ�
		//10�̸� 1~10������ �հ�
		
        Scanner sc = new Scanner(System.in);
		
		int num1,sum;
		
		sum=0;
		
		System.out.print("����?");
		num1 = sc.nextInt();
		
		for(int i=1;i<=num1;i++) {
			sum=sum+i;
			
		}
		System.out.printf("1~%d������ �հ�� %d�Դϴ�.",num1,sum);

	}

}
