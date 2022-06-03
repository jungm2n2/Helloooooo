package com.day5;

import java.util.Scanner;

public class Test4 {

	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		
		int i,j,temp;
		int num[] = new int [5];
				
		System.out.print("다섯개의 정수를 입력하시요");
		
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
		for(int su : num) { //확장 for문 = for each 문
			System.out.printf("%4d",su);
			
		}
		System.out.println();
		
		System.out.println("가장 작은 값 : "+num[0]+", 가장 큰 값 : " +num[4]);
		
		
		
		
		

	}

}
