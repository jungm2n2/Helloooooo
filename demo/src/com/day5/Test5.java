package com.day5;

import java.util.Scanner;

public class Test5 {

	public static void main(String[] args) {
		
		int i, j, temp;
		int num [] = new int [5];
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("�ټ������� ���ڸ� �Է����ּ���");
		for(i=0;i<num.length;i++) {
			num[i]=sc.nextInt();
		}
		
		System.out.println("�Է¹��� ���� : ");
		for(i=0;i<num.length;i++) {
			System.out.printf("%4d",num[i]);
		}
		
		for(i=0;i<num.length-1;i++) {
			for(j=i+1;j<num.length;j++) {
				if(num[i]>num[j]) {
					temp=num[i];
					num[i]=num[j];
					num[j]=temp;
				}
				
		
			}
			
			
		}
		System.out.println();
		System.out.println("���� ū ��:"+num[4]+" ���� ���� ��:"+num[0]);
		

	}

}
