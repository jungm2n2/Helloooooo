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
				System.out.println("--------------방명록--------------");
				System.out.print("1.등록 2.조회 3.전체조회 4.수정 5.삭제 6.종료");
				ch = sc.nextInt();
			}while(ch<1||ch>5);
			
			
			switch (ch) {
			case 1 :ob.write();break;
			case 2 :ob.search();break;
			case 3 :ob.printAll();break;
			case 4 :ob.update();break;
			case 5 :ob.delete();break;
			case 6 :
				System.out.println("프로그램을 종료합니다");
				DBConn.close();
				System.exit(0);
			
			}
			
		}
		
		
		
	}

	}


