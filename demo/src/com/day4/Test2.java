package com.day4;

import java.io.IOException;
import java.util.Scanner;

public class Test2 {

	public static void main(String[] args) throws IOException {
		
		//수를 입력받아 1에서부터 입력받은 수 까지의 합계를 구하시오
		
		
		Scanner sc = new Scanner(System.in);
		
		int su,sum=0;
		char ch;
		
		
		while(true){ //무한루프
			
		
			
			do {
				System.out.print("수를 입력 하시오"); //10
				su = sc.nextInt();
			
			}while(su<1 || su>5000);  //su는 1보다 작으면 안돼, su는 5000보다 크면 안돼. False일때 빠져나옴
			                          //True이면 위로 올라가서 다시 수를 입력하게 만드는 것.
			
			
			sum=0;
			for(int i=1;i<=su;i++) {
				
				sum=sum+i;
				
			}
			
			
			System.out.println("1~"+su+"까지의 합:"+sum);
			
			System.out.print("계속할래?[Y/N]"); //y,Y,n,N,1,A,아니요
			ch = (char)System.in.read();
			
			if(ch!='y'&&ch!='Y') { //y가 아니고, Y가 아니면
				                   //양쪽이 부정이면 || -> &&
				
				System.out.println("프로그램 종료");
				
				break; //무한루프를 깨는 것.
				//while,do~while,for,switch 에만 쓸 수 있다
			}
			
		
		}	
		
	}

}
