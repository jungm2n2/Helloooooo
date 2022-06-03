package com.day6;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Test7 {

	public static void main(String[] args) throws IOException {
		
		//1~10사이의 난수를 발생시켜 발생시킨 난수를 3번안에 알아 맞추는 게임
		//(3번안에 알아맞추지 못하면 발생된 난수를 출력)
		
		Random rd = new Random();
		Scanner sc = new Scanner(System.in);
		int i,j,answer;
		char yn;
		int num = rd.nextInt(10)+1;
		
		
		while (true) {
			for(i=1;i<=3;i++) {
				System.out.printf("정수입력?[%d번째기회]",i);
				answer = sc.nextInt();
				
				if(answer!=num) {
					System.out.println("틀렸어요!");
				} else {
					System.out.println("맞았어요");
					
		
				
				}
				
			}
			System.out.println("정답은"+num+"입니다.");
			
			System.out.print("계속할래?[Y/N]"); 
			yn = (char)System.in.read();
			
			if(yn=='n'|| yn=='N') {
				
				System.out.println("프로그램 종료");
				break;
			}
			else if (yn=='y' || yn=='Y');
			System.out.println("---------------------");
					
				
				
				
		}
			
			
			
		}
	
		
		
	

	

}
