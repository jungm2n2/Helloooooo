package com.score6;

import java.util.Scanner;

import com.db.DBConn;

public class ScoreMain {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int ch;
		Score ob = new Score(); //Score�� insert�޼ҵ� �������� ��ü����
		
		while(true) {
			
			do {
				
				System.out.print("1.�Է� 2.���� 3.���� 4.��ü��� 5.�й��˻� 6.�̸��˻� 7.����");
				
				ch = sc.nextInt();
			}while(ch<1||ch>7);
			
			switch(ch) {
			
			case 1 : ob.insert();break;
			case 2 : ob.update();break;
			case 3 : ob.delete();break;
			case 4 : ob.selectAll();break;
			case 5 : ob.searchHak();break;
			case 6 : ob.searchName();break;
			default:
				System.out.println("���α׷��� ����Ǿ����ϴ�");
				DBConn.close();
				System.exit(0);
			
			
			}
			
			
		}

	}

}
