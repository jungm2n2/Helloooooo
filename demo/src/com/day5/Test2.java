package com.day5;

import java.util.Scanner;

public class Test2 {

	public static void main(String[] args) {
		
		
		//배열로 만년달력
		
		Scanner sc = new Scanner(System.in);
		
		int months[] = {31,28,31,30,31,30,31,30,31,30,31};
		
		int y,m,nalsu,i,week;
		
		do {
			System.out.print("년도?");
			y = sc.nextInt();
		}while(y<1);
		
		do {
			System.out.print("월?");
			m = sc.nextInt();
		}while(m<1 || m>12);
		
		//y년이 윤년인지 확인
		if(y%4==0 && y%100!=0 || y%400==0) {
			months[1] = 29;
		}
		
		//1년1월1일 부터 (y-1)년 12월 31일 까지의 날 수
		nalsu = (y-1)*365 + (y-1)/4-(y-1)/100+(y-1)/400; //&& = - , || = +
		
		//int yy = (y-1)/4 - (y-1)/100+(y-1)/400;
		//System.out.println("날수:"+nalsu);
		//System.out.println("윤년:"+yy);
		
		
		//(m-1)월 까지의 날수
		//월(m)  : 1  2  3  4  5  6  7  8  9  10 11 12
		//months: {31,28,31,30,31,30,31,31,30,31,30,31};
		//index :   0  1 2  3  4  5  6  7  8  9  10 11
		for(i=0;i<m-1;i++) {
			nalsu += months[i];
			
			
		}
		//System.out.println(nalsu);
		
		
		//m월1일의 날수
		nalsu+=1;
		
		week = nalsu % 7;
		
		//System.out.println(week);
		
		System.out.println("\n  일  월  화  수  목  금  토");
		System.out.println("------------------------------");
		
		
		//특정요일부터 시작하도록 공백을 지정
	
		for(i=0;i<week;i++) {
			System.out.print("    "); //공백4칸
		}
		
		//
		for(i=1;i<=months[m-1];i++) {
			
			System.out.printf("%4d",i);
			
			
			week++;
			
			if(week%7==0){
				System.out.println();
		 
		    }		
			
		}		
		
		if(week%7!=0) {
			System.out.println();
		}
			
		System.out.println("------------------------------");
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
		

	}

}
