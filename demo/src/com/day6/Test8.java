package com.day6;

import java.util.Random;
import java.util.Scanner;

public class Test8 {

	public static void main(String[] args) {
		
		Random rd = new Random();
		Scanner sc = new Scanner(System.in);
		
		int n;
		int com = rd.nextInt(3)+1;
		String play[] = {"����","����","��"};
		
		
	
		
		System.out.print("1:����, 2:����, 3:�� ?");
		n = sc.nextInt();
		
		System.out.printf("��ǻ�� : %s, ��� : %s\n",play[com-1],play[n-1]);
		
		if(com-n==1) {
		System.out.print("��ǻ�Ͱ� �̰���ϴ�");
		}else if(com==n) {
		System.out.println("�����ϴ�");	
		}else if(n-com==1) {
			System.out.print("����� �̰���ϴ�");
		}else if(com-n==2) {
			System.out.print("����� �̰���ϴ�");
		}else if(n-com==2) {
			System.out.println("��ǻ�Ͱ� �̰���ϴ�");
		}
		
			
		
		
		
		
	
			
		
		

	}

}
