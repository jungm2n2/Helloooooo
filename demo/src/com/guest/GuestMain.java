package com.guest;

import java.util.Scanner;

public class GuestMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int ch;
		
		while(true) {
			
			do {
				System.out.println("--------------����--------------");
				System.out.print("1.��� 2.��ȸ 3.���� 4.���� 5.����");
				ch = sc.nextInt();
			}while(ch<1||ch>5);
			
			
			switch (ch) {
			case 1 :
			case 2 :
			case 3 :
			case 4 :
			case 5 :
			
			}
			
		}
		
		
		
	}

	}


