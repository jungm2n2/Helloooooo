package com.day4;

import java.util.Scanner;

public class Test7 {

	public static void main(String[] args) {
		
		//switch
		
		/*Scanner sc = new Scanner(System.in);
		
		int su;
		
		System.out.print("1~3이내의 수?");
		su = sc.nextInt();

		switch(su) {	
		
		case 3:
			System.out.println("***");
			break;
		case 2:
			System.out.println("**");
			break;
		case 1:
			System.out.println("*");
			break;
		default:
			System.out.println("숫자 입력 오류!!");
			break;
		*/
		    Scanner sc = new Scanner(System.in);
		    int su;
		 
			System.out.print("1~3이내의 수?");
			su = sc.nextInt();

			switch(su) {	
			
			case 100:
				//System.out.println("수");  //break를 빼는 경우도 있음
				//break;
			case 90:
				System.out.println("수");
				break;
			case 80:
				System.out.println("우");
				break;
			default:
				System.out.println("숫자 입력 오류!!");
				break;
	
		}
		

	}

}
