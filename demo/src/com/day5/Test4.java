package com.day5;

import java.util.Scanner;

public class Test4 {

	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		
		int i,j,temp;
		int num[] = new int [5];
				
		System.out.print("�ټ����� ������ �Է��Ͻÿ�");
		
		for(i=0;i<num.length;i++) {
			num[i] = sc.nextInt();		
		}
		
		System.out.println("Source Data: ");
		for(i=0;i<num.length;i++) {
			System.out.printf("%4d",num[i]);
			
		}
		System.out.println();
		
		//Selection Sort
		for(i=0;i<num.length-1;i++) { // i=0,1,2,3
			
			for(j=i+1;j<num.length;j++) {
				
				if(num[i]>num[j]) {
					temp = num[i];
					num[i] = num[j];
					num[j] = temp;
					
					
				}
				
			}
			
			
		}
		System.out.println("Sorted Data: ");
		for(int su : num) { //Ȯ�� for�� = for each ��
			System.out.printf("%4d",su);
			
		}
		System.out.println();
		
		System.out.println("���� ���� �� : "+num[0]+", ���� ū �� : " +num[4]);
		
		
		
		
		

	}

}
