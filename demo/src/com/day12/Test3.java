package com.day12;

import java.util.Calendar;
import java.util.Scanner;

public class Test3 {

	public static void main(String[] args) {
		
		//������ �������� x�� �� ��-��-��-����
		//�⵵? 2022
		//��? 6
		//��? 14
		//���� ��? 100
		//������ : 2022�� 6�� 14�� ȭ����
		//100�� �� : 2022�� ~�� ~�� ~����
		
		
		Calendar cal = Calendar.getInstance();
		int y,m,d,num1;
		String week [] = {"��","��","ȭ","��","��","��","��"};
		
		
		Scanner sc = new Scanner(System.in);
		
		do {
			System.out.print("�⵵?");
			y = sc.nextInt();
		}while(y<1);
		
		do {
			System.out.print("��?");
			m = sc.nextInt();
		}while(m<1||m>12);
		
		do {
			System.out.print("��?");
			d = sc.nextInt();
		}while(d<1||d>31);
		
		do{
			System.out.print("���� ��?");
			num1 = sc.nextInt();
		}while(num1<1);
		
		
		cal.set(y, m-1, d);
		
		int w = cal.get(Calendar.DAY_OF_WEEK);
		
		System.out.printf("���� �� : %d�� %d�� %d�� %s����\n",y,m,d,week[w-1]);
		
		
		
		cal.add(Calendar.DATE, num1);
		
		y = cal.get(Calendar.YEAR); //��
		m = cal.get(Calendar.MONTH)+1; //��(0~11)
		d = cal.get(Calendar.DATE); //��
		w = cal.get(Calendar.DAY_OF_WEEK); //���� ��(1~7:�Ͽ���->1)
		
		System.out.printf("%d�� �� : %d�� %d�� %d�� %s����",num1,y,m,d,week[w-1]);
		
		
	}

}
