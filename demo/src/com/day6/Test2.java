package com.day6;

import java.util.Random;

public class Test2 {

	public static void main(String[] args) {
		
		//1~45까지의 수 중 6개의 난수를 발생시켜 크기순으로 정렬

		Random rd = new Random();
		
		int[] num = new int[6];
		
		int i,j,temp,n;
		
		n=0;
		
		while(n<6) {//중복이 나오면 다시 돌려야 하기 때문에 몇번 돌릴지 몰라서 for문이 아니라 while문 사용
			
			num[n] = rd.nextInt(45)+1;
			
			for(i=0;i<n;i++) {
				
				if(num[i]==num[n]) {
					n--;
					break;
				}
					
			}
			
			n++;
			
			
		}
		
		
       for(i=0;i<num.length-1;i++) { // i=0,1,2,3
			
			for(j=i+1;j<num.length;j++) {
				
				if(num[i]>num[j]) {
					temp = num[i];
					num[i] = num[j];
					num[j] = temp;
					
				}
			}
				
		}
		
	
		for(int su : num) {
			System.out.printf("%4d",su);
		}
		
		
		
		

	}

}
