package com.day5;

import java.util.Scanner;

public class Test5 {

	public static void main(String[] args) {
		
		int i, j, temp;
		int num [] = new int [5];
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("다섯가지의 숫자를 입력해주세요");
		for(i=0;i<num.length;i++) {
			num[i]=sc.nextInt();
		}
		
		System.out.println("입력받은 숫자 : ");
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
		System.out.println("가장 큰 수:"+num[4]+" 가장 작은 수:"+num[0]);
		

	}

}
