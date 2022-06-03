package com.day6;

public class Test4 {

	public static void main(String[] args) {
		
		//Bubble Sort
		
		int num[] = {28,20,15,10,8};
		
		int i,j,temp;
		
		System.out.print("Source Data:");
		for(int su:num) {
			System.out.printf("%4d",su);
		}
		System.out.println();
		
		//Bubble Sort
		for(i=1;i<num.length;i++) {
			for(j=0;j<num.length-i;j++)
				
				//System.out.println(j+":"+(j+1));
				
				if(num[j]>num[j+1]) {
					temp = num[j];
					num[j] = num[j+1];
					num[j+1] = temp;
					
					
				}
			
			
		}
		
		
		System.out.print("Sorted Data:");
		for(int su:num) {
			System.out.printf("%4d",su);
		}
		System.out.println();
		
		
		

	}

}
