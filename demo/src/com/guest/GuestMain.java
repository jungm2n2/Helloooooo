package com.guest;

import java.util.Scanner;

import com.db.DBConn;

public class GuestMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int ch;
		Guest ob = new Guest();
		
		
		while(true) {
			
			do {
				System.out.println("--------------����--------------");
				System.out.print("1.��� 2.��ȸ 3.��ü��ȸ 4.���� 5.���� 6.����");
				ch = sc.nextInt();
			}while(ch<1||ch>5);
			
			
			switch (ch) {
			case 1 :ob.write();break;
			case 2 :ob.search();break;
			case 3 :ob.printAll();break;
			case 4 :ob.update();break;
			case 5 :ob.delete();break;
			case 6 :
				System.out.println("���α׷��� �����մϴ�");
				DBConn.close();
				System.exit(0);
			
			}
			
		}
		
		
		
	}

	}


