package com.day5;

import java.util.Scanner;

public class Test3 {

	public static void main(String[] args) {
		
		//��(y), ��(m), ��(d) �Է��ϸ�
		//2022�� 6�� 2�� -> �����
		
		
				Scanner sc = new Scanner(System.in);
				
				int months[] = {31,28,31,30,31,30,31,30,31,30,31};
				String weeks[] = {"��","��","ȭ","��","��","��","��"};
				int y,m,d,nalsu,i,week;
				
				do {
					System.out.print("�⵵?");
					y = sc.nextInt();
				}while(y<1);
				
				do {
					System.out.print("��?");
					m = sc.nextInt();
				}while(m<1 || m>12);
				
				do {
					System.out.print("��?");
					d = sc.nextInt();
				}while(d<1 || d>31);
				
				//y���� �������� Ȯ��
				if(y%4==0 && y%100!=0 || y%400==0) {
					months[1] = 29;
				}
				
				//1��1��1�� ���� (y-1)�� 12�� 31�� ������ �� ��
				nalsu = (y-1)*365 + (y-1)/4-(y-1)/100+(y-1)/400; //&& = - , || = +
				
				//int yy = (y-1)/4 - (y-1)/100+(y-1)/400;
				//System.out.println("����:"+nalsu);
				//System.out.println("����:"+yy);
				
				
				//(m-1)�� ������ ����
				//��(m)  : 1  2  3  4  5  6  7  8  9  10 11 12
				//months: {31,28,31,30,31,30,31,31,30,31,30,31};
				//index :   0  1 2  3  4  5  6  7  8  9  10 11
				for(i=0;i<m-1;i++) {
					nalsu += months[i];
					
					
				}
				//System.out.println(nalsu);
				
				
				//m��d���� ����
				nalsu+=d;
				
				
				
				week = nalsu % 7;
				
				  
				System.out.printf("%d�� %d�� %d���� %s���� �Դϴ�",y,m,d,weeks[week]);
				
				
				
					
		
		
		
		
		
		
		

	}

}
