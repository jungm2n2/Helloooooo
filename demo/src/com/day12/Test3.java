package com.day12;

import java.util.Calendar;
import java.util.Scanner;

public class Test3 {

	public static void main(String[] args) {
		
		//오늘을 기준으로 x일 후 년-월-일-요일
		//년도? 2022
		//월? 6
		//일? 14
		//몇일 후? 100
		//만난날 : 2022년 6월 14일 화요일
		//100일 후 : 2022년 ~월 ~일 ~요일
		
		
		Calendar cal = Calendar.getInstance();
		int y,m,d,num1;
		String week [] = {"일","월","화","수","목","금","토"};
		
		
		Scanner sc = new Scanner(System.in);
		
		do {
			System.out.print("년도?");
			y = sc.nextInt();
		}while(y<1);
		
		do {
			System.out.print("월?");
			m = sc.nextInt();
		}while(m<1||m>12);
		
		do {
			System.out.print("일?");
			d = sc.nextInt();
		}while(d<1||d>31);
		
		do{
			System.out.print("몇일 후?");
			num1 = sc.nextInt();
		}while(num1<1);
		
		
		cal.set(y, m-1, d);
		
		int w = cal.get(Calendar.DAY_OF_WEEK);
		
		System.out.printf("만난 날 : %d년 %d월 %d일 %s요일\n",y,m,d,week[w-1]);
		
		
		
		cal.add(Calendar.DATE, num1);
		
		y = cal.get(Calendar.YEAR); //년
		m = cal.get(Calendar.MONTH)+1; //월(0~11)
		d = cal.get(Calendar.DATE); //일
		w = cal.get(Calendar.DAY_OF_WEEK); //주의 수(1~7:일요일->1)
		
		System.out.printf("%d일 후 : %d년 %d월 %d일 %s요일",num1,y,m,d,week[w-1]);
		
		
	}

}
