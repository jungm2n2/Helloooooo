package com.day6;

import java.util.Random;
import java.util.Scanner;

public class Test8 {

	public static void main(String[] args) {
		
		Random rd = new Random();
		Scanner sc = new Scanner(System.in);
		
		int n;
		int com = rd.nextInt(3)+1;
		String play[] = {"가위","바위","보"};
		
		
	
		
		System.out.print("1:가위, 2:바위, 3:보 ?");
		n = sc.nextInt();
		
		System.out.printf("컴퓨터 : %s, 사람 : %s\n",play[com-1],play[n-1]);
		
		if(com-n==1) {
		System.out.print("컴퓨터가 이겼습니다");
		}else if(com==n) {
		System.out.println("비겼습니다");	
		}else if(n-com==1) {
			System.out.print("사람이 이겼습니다");
		}else if(com-n==2) {
			System.out.print("사람이 이겼습니다");
		}else if(n-com==2) {
			System.out.println("컴퓨터가 이겼습니다");
		}
		
			
		
		
		
		
	
			
		
		

	}

}
