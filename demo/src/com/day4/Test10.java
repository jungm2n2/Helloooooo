package com.day4;

import java.util.Scanner;

public class Test10 {

	public static void main(String[] args) {
		
		//1. (1)+(1+2)+(1+2+3)+...+(1+2+3+...+10)
		//°á°ú : 220
		
		Scanner sc = new Scanner(System.in);
		
		int i,sum1,sum2;
		sum1=0;
		sum2=0;
		
		for(i=1;i<=10;i++) {
			sum1+=i;
			sum2+=sum1;
			
			
		}
		System.out.println(sum2);
			
      }
			
			
			

	
		
		
		
	

	}


