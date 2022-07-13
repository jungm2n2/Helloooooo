package com.score6;

import java.util.Scanner;

import com.db.DBConn;

public class ScoreMain {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int ch;
		Score ob = new Score(); //Score의 insert메소드 쓰기위해 객체생성
		
		while(true) {
			
			do {
				
				System.out.print("1.입력 2.수정 3.삭제 4.전체출력 5.학번검색 6.이름검색 7.종료");
				
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
				System.out.println("프로그램이 종료되었습니다");
				DBConn.close();
				System.exit(0);
			
			
			}
			
			
		}

	}

}
