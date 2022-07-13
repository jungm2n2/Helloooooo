package com.naver;

import java.util.Scanner;



public class SignupMain {

	public static void main(String[] args) {
		
		SignupVO vo = new SignupVO();
		SignupImpl ob = new SignupImpl();
		Scanner sc = new Scanner(System.in);
		int ch;
		
		
		while(true) {
			
			do {
				System.out.print("1.입력 \n2.출력 \n3.아이디 검색 \n4.이름검색 \n5.정보수정 "+
								"\n6.회원삭제 \n7.종료");
				System.out.print("\n------------------------------\n");
				System.out.print(":  ");
				ch = sc.nextInt();
				
			} while(ch<1);
			
			
			switch(ch) {
				case 1:
					ob.input();break;
				case 2:
					ob.print();break;
				case 3:
					ob.findId();break;
				case 4:
					ob.findName();break;
				case 5:
					ob.updateId();break;
				case 6:
					ob.deleteId();break;
				default:
					System.out.println("시스템을 종료합니다");
							System.exit(0);

	}
}
}
}