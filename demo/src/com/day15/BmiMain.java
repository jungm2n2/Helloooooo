package com.day15;

import java.util.Scanner;

public class BmiMain {

	public static void main(String[] args) {
		
		int num;
		Scanner sc = new Scanner(System.in);
		BmiVO vo = new BmiVO();
		Bmi ob = new BmiImpl();
		
		while(true) {
			
			do {
				System.out.println("1.입력 2.출력 3.삭제 4.수정 5.회원검색 6.이름검색 7.종료");
				num = sc.nextInt();
			}while(num<1);
			
			
			switch (num) {
			case 1:
				ob.input();
				break;
			case 2:
				ob.print();
				break;
			case 3:
				ob.delet();			
				break;
			case 4:
				ob.update();
				break;
			case 5:
				ob.findnum();
				break;
			case 6:
				ob.findName();
				break;
			default:
				System.out.println("시스템을 종료합니다");
				System.exit(0);
		
			}
			
			
		}
		
		

	}

}
