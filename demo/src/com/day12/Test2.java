package com.day12;

import java.util.Calendar;
import java.util.Scanner;

public class Test2 {

	public static void main(String[] args) {
		
		//����޷�
		
		Calendar cal = Calendar.getInstance();
		Scanner sc = new Scanner(System.in);
		int endDay = cal.getActualMaximum(Calendar.DATE);
		
		int y,m,i,week;
		
		do {
			System.out.print("�⵵?");
			y = sc.nextInt();
		}while(y<1);
		
		
		do {
			System.out.print("��?");
			m = sc.nextInt();
		}while(m<1||m>12);
		
		cal.set(y, m-1, 1);
		
		week = cal.get(Calendar.DAY_OF_WEEK);
		
		//System.out.println(week);
		
		
		//���
		String[]yoil = {"��","��","ȭ","��","��","��","��"};
		for(String yo:yoil) {
		System.out.printf("%4s",yo);
		}
		System.out.println();
		System.out.println("-------------------------------------");
		
		
		for(i=1;i<week;i++) {
			System.out.print("    ");
		}
		
		//for(i=1;i<=cal.getActualMaximum(Calendar.DATE);i++)
		
		for(i=1;i<endDay+1;i++) {
			System.out.printf("%4d",i);
			
			week++;
			
			if(week%7==1){
				System.out.println();
		 
		}
		
		}
		
		if(week%7!=1)
			System.out.println();
		
		System.out.println("------------------------------");

}
}