package com.day4;

import java.util.Scanner;

public class Test9 {

	public static void main(String[] args) {
		
		
		//수를 입력받아 1에서부터 입력받은 수 까지의 합계를 구하시오
		//10이면 1~10까지의 합계
		
        Scanner sc = new Scanner(System.in);
		
		int num1,sum;
		
		sum=0;
		
		System.out.print("숫자?");
		num1 = sc.nextInt();
		
		for(int i=1;i<=num1;i++) {
			sum=sum+i;
			
		}
		System.out.printf("1~%d까지의 합계는 %d입니다.",num1,sum);

	}

}
