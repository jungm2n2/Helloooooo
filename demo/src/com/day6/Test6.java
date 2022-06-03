package com.day6;

public class Test6 {

	public static void main(String[] args) {
		
		//배열의 배열
		int[][] arr = new int [6][6];
		
		int i,j;
		int n;
		
		n=0;
		for(i=0;i<5;i++) {
			
			for(j=0;j<5;j++) {
				
				//System.out.println(i+":"+j);
		
				n++;
				arr[i][j] = n;
				
				
				arr[i][5] +=n; 
				arr[5][j] +=n; 
				arr[5][5] +=n; 
				
			}
		}
		
		for(i=0;i<arr.length;i++) {
			for(j=0;j<arr.length;j++) {
				
				System.out.printf("%4d",arr[i][j]);
				
			}
			
			System.out.println();
		}
		
		System.out.println();
		System.out.println();
		
		
		
		//2차원 배열 초기화
		int[][] a = {{1,2,3},{4,5,6},{7,8,9}};
		int [][] b = {{9,8,7},{6,5,4},{3,2,1}};
		int [][] sum = new int [3][3];
		
		for(i=0;i<a.length;i++) {
			for(j=0;j<b.length;j++) {
				
				sum[i][j] = a[i][j] * b[i][j];
				
				System.out.printf("%4d",sum[i][j]);
			}
			System.out.println();
		}
		
		

	}

}
