package com.day6;

import java.util.Scanner;

public class Test5 {

	public static void main(String[] args) {

		
		Scanner sc = new Scanner(System.in);
		
		
		//jumin : 900110-2053126
		//index : 01234567890123
		//chk   : 234567 892345
		
		//합=(9*2)+(0*3)+...+(2*5)
		//합=11-합%11
		//합=합%10
		//합==6
		
		
		String jumin;
		int chk[] = {2,3,4,5,6,7,8,9,2,3,4,5}; 
		int i,tot,su;
	
		
		System.out.print("주민번호[xxxxxx-xxxxxxx]?");
		jumin = sc.next();
		
		if(jumin.length()!=14) {
			System.out.println("입력 오류!!");
			return; //stop = 프로그램 종료. 메인 메소드를 빠져나옴.
		
		}
		
		tot=0;
		
		
		//jumin : 900110-2053126
		//index : 1234567890123
		//chk   : 234567 892345
		
		
		
		for(i=0;i<12;i++) {
			
			if(i>=6) {//뒤자리
				tot += chk[i]*Integer.parseInt(jumin.substring(i+1,i+2));
				
			}else {//생년월일
				tot += chk[i]*Integer.parseInt(jumin.substring(i,i+1));
			}
			
			
		}
		
		
		
		su = 11 - tot % 11;
		su = su % 10;
		
		if(su==Integer.parseInt(jumin.substring(13))) {
			System.out.println("대한민국 국민입니다");
		}else {
			System.out.println("넌 누구냐?");
		}

	}

}



/*
		
		String str = "seoul korea";
		//index :     01234567890 
		
		System.out.println(str.substring(0,3));//0번째~(3-1)번째 index 출력
		System.out.println(str.substring(6,8));
		System.out.println(str.substring(6)); //6번째 index 부터 끝까지 출력
		

*/