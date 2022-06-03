package com.day5;

import java.util.Scanner;

public class Test1 {

	public static void main(String[] args) {
		
		
		//배열
		
		//int[] num = new int[5];
		
		Scanner sc = new Scanner(System.in);
		int num [] = new int [5];
		
		System.out.print(num.length + "개의 정수를 입력하시오");
		
		for(int i=0;i<num.length;i++) {
			num[i] = sc.nextInt();
			System.out.println("num[" +i+ "] : " + num[i]);
		}	
		  
	
		//System.out.println("배열의 갯수 : " +num.length + "개");
		
		//num[0] = sc.nextInt();
		//num[1] = sc.nextInt();
		//num[2] = sc.nextInt();
		//num[3] = sc.nextInt();
		//num[4] = sc.nextInt();
		
		
	
			
			
			
		// num[5] = 60;
	
		System.out.println("배열의 갯수 : " +num.length + "개"); //num.length -> () 괄호가 없음
		
		
     //   for(int i=0;i<num.length;i++) {
			
			//System.out.println("num[1] : " + num[1]);
			//System.out.println("num[2] : " + num[2]);
			//System.out.println("num[3] : " + num[3]);
			//System.out.println("num[4] : " + num[4]);
			//System.out.println("num[5] : " + num[5]);
        
        
        
		num[3] = 400;
		System.out.println("num[3] : " + num[3]);
		
		int su = num[1];
		System.out.println(su + ":" + num[1]);
		
		
		num[4] = num[0] + num[1];
	
		System.out.println("num[4] : "+ num[4]);
		
	

	
	
 }

}

