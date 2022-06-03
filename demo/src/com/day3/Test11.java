package com.day3;

import java.util.Scanner;

public class Test11 {

	public static void main(String[] args) {
		
		/*5.단가 15,800원짜리 상품을 일정 수량 이상 구입시 할인을 해줍니다.
		할인율은 다음과 같습니다.
		10개 이상 -> 10%
		20개 이상 -> 15%
		30개 이상 -> 20%
		판매금액을 계산해봅니다.
		예) 구입수량 15개인 경우 -> 구입수량: 15개, 판매총금액: 213300원
		*/
		
		Scanner sc = new Scanner(System.in);
		
		int num1;
		
		System.out.print("구입수량?");
		num1= sc.nextInt();
		
		if (num1<10) {
			System.out.printf("구입수량은 %d개, 판매 총 금액은 %d원 입니다.", num1,num1*15800);	
		}else if (num1>=10 && num1<20) {
			System.out.printf("구입수량은 %d개, 판매 총 금액은 %g원 입니다.", num1,num1*15800*0.9);
		}else if (num1>=20 && num1<30) {
			System.out.printf("구입수량은 %d개, 판매 총 금액은 %g원 입니다.", num1,num1*15800*0.85);
		}else  {
			System.out.printf("구입수량은 %d개, 판매 총 금액은 %g원 입니다.", num1,num1*15800*0.8);
		}
		
			
		
		
		
			
	}

}
